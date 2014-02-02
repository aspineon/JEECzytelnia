package pl.maciejkolek.czytelnia.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-02T21:47:26")
@StaticMetamodel(Czytelnik.class)
public class Czytelnik_ { 

    public static volatile SingularAttribute<Czytelnik, Integer> id;
    public static volatile SingularAttribute<Czytelnik, String> pesel;
    public static volatile SingularAttribute<Czytelnik, String> imie;
    public static volatile SingularAttribute<Czytelnik, String> adres;
    public static volatile SingularAttribute<Czytelnik, String> miasto;
    public static volatile SingularAttribute<Czytelnik, String> nazwisko;

}