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

import pl.maciejkolek.czytelnia.services.KsiazkaManager;
import pl.maciejkolek.czytelnia.entity.Ksiazka;

/**
 *
 * @author ferus
 */
@SessionScoped
@Named("ksiazkaCon")
public class KsiazkaController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private KsiazkaManager cm;
    
    private Ksiazka ksiazka = new Ksiazka();
    
    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }
    
    public Ksiazka getKsiazka() {
        return this.ksiazka;
    }
    
    public List<Ksiazka> listaKsiazek() {
        List listaksiazek = cm.pobierz();
        return listaksiazek;
    }
    
    public List<Ksiazka> listaKsiazekNiewypozyczonych() {
        List listaksiazek = cm.pobierzNiewypozyczone();
        return listaksiazek;
    }
    
    public int iloscDostepnychKsiazek() {
        List lista = this.listaKsiazekNiewypozyczonych();
        return lista.size();
    }
    
    public int iloscKsiazek() {
        List lista = this.listaKsiazek();
        return lista.size();
    }
    
    public String dodajKsiazke() {
        this.ksiazka.setWypozyczona(false);
        this.ksiazka.setIloscwypozyczen(0);
        cm.dodaj(this.ksiazka);
        this.ksiazka = new Ksiazka();
        return "wyswietlKsiazki?faces-redirect=true";
    }
    
    public String doEdycjiKsiazki(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
        return "edytujKsiazke?faces-redirect=true";
    }
    
    public String edytujKsiazke() {
        cm.edytuj(this.ksiazka);
        this.ksiazka = new Ksiazka();
        return "wyswietlKsiazki?faces-redirect=true";
    }
    
    public String usunKsiazke(Ksiazka ksiazka) {
        cm.usun(ksiazka);
        return null;
    }
    
    public String jestWypozyczona(Ksiazka ksiazka) {
        Boolean boo = Boolean.valueOf(ksiazka.getWypozyczona());
        return boo ? "Tak" : "Nie";
    }
}
