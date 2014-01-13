/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import javax.inject.Inject;

import pl.maciejkolek.czytelnia.entity.Ksiazka;
import pl.maciejkolek.czytelnia.services.KsiazkaManager;

/**
 *
 * @author ferus
 */
@FacesConverter("ksiazkaConverter")
public class ksiazkaConverter implements Converter{
    
    @Inject
    KsiazkaManager km;
    
    @Override
    public String getAsString(FacesContext kontekst, UIComponent komponent, Object wartosc) {
        if (!(wartosc instanceof Ksiazka))
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji!"));
        Ksiazka k = (Ksiazka)wartosc;
        return k.getId().toString();
    }

    @Override
    public Object getAsObject(FacesContext kontekst, UIComponent komponent, String wartosc) {
        Integer i = Integer.valueOf(wartosc);
        
        Ksiazka k = km.znajdz(i);
        return k;
    }
}
