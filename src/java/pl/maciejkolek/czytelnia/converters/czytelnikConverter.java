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

import pl.maciejkolek.czytelnia.entity.Czytelnik;
import pl.maciejkolek.czytelnia.services.CzytelnikManager;

/**
 *
 * @author ferus
 */
@FacesConverter("czytelnikConverter")
public class czytelnikConverter implements Converter{
    
    @Inject
    CzytelnikManager cm;
    
    @Override
    public String getAsString(FacesContext kontekst, UIComponent komponent, Object wartosc) {
        if (!(wartosc instanceof Czytelnik))
            throw new ConverterException(new FacesMessage("Nie udalo sie dokonac konwersji!"));
        Czytelnik c = (Czytelnik)wartosc;
        return c.getId().toString();
    }

    @Override
    public Object getAsObject(FacesContext kontekst, UIComponent komponent, String wartosc) {
        Integer i = Integer.valueOf(wartosc);
        Czytelnik c = cm.znajdz(i);
        return c;
    }
}
