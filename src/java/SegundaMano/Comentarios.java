/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundaMano;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Hector Gonzalez Guerreiro
 * @since 30/12/2017
 */
@NamedQueries({
    @NamedQuery(name = "Comentarios.findByIdWitchUser", query = "SELECT c FROM Comentarios c join fetch c.Art_Comit join fetch c.User_Comit  WHERE (c.Art_Comit.id = :IdenArticulo AND ( (c.privaciadad = 'publico' ) OR (c.privaciadad = 'personal' AND c.User_Comit.id = :IdenUser) OR (c.privaciadad = 'privado' AND (( c.User_Comit.id = :IdenUser) OR (c.Art_Comit.art.id = :IdenUser) )) ))"),
    @NamedQuery(name = "Comentarios.findById", query = "SELECT c FROM Comentarios c join fetch c.Art_Comit join fetch c.User_Comit WHERE c.Art_Comit.id = :IdenArticulo AND (c.privaciadad != 'personal' AND c.privaciadad != 'privado')" )})

@Entity
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String privaciadad;
    private String texto;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_Comit")
    private Usuario User_Comit;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Art_Comit")
    private Articulos Art_Comit;
    
    

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
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BD.Comentarios[ id=" + id + " ]";
    }

    /**
     * @return the privaciadad
     */
    public String getPrivaciadad() {
        return privaciadad;
    }

    /**
     * @param privaciadad the privaciadad to set
     */
    public void setPrivaciadad(String privaciadad) {
        this.privaciadad = privaciadad;
    }

    


    /**
     * @return the User_Comit
     */
    public Usuario getUser_Comit() {
        return User_Comit;
    }

    /**
     * @param User_Comit the User_Comit to set
     */
    public void setUser_Comit(Usuario User_Comit) {
        this.User_Comit = User_Comit;
    }

    /**
     * @return the Art_Comit
     */
    public Articulos getArt_Comit() {
        return Art_Comit;
    }

    /**
     * @param Art_Comit the Art_Comit to set
     */
    public void setArt_Comit(Articulos Art_Comit) {
        this.Art_Comit = Art_Comit;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

  
    
}
