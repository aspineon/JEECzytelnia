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

import pl.maciejkolek.czytelnia.entity.Wypozyczenia;
/**
 *
 * @author ferus
 */
@Stateless
public class WypozyczeniaManager {
    @PersistenceContext
        EntityManager em;
    
    public void dodaj(Wypozyczenia wypozyczenie) {
        wypozyczenie.setId(null);
        em.persist(wypozyczenie);
    }
    
    public List pobierz() {
        return em.createNamedQuery("Wypozyczenia.findByZwrocono").setParameter("zwrocono", false).getResultList();
    }
    
    public void usun(Wypozyczenia wypozyczenie) {
        // Seek and Destroy detached entity in EJB - entity must be matched with db entity first.
        em.remove(em.merge(wypozyczenie));
    }
    
    public void edytuj(Wypozyczenia wypozyczenie) {
        em.merge(wypozyczenie);
    }
}
