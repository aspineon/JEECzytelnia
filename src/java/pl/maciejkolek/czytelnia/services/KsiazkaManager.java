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

import pl.maciejkolek.czytelnia.entity.Ksiazka;
/**
 *
 * @author ferus
 */
@Stateless
public class KsiazkaManager {
    @PersistenceContext
        EntityManager em;
    
    public void dodaj(Ksiazka ksiazka) {
        ksiazka.setId(null);
        em.persist(ksiazka);
    }
    
    public List pobierz() {
        return em.createNamedQuery("Ksiazka.findAll").getResultList();
    }
    
    public List pobierzNiewypozyczone() {
        return em.createNamedQuery("Ksiazka.findByWypozyczona").setParameter("wypozyczona", false).getResultList();
    }
    
    public Ksiazka znajdz(Integer i) {
        return em.find(Ksiazka.class, i);
    }
    
    public void usun(Ksiazka ksiazka) {
        // Seek and Destroy detached entity in EJB - entity must be matched with db entity first.
        em.remove(em.merge(ksiazka));
    }
    
    public void edytuj(Ksiazka ksiazka) {
        em.merge(ksiazka);
    }
}
