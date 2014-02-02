package pl.maciejkolek.czytelnia.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.maciejkolek.czytelnia.entity.Czytelnik;
import pl.maciejkolek.czytelnia.entity.Ksiazka;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-02-02T21:47:26")
@StaticMetamodel(Wypozyczenia.class)
public class Wypozyczenia_ { 

    public static volatile SingularAttribute<Wypozyczenia, Integer> id;
    public static volatile SingularAttribute<Wypozyczenia, Ksiazka> ksiazka;
    public static volatile SingularAttribute<Wypozyczenia, Czytelnik> czytelnik;
    public static volatile SingularAttribute<Wypozyczenia, Boolean> zwrocono;

}