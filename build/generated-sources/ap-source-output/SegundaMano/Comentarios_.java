package SegundaMano;

import SegundaMano.Articulos;
import SegundaMano.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-01-31T00:41:54")
@StaticMetamodel(Comentarios.class)
public class Comentarios_ { 

    public static volatile SingularAttribute<Comentarios, String> texto;
    public static volatile SingularAttribute<Comentarios, Usuario> User_Comit;
    public static volatile SingularAttribute<Comentarios, Articulos> Art_Comit;
    public static volatile SingularAttribute<Comentarios, Long> id;
    public static volatile SingularAttribute<Comentarios, String> privaciadad;

}