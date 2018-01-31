package SegundaMano;

import SegundaMano.Comentarios;
import SegundaMano.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-01-31T00:41:54")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> descripcion;
    public static volatile SingularAttribute<Articulos, String> estado;
    public static volatile SingularAttribute<Articulos, Float> precio;
    public static volatile SingularAttribute<Articulos, Usuario> art;
    public static volatile SingularAttribute<Articulos, String> categoria;
    public static volatile SingularAttribute<Articulos, byte[]> imagen;
    public static volatile SingularAttribute<Articulos, Long> id;
    public static volatile ListAttribute<Articulos, Comentarios> comentarios;
    public static volatile SingularAttribute<Articulos, Integer> año;
    public static volatile SingularAttribute<Articulos, String> nombreArticulo;

}