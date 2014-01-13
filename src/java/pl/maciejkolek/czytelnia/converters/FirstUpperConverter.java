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

/**
 *
 * @author ferus
 */
@FacesConverter("firstUpperCaseConverter")
public class FirstUpperConverter implements Converter{
    
    @Override
    public String getAsString(FacesContext kontekst, UIComponent komponent, Object wartosc) {
        if (!(wartosc instanceof String))
            throw new ConverterException(new FacesMessage("Nastapil blad konwersji!"));
        
        if (((String) wartosc).isEmpty()) {
        return null;
    }

    String string = (String) wartosc;
    return new StringBuilder()
        .append(Character.toTitleCase(string.charAt(0)))
        .append(string.substring(1))
        .toString();
    }

    @Override
    public Object getAsObject(FacesContext kontekst, UIComponent komponent, String wartosc) {
        return wartosc;
    }
}
