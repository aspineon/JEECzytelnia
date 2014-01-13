/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.maciejkolek.czytelnia.services.CzytelniaManager;
import pl.maciejkolek.czytelnia.entity.Czytelnia;

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
    
    private Czytelnia czytelnia = new Czytelnia();
    
    public Czytelnia getCzytelnia() {
        return this.czytelnia;
    }
    
    public void setCzytelnia(Czytelnia czytelnia) {
        this.czytelnia = czytelnia;
    }
    
    public Czytelnia daneCzytelni() {
        return cm.pobierz();
    }
}
