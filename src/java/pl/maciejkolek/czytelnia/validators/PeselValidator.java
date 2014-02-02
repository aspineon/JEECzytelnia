/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;

import javax.inject.Inject;

import pl.maciejkolek.czytelnia.services.CzytelnikManager;

/**
 *
 * @author ferus
 */
@FacesValidator("peselValidator")
public class PeselValidator implements Validator {
 
@Inject
private CzytelnikManager cm;
 
@Override
public void validate(FacesContext ctx, UIComponent component, Object value) {
    if (!(value instanceof String))
        throw new ValidatorException(new FacesMessage("Przekazana wartosc nie jest lancuchem znakow!"));
     String pesel = (String)value;
    if (!(pesel.matches("[0-9]{11}")))
        throw new ValidatorException(new FacesMessage("Niepoprawny format numeru PESEL!"));

    if (cm.sprawdzPesel(pesel))
        throw new ValidatorException(new FacesMessage("Nie można dodać czytelnika: Wprowadzony nr PESEL istnieje w bazie czytelnikow!"));
 }
}