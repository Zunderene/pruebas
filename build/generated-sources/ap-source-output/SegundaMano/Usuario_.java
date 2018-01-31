package SegundaMano;

import SegundaMano.Articulos;
import SegundaMano.Comentarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-01-31T00:41:54")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nick;
    public static volatile SingularAttribute<Usuario, String> pass;
    public static volatile ListAttribute<Usuario, Articulos> articulos;
    public static volatile SingularAttribute<Usuario, String> name;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, Long> telefono;
    public static volatile SingularAttribute<Usuario, Integer> CP;
    public static volatile ListAttribute<Usuario, Comentarios> comentarios;
    public static volatile SingularAttribute<Usuario, String> Faceboock;
    public static volatile SingularAttribute<Usuario, String> Twiter;

}