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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ferus
 */
@Entity
@Table(name = "wypozyczenia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wypozyczenia.findAll", query = "SELECT w FROM Wypozyczenia w"),
    @NamedQuery(name = "Wypozyczenia.findById", query = "SELECT w FROM Wypozyczenia w WHERE w.id = :id"),
    @NamedQuery(name = "Wypozyczenia.findByZwrocono", query = "SELECT w FROM Wypozyczenia w WHERE w.zwrocono = :zwrocono")})
public class Wypozyczenia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zwrocono", nullable = false)
    private boolean zwrocono;
    @JoinColumn(name = "idksiazki", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ksiazka ksiazka;
    @JoinColumn(name = "idwypozyczajacego", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Czytelnik czytelnik;

    public Wypozyczenia() {
    }

    public Wypozyczenia(Integer id) {
        this.id = id;
    }

    public Wypozyczenia(Integer id, boolean zwrocono) {
        this.id = id;
        this.zwrocono = zwrocono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getZwrocono() {
        return zwrocono;
    }

    public void setZwrocono(boolean zwrocono) {
        this.zwrocono = zwrocono;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Czytelnik getCzytelnik() {
        return czytelnik;
    }

    public void setCzytelnik(Czytelnik czytelnik) {
        this.czytelnik = czytelnik;
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
        if (!(object instanceof Wypozyczenia)) {
            return false;
        }
        Wypozyczenia other = (Wypozyczenia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.maciejkolek.czytelnia.entity.Wypozyczenia[ id=" + id + " ]";
    }
    
}
