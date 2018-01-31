/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaManoControl;

import SegundaMano.Articulos;
import SegundaMano.Comentarios;
import SegundaMano.Usuario;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author Hector Gonzalez Guerreiro
 * @version 2.0
 */
@WebServlet(name = "Control", urlPatterns = {"/Home", "/FAltaUser",
    "/comprobarCorreo", "/darAlta", "/deslog", "/login", "/VerUser", "/EditUser",
    "/FArticulo", "/VerArticulos", "/MostrarFoto", "/GuardarArticulo",
    "/MostrarArticulos", "/VerArticulos", "/ArticulosPagina", "/FLogin",
    "/filtro", "/ArticulosInfo", "/subirComentario", "/Favoritos", "/FavoritosPagina"})

@MultipartConfig
public class Control extends HttpServlet {

    @PersistenceContext(unitName = "SegundaManoPU")
    private EntityManager em;
    private final int NUM_ARTICULOS = 20;

    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* Variables */
            String accion = request.getServletPath();
            String vista = null;
            HttpSession session = request.getSession();

            /*------------*/
            switch (accion) {
                case "/FAltaUser":                                              //  Envia el formulario de alta
                    vista = "vistas/AltaUsuario.jsp";                           //  Para el usuario.              
                    break;
                case "/FLogin":                                                 //  Envia el formulario de login
                    vista = "vistas/Login.jsp";                                 //  para el usuario        
                    break;
                case "/darAlta":
                    vista = GuardarUsuario(request, session);                   //  Da de alta un usuario.
                    break;
                case "/deslog":                                                 //  El usuario se desconecta.
                    session.invalidate();
                    vista = "Home.jsp";
                    break;
                case "/login":
                    vista = UserLogin(request, session);                        //  El usuario entra en el sistema
                    break;
                case "/VerUser":
                    vista = VerUser(request, session);                          //  Se muestra informacion referente al
                    break;                                                      //  del usuario.    
                case "/EditUser":
                    vista = EditarUser(request);
                    break;
                case "/comprobarCorreo":                                        // Sistema que permite verificar el correo
                    ComprobarCorreo(request);                                   // del usuario (si existe ya en la base de datos)
                    vista = "vistas/comun/CorreoValido.jsp";
                    break;
                case "/FArticulo":                                              //  El Sistema envia un nuevo formulario de alta de 
                    vista = "vistas/AltaArticulo.jsp";                          //  articulo.
                    break;
                case "/GuardarArticulo":                                        // El sistema guarda el articulo y envia informacion
                    GuardarArticulo(request, session);                          // de que pagina quiere ver. Se le envia a la vista articulo.
                    request.setAttribute("np", 0);
                    MostrarArticulos(request);
                    vista = "vistas/Articulos.jsp";
                    break;
                case "/VerArticulos":                                           // Si le damos a ver articulo sin seleccionar ninguna pagina.
                    request.setAttribute("np", 0);
                    MostrarArticulos(request);
                    vista = "vistas/Articulos.jsp";
                    break;
                case "/ArticulosPagina":                                        // Si le damos a ver una pagina en concreto
                    request.setAttribute("np", request.getParameter("np"));
                    MostrarArticulos(request);
                    vista = "vistas/Articulos.jsp";
                    break;
                case "/MostrarArticulos":
                    request.setAttribute("np", request.getParameter("np"));     // El sistema envia la informacion necesaria para poder mostrar
                    MostrarArticulos(request);                                  // el listado de articulos que existe.
                    //filtrar(request, response);
                    vista = "vistas/Articulos.jsp";
                    break;
                case "/filtro":
                    request.setAttribute("np", request.getParameter("np"));
                    filtrar(request, response);
                    vista = "vistas/Articulos.jsp";
                    break;
                case "/ArticulosInfo":
                    MostrarInfoArticulo(request, session);
                    vista = "vistas/DetalleArticulo.jsp";
                    break;
                case "/subirComentario":
                    SubirComentario(request,session);
                    vista = "vistas/comun/comentarios.jsp";
                    break;
                case "/Favoritos":
                    request.setAttribute("np", 0);
                    //MostrarFavoritos(request,response,session);
                    vista = "vistas/Favoritos.jsp";
                    break;
                case "/FavoritosPagina":                                        // Si le damos a ver una pagina en concreto
                    request.setAttribute("np", request.getParameter("np"));
                    MostrarFavoritos(request);
                    vista = "vistas/comun/ManejaFavoritos.jsp";
                    break;
                default:
                    vista = "Home.jsp";
                    break;
            }

            RequestDispatcher rd = request.getRequestDispatcher(vista);
            rd.forward(request, response);

        }
    }
    
    
    /**
     * Para poder subir un comentario necesto saber el articulo y el usuario en ese momento del tiempo.
     * los demas datos me lo administra la peticion.
     * Necesito realizar 2 peticiones el de articulo para obtenerlo, la forma de obtnerlo es pasandolo por parametro en la
     * llamada del Ajax.
     * El usuario forma parte de la session es obligatorio que este este conectado.
     * @param request
     * @param response
     * @param session 
     */
    
    
    private void  SubirComentario(HttpServletRequest request, HttpSession session){
        boolean privado = Boolean.valueOf(request.getParameter("privado"));
        boolean publico = Boolean.valueOf(request.getParameter("publico"));
        boolean personal = Boolean.valueOf(request.getParameter("personal"));
        String texto = request.getParameter("comentario");
        Long identificador_Articulo = Long.valueOf(request.getParameter("id_articulo"));
        String nick = (String) session.getAttribute("user");
        
        TypedQuery<Articulos> query_Articulo = em.createNamedQuery("Articulos.findById",Articulos.class);
        List<Articulos> lr;

        query_Articulo.setParameter("IdenArticulo", identificador_Articulo);
        lr = query_Articulo.getResultList();
        
        TypedQuery<Usuario> queryUsuario = em.createNamedQuery("Usuario.findUser",Usuario.class);
        List<Usuario> lu;
        
        queryUsuario.setParameter("name", nick);
        lu = queryUsuario.getResultList();
        
        Usuario usuario = lu.get(0);
        Articulos articulo = lr.get(0);
        
        Comentarios comentario = new Comentarios();
        
        if(privado) comentario.setPrivaciadad("privado");
        else if(publico) comentario.setPrivaciadad("publico");
        else comentario.setPrivaciadad("personal");
        
        comentario.setArt_Comit(articulo);
        comentario.setUser_Comit(usuario);
        comentario.setTexto(texto);
        persist(comentario);
        
        //------------------------------------------------------------------------------------------------//
        
        TypedQuery<Comentarios> query_Comentarios = em.createNamedQuery("Comentarios.findByIdWitchUser", Comentarios.class);
        List<Comentarios> lc;
        query_Comentarios.setParameter("IdenUser", usuario.getId());
        query_Comentarios.setParameter("IdenArticulo", articulo.getId());
        lc = query_Comentarios.getResultList();
        request.setAttribute("comentarios", lc);
        request.setAttribute("User", usuario.getName());
        
        ArrayList<Usuario> listaUser = new ArrayList<>();
        lc.forEach((comentarios) -> {
            listaUser.add(comentarios.getUser_Comit());
        });
        request.setAttribute("ListaUser", listaUser);
          
    }
    
    /**
     * Para mostrar la info de un articulo necesito obtener el articulo y el vendedor en cuestion, para ello le administro
     * al metodo de la id del articulo para que busque la informacion en la base de datos.
     * 
     * Puede que no halla sesion del usuario para ello solo deberia mostrar los comentarios de caracter publico.
     * @param request
     * @param session 
     */
    private void MostrarInfoArticulo(HttpServletRequest request, HttpSession session){
        Long Articulo = Long.valueOf(request.getParameter("IdenArticulo"));
        TypedQuery<Articulos> queryArticulo = em.createNamedQuery("Articulos.findById", Articulos.class);
        List<Articulos> lr;
        
        
        queryArticulo.setParameter("IdenArticulo", Articulo);
        lr = queryArticulo.getResultList();
        Articulos articulo = lr.get(0);
        
        TypedQuery<Comentarios> queryComentarios;
        List<Comentarios> lc;
        
        if(session.getAttribute("id") != null){
            queryComentarios = em.createNamedQuery("Comentarios.findByIdWitchUser", Comentarios.class);
            queryComentarios.setParameter("IdenArticulo", Articulo);
            queryComentarios.setParameter("IdenUser", session.getAttribute("id"));
            lc = queryComentarios.getResultList();
        }
        else{
            queryComentarios = em.createNamedQuery("Comentarios.findById", Comentarios.class);
            queryComentarios.setParameter("IdenArticulo", Articulo);
            lc = queryComentarios.getResultList();
        }
        
        request.setAttribute("Articulo", articulo);
        request.setAttribute("Usuario", articulo.getArt());
        request.setAttribute("comentarios", lc);
        ArrayList<Usuario> listaUser = new ArrayList<>();
        lc.forEach((comentarios) -> {
            listaUser.add(comentarios.getUser_Comit());
        });
        request.setAttribute("ListaUser", listaUser);
        
        
        

        
    }
    
    private void GuardarArticulo(HttpServletRequest request, HttpSession session) {
        try {
            String opcCategoria = request.getParameter("parent_category");
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("Des");
            String Estado = request.getParameter("parent_estade");
            int year = Integer.valueOf(request.getParameter("y"));
            float Precio = Float.valueOf(request.getParameter("p"));

            Part fotoPart = request.getPart("f");
            int fotoSize = (int) fotoPart.getSize(); //si no tiene tamaño, no hay foto

            byte[] foto = null; //el buffer
            if (fotoSize > 0) {
                foto = new byte[fotoSize];
                try (DataInputStream dis = new DataInputStream(fotoPart.getInputStream())) {
                    dis.readFully(foto);

                } catch (IOException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Articulos articulo = new Articulos();
            articulo.setAño(year);
            articulo.setCategoria(opcCategoria);
            articulo.setDescripcion(descripcion);
            articulo.setEstado(Estado);
            articulo.setNombreArticulo(nombre);
            articulo.setPrecio(Precio);
            articulo.setImagen(foto); //lo guardamos en la entidad

            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findUser", Usuario.class);
            query.setParameter("name", session.getAttribute("user"));
            List<Usuario> lu;
            lu = query.getResultList();
            Usuario u = lu.get(0);
            articulo.setArt(query.getResultList().get(0));
            List<Articulos> list = u.getArticulos();
            list.add(articulo);
            persist(articulo);

        } catch (IOException | ServletException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void filtrar(HttpServletRequest request, HttpServletResponse response) {
        String where = "";
        boolean change = false;

        String nombre = request.getParameter("parent_category");
        String pmenor = request.getParameter("p");
        String pmayor = request.getParameter("pm");
        String cp = request.getParameter("CP");
        
        if (!"".equals(nombre) && !"NA".equals(nombre)){
            if(change)
                where += " AND a.categoria LIKE '" + nombre + "%'";
            else
                where += " WHERE a.categoria LIKE '" + nombre + "%'";
            change = true;
        }
        
        
        if (!"".equals(pmenor)){
            if(change)
                where += " AND a.precio > " + pmenor;
            else
                where += " WHERE a.precio > " + pmenor;
            change = true;
        }

        if (!"".equals(pmenor)){
            if(change)
                where += " AND a.precio < " + pmayor;
            else 
                where += " WHERE a.precio < " + pmayor;
            change = true;
        }
        
        if(!"".equals(cp)){
                if(change)
                    where += " AND a.art.CP= " + cp;
                else
                    where += " WHERE a.art.CP= " +cp;
            change = true;
        }
        
        TypedQuery<Articulos> ql;
        
        if(change)
            ql = em.createQuery("SELECT a FROM Articulos a join fetch a.art " + where, Articulos.class);
        else 
            ql = em.createNamedQuery("Articulos.findByAll", Articulos.class);
       
        this.EnviarTrozo(request, ql.getResultList());
            
    }
    
     private void MostrarArticulos(HttpServletRequest request) {
        TypedQuery<Articulos> query;
        query = em.createNamedQuery("Articulos.findByAll", Articulos.class);
        this.EnviarTrozo(request,query.getResultList());
    }
    
     /*Falta por implementar */
    private String EditarUser(HttpServletRequest request) {
        String nick = request.getParameter("IDcorreo");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("Direccion");
        String Codigo_Posta = request.getParameter("CP");
        String Faceboock = request.getParameter("FA");
        String Twiter = request.getParameter("TW");
        String NumeroTelefono = request.getParameter("Telefono");
        return null;

    }
    

    private String GuardarUsuario(HttpServletRequest request, HttpSession session) {
        try {
            String nick = request.getParameter("IDcorreo");
            String pass = request.getParameter("pass");
            String nombre = request.getParameter("name");
            String direccion = request.getParameter("Direccion");
            String Codigo_Posta = request.getParameter("CP");
            String Faceboock = request.getParameter("FA");
            String Twiter = request.getParameter("TW");
            String NumeroTelefono = request.getParameter("Telefono");

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            pass = sb.toString();

            Usuario u = new Usuario();
            u.setNick(nick);
            u.setPass(pass);
            if (!Codigo_Posta.isEmpty())  u.setCP(Integer.valueOf(Codigo_Posta));
            
            if (!NumeroTelefono.isEmpty()) u.setTelefono(Long.valueOf(NumeroTelefono));
            
            
            u.setName(nombre);
            u.setDireccion(direccion);
            u.setTwiter(Twiter);
            u.setFaceboock(Faceboock);
            
            persist(u);
            session.setAttribute("user", u.getNick());
            session.setAttribute("id", u.getId());
            
            return "Home.jsp";
        } catch (NoSuchAlgorithmException ex) {
            request.setAttribute("msg", "NO");
            return "/vistas/comun/AltaUserERROR.jsp";
        }
    }
    
    private String UserLogin(HttpServletRequest request, HttpSession session) {
        try {
            String nick = request.getParameter("nick");
            String pass = request.getParameter("pass");

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            
            for (byte b : digest) sb.append(String.format("%02x", b & 0xff));
            
            pass = sb.toString();

            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByNameAndPass", Usuario.class);
            query.setParameter("name", nick);
            query.setParameter("pwd", pass);
            List<Usuario> lu;
            lu = query.getResultList();

            if (!lu.isEmpty()) {
                Usuario u = lu.get(0);
                session.setAttribute("user", u.getNick());
                session.setAttribute("id", u.getId());
                request.setAttribute("msg", "OK");
                return "Home.jsp";
            } else {
                request.setAttribute("msg", "NO");
                return "vistas/Login.jsp";
            }
        } catch (NoSuchAlgorithmException ex) { 
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Home.jsp";

    }
    
    private void ComprobarCorreo(HttpServletRequest request) {
        String elemento = request.getParameter("id");
        TypedQuery<Usuario> query;
        List<Usuario> lr;
        
        query = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
        query.setParameter("name", elemento);
        lr = query.getResultList();

        if (lr.isEmpty()) request.setAttribute("correoValido", "OK");
        else request.setAttribute("correoValido", "NO");
        
    }
    
    private String VerUser(HttpServletRequest request, HttpSession session) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findUser", Usuario.class);
        query.setParameter("name", session.getAttribute("user"));
        request.setAttribute("Usuario",  query.getResultList().get(0));
        return "vistas/User.jsp";
    }
    
    private void MostrarFavoritos(HttpServletRequest request) {
        String  cadena  =  request.getParameter("datos");
        String [] datos = cadena.split(",");
        ArrayList<Articulos> listaArticulosFav = new ArrayList<>();
        
        TypedQuery<Articulos> query = em.createNamedQuery("Articulos.findById", Articulos.class);
        
        for (String dato : datos) {
            query.setParameter("IdenArticulo", Long.valueOf(dato));
            listaArticulosFav.add(query.getResultList().get(0));
        }
        
        this.EnviarTrozo(request, listaArticulosFav);
        
        
    }
    
    private void EnviarTrozo(HttpServletRequest request,  List<Articulos> listaArticulos ){
        int page  = 0;
        /*Calculamos el numero de paginacion*/
        int numPag = (listaArticulos.size() / NUM_ARTICULOS) + 1;
        
        if(request.getParameter("np") != null) page = Integer.valueOf(request.getParameter("np"));
        
        int posInicial = page * NUM_ARTICULOS;
        int posFinal;
        
        if (posInicial + NUM_ARTICULOS > numPag) posFinal = listaArticulos.size();
        else posFinal = posInicial + NUM_ARTICULOS;
        
        request.setAttribute("articulos", listaArticulos.subList(posInicial, posFinal));
        request.setAttribute("cont", numPag - 1);
        request.setAttribute("p", page);
        request.setAttribute("sice", listaArticulos.size());
    }
     
     

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

}
