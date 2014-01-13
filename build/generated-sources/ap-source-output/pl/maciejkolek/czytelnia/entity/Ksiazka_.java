package pl.maciejkolek.czytelnia.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.maciejkolek.czytelnia.entity.Wypozyczenia;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-01-13T02:28:28")
@StaticMetamodel(Ksiazka.class)
public class Ksiazka_ { 

    public static volatile SingularAttribute<Ksiazka, Integer> id;
    public static volatile SingularAttribute<Ksiazka, String> autorimie;
    public static volatile SingularAttribute<Ksiazka, String> tytul;
    public static volatile SingularAttribute<Ksiazka, Boolean> wypozyczona;
    public static volatile SingularAttribute<Ksiazka, String> autornazwisko;
    public static volatile SingularAttribute<Ksiazka, Integer> iloscwypozyczen;
    public static volatile ListAttribute<Ksiazka, Wypozyczenia> wypozyczeniaList;

}