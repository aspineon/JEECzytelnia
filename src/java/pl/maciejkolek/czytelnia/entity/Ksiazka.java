/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.maciejkolek.czytelnia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferus
 */
@Entity
@Table(name = "ksiazka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ksiazka.findAll", query = "SELECT k FROM Ksiazka k"),
    @NamedQuery(name = "Ksiazka.findById", query = "SELECT k FROM Ksiazka k WHERE k.id = :id"),
    @NamedQuery(name = "Ksiazka.findByAutorimie", query = "SELECT k FROM Ksiazka k WHERE k.autorimie = :autorimie"),
    @NamedQuery(name = "Ksiazka.findByAutornazwisko", query = "SELECT k FROM Ksiazka k WHERE k.autornazwisko = :autornazwisko"),
    @NamedQuery(name = "Ksiazka.findByTytul", query = "SELECT k FROM Ksiazka k WHERE k.tytul = :tytul"),
    @NamedQuery(name = "Ksiazka.findByIloscwypozyczen", query = "SELECT k FROM Ksiazka k WHERE k.iloscwypozyczen = :iloscwypozyczen"),
    @NamedQuery(name = "Ksiazka.findByWypozyczona", query = "SELECT k FROM Ksiazka k WHERE k.wypozyczona = :wypozyczona")})
public class Ksiazka implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "autorimie", nullable = false, length = 50)
    private String autorimie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "autornazwisko", nullable = false, length = 70)
    private String autornazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "tytul", nullable = false, length = 120)
    private String tytul;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iloscwypozyczen", nullable = false)
    private int iloscwypozyczen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "wypozyczona", nullable = false)
    private boolean wypozyczona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ksiazka", fetch = FetchType.EAGER)
    private List<Wypozyczenia> wypozyczeniaList;

    public Ksiazka() {
    }

    public Ksiazka(Integer id) {
        this.id = id;
    }

    public Ksiazka(Integer id, String autorimie, String autornazwisko, String tytul, int iloscwypozyczen, boolean wypozyczona) {
        this.id = id;
        this.autorimie = autorimie;
        this.autornazwisko = autornazwisko;
        this.tytul = tytul;
        this.iloscwypozyczen = iloscwypozyczen;
        this.wypozyczona = wypozyczona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutorimie() {
        return autorimie;
    }

    public void setAutorimie(String autorimie) {
        this.autorimie = autorimie;
    }

    public String getAutornazwisko() {
        return autornazwisko;
    }

    public void setAutornazwisko(String autornazwisko) {
        this.autornazwisko = autornazwisko;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getIloscwypozyczen() {
        return iloscwypozyczen;
    }

    public void setIloscwypozyczen(int iloscwypozyczen) {
        this.iloscwypozyczen = iloscwypozyczen;
    }

    public boolean getWypozyczona() {
        return wypozyczona;
    }

    public void setWypozyczona(boolean wypozyczona) {
        this.wypozyczona = wypozyczona;
    }

    @XmlTransient
    public List<Wypozyczenia> getWypozyczeniaList() {
        return wypozyczeniaList;
    }

    public void setWypozyczeniaList(List<Wypozyczenia> wypozyczeniaList) {
        this.wypozyczeniaList = wypozyczeniaList;
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
        if (!(object instanceof Ksiazka)) {
            return false;
        }
        Ksiazka other = (Ksiazka) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.maciejkolek.czytelnia.entity.Ksiazka[ id=" + id + " ]";
    }
    
}
