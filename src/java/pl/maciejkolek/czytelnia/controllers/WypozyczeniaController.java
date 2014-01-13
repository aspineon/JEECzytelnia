/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

import pl.maciejkolek.czytelnia.services.WypozyczeniaManager;
import pl.maciejkolek.czytelnia.services.KsiazkaManager;
import pl.maciejkolek.czytelnia.entity.Wypozyczenia;
import pl.maciejkolek.czytelnia.entity.Ksiazka;

/**
 *
 * @author ferus
 */
@SessionScoped
@Named("wypozyczeniaCon")
public class WypozyczeniaController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private WypozyczeniaManager cm;
    
    @Inject
    private KsiazkaManager km;
    
    private Wypozyczenia wypozyczenie = new Wypozyczenia();
    
    public void setWypozyczenie(Wypozyczenia wypozyczenie) {
        this.wypozyczenie = wypozyczenie;
    }
    
    public Wypozyczenia getWypozyczenie() {
        return this.wypozyczenie;
    }
    
    public List<Wypozyczenia> listaWypozyczen() {
        List listawypozyczen = cm.pobierz();
        return listawypozyczen;
    }
    
    public String dodajWypozyczenie() {
        this.wypozyczenie.setZwrocono(false);
        cm.dodaj(this.wypozyczenie);
        
        Ksiazka k = this.wypozyczenie.getKsiazka();
        k.setWypozyczona(true);
        
        km.edytuj(k);
        
        this.wypozyczenie = new Wypozyczenia();
        return "index?faces-redirect=true";
    }
    
    public String zwrocKsiazke(Wypozyczenia wypozyczenie) {
        wypozyczenie.setZwrocono(true);
        cm.edytuj(wypozyczenie);
        
        Ksiazka k = wypozyczenie.getKsiazka();
        k.setWypozyczona(false);
        Integer ilosc = k.getIloscwypozyczen() + 1;
        k.setIloscwypozyczen(ilosc);
        km.edytuj(k);
        
        return null;
    }
}
