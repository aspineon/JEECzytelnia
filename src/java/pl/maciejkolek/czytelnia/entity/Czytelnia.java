/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferus
 */
@Entity
@Table(name = "czytelnia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Czytelnia.findAll", query = "SELECT c FROM Czytelnia c"),
    @NamedQuery(name = "Czytelnia.findById", query = "SELECT c FROM Czytelnia c WHERE c.id = :id"),
    @NamedQuery(name = "Czytelnia.findByNazwa", query = "SELECT c FROM Czytelnia c WHERE c.nazwa = :nazwa"),
    @NamedQuery(name = "Czytelnia.findByAdres", query = "SELECT c FROM Czytelnia c WHERE c.adres = :adres"),
    @NamedQuery(name = "Czytelnia.findByKontakt", query = "SELECT c FROM Czytelnia c WHERE c.kontakt = :kontakt")})
public class Czytelnia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nazwa", nullable = false, length = 255)
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "opis", nullable = false, length = 65535)
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "adres", nullable = false, length = 150)
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "kontakt", nullable = false, length = 30)
    private String kontakt;

    public Czytelnia() {
    }

    public Czytelnia(Integer id) {
        this.id = id;
    }

    public Czytelnia(Integer id, String nazwa, String opis, String adres, String kontakt) {
        this.id = id;
        this.nazwa = nazwa;
        this.opis = opis;
        this.adres = adres;
        this.kontakt = kontakt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Czytelnia)) {
            return false;
        }
        Czytelnia other = (Czytelnia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.maciejkolek.czytelnia.entity.Czytelnia[ id=" + id + " ]";
    }
    
}
