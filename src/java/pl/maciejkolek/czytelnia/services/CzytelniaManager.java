/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import pl.maciejkolek.czytelnia.entity.Czytelnia;
/**
 *
 * @author ferus
 */
@Stateless
public class CzytelniaManager {
    @PersistenceContext
        EntityManager em;
    
    public Czytelnia pobierz() {
        List<Czytelnia> lczytelni = em.createNamedQuery("Czytelnia.findAll").getResultList();
        return lczytelni.get(0);
    }
}
