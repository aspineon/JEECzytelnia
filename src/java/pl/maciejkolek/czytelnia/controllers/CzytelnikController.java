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

import pl.maciejkolek.czytelnia.services.CzytelnikManager;
import pl.maciejkolek.czytelnia.entity.Czytelnik;

/**
 *
 * @author ferus
 */
@SessionScoped
@Named("czytelnikCon")
public class CzytelnikController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private CzytelnikManager cm;
    
    private Czytelnik czytelnik = new Czytelnik();
    
    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
    }
    
    public Czytelnik getCzytelnik() {
        return this.czytelnik;
    }
    
    public List<Czytelnik> listaCzytelnikow() {
        List listaczytelnikow = cm.pobierz();
        return listaczytelnikow;
    }
    
    public String dodajCzytelnika() {
        cm.dodaj(this.czytelnik);
        this.czytelnik = new Czytelnik();
        return "wyswietlCzytelnikow?faces-redirect=true";
    }
    
    public String doEdycjiCzytelnika(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
        return "edytujCzytelnika?faces-redirect=true";
    }
    
    public String edytujCzytelnika() {
        cm.edytuj(this.czytelnik);
        this.czytelnik = new Czytelnik();
        return "wyswietlCzytelnikow?faces-redirect=true";
    }
    
    public String usunCzytelnika(Czytelnik czytelnik) {
        cm.usun(czytelnik);
        return null;
    }
}
