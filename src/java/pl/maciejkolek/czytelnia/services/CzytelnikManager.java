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

import pl.maciejkolek.czytelnia.entity.Czytelnik;
/**
 *
 * @author ferus
 */
@Stateless
public class CzytelnikManager {
    @PersistenceContext
        EntityManager em;
    
    public void dodaj(Czytelnik czytelnik) {
        czytelnik.setId(null);
        em.persist(czytelnik);
    }
    
    public List pobierz() {
        return em.createNamedQuery("Czytelnik.findAll").getResultList();
    }
    
    public Czytelnik znajdz(Integer i) {
        return em.find(Czytelnik.class, i);
    }
    
    public void usun(Czytelnik czytelnik) {
        // Seek and Destroy detached entity in EJB - entity must be matched with db entity first.
        em.remove(em.merge(czytelnik));
    }
    
    public void edytuj(Czytelnik czytelnik) {
        em.merge(czytelnik);
    }
    
    public Boolean sprawdzPesel(String pesel) {
        List<Czytelnik> lczyt = em.createNamedQuery("Czytelnik.findByPesel").setParameter("pesel", pesel).getResultList();
        
        return lczyt.size() > 0;
    }
}
