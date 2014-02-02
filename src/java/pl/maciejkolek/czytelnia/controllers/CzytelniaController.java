/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.controllers;

import java.io.Serializable;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

import pl.maciejkolek.czytelnia.services.KsiazkaManager;
import pl.maciejkolek.czytelnia.entity.Ksiazka;

import pl.maciejkolek.czytelnia.services.CzytelniaManager;
import pl.maciejkolek.czytelnia.entity.Czytelnia;

import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author ferus
 */
@RequestScoped
@Named("czytelniaCon")
public class CzytelniaController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private CzytelniaManager cm;
    
    @Inject
    private KsiazkaManager km;
    
    private Czytelnia czytelnia = new Czytelnia();
    
    private PieChartModel ksiazkiModel; 
    
    public Czytelnia getCzytelnia() {
        return this.czytelnia;
    }
    
    public void setCzytelnia(Czytelnia czytelnia) {
        this.czytelnia = czytelnia;
    }
    
    public Czytelnia daneCzytelni() {
        return cm.pobierz();
    }
    
    public PieChartModel getKsiazkiModel() {
        this.daneWykresu();
        return this.ksiazkiModel;
    }
    
    private void daneWykresu() {
        this.ksiazkiModel = new PieChartModel();  

        List<Ksiazka> listaKsiazek = km.pobierz();
        
        if (listaKsiazek.size() > 0) {
            for (Ksiazka k : listaKsiazek) {
                 this.ksiazkiModel.set(k.getTytul(), k.getIloscwypozyczen()); 
            }
        }
    }
}
