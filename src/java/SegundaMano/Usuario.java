/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaMano;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Hector Gonzalez Guerreiro
 * @version 1.0
 * @since 01/01/2018
 *
 */
@NamedQueries({
    @NamedQuery(name = "Usuario.findByNameAndPass", query = "SELECT u FROM Usuario u WHERE u.nick = :name AND u.pass = :pwd"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u.id From Usuario u WHERE u.nick = :name"),
    @NamedQuery(name = "Usuario.findUser", query = "SELECT u From Usuario u WHERE u.nick = :name")})
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nick;
    private String pass;
    private String name;
    private String direccion;
    private int CP;
    private String Faceboock, Twiter;
    private Long telefono;
    
    @OneToMany(mappedBy="art", cascade=CascadeType.PERSIST)
    private List<Articulos> articulos;
    
    @OneToMany(mappedBy="User_Comit", cascade=CascadeType.PERSIST)
    private List<Comentarios> comentarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Segunda_Mano_WEB.Usuario[ id=" + id + " ]";
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the CP
     */
    public int getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(int CP) {
        this.CP = CP;
    }

    /**
     * @return the Faceboock
     */
    public String getFaceboock() {
        return Faceboock;
    }

    /**
     * @param Faceboock the Faceboock to set
     */
    public void setFaceboock(String Faceboock) {
        this.Faceboock = Faceboock;
    }

    /**
     * @return the Twiter
     */
    public String getTwiter() {
        return Twiter;
    }

    /**
     * @param Twiter the Twiter to set
     */
    public void setTwiter(String Twiter) {
        this.Twiter = Twiter;
    }

    /**
     * @return the telefono
     */
    public Long getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the articulos
     */
    public List<Articulos> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(List<Articulos> articulos) {
        this.articulos = articulos;
    }

    /**
     * @return the comentarios
     */
    public List<Comentarios> getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(List<Comentarios> comentarios) {
        this.comentarios = comentarios;
    }

    

}
