
package SegundaMano;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Articulos.findByAll", query = "SELECT u FROM Articulos u join fetch u.art"),
    @NamedQuery(name = "Articulos.findById", query = "SELECT u FROM Articulos u join fetch u.art WHERE u.id = :IdenArticulo")})
@Entity
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoria, nombreArticulo, descripcion, estado;
    private float precio;
    private int año;
    @Column(name = "imagen")
    private byte[] imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "art")
    private Usuario art;
    
   @OneToMany(mappedBy="Art_Comit", cascade=CascadeType.PERSIST)
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
        if (!(object instanceof Articulos)) {
            return false;
        }
        Articulos other = (Articulos) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "BD.Articulos[ id=" + id + " ]";
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the nombreArticulo
     */
    public String getNombreArticulo() {
        return nombreArticulo;
    }

    /**
     * @param nombreArticulo the nombreArticulo to set
     */
    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the año
     */
    public int getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año) {
        this.año = año;
    }

   

    /**
     * @return the imagen
     */
    public byte[] getImagen() {
        return imagen;
    }

    

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the art
     */
    public Usuario getArt() {
        return art;
    }

    /**
     * @param art the art to set
     */
    public void setArt(Usuario art) {
        this.art = art;
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
