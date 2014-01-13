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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ferus
 */
@Entity
@Table(name = "czytelnik", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pesel"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Czytelnik.findAll", query = "SELECT c FROM Czytelnik c"),
    @NamedQuery(name = "Czytelnik.findById", query = "SELECT c FROM Czytelnik c WHERE c.id = :id"),
    @NamedQuery(name = "Czytelnik.findByImie", query = "SELECT c FROM Czytelnik c WHERE c.imie = :imie"),
    @NamedQuery(name = "Czytelnik.findByNazwisko", query = "SELECT c FROM Czytelnik c WHERE c.nazwisko = :nazwisko"),
    @NamedQuery(name = "Czytelnik.findByPesel", query = "SELECT c FROM Czytelnik c WHERE c.pesel = :pesel"),
    @NamedQuery(name = "Czytelnik.findByAdres", query = "SELECT c FROM Czytelnik c WHERE c.adres = :adres"),
    @NamedQuery(name = "Czytelnik.findByMiasto", query = "SELECT c FROM Czytelnik c WHERE c.miasto = :miasto")})
public class Czytelnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "imie", nullable = false, length = 30)
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko", nullable = false, length = 50)
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pesel", nullable = false, length = 11)
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adres", nullable = false, length = 255)
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "miasto", nullable = false, length = 70)
    private String miasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "czytelnik", fetch = FetchType.EAGER)
    private List<Wypozyczenia> wypozyczeniaList;

    public Czytelnik() {
    }

    public Czytelnik(Integer id) {
        this.id = id;
    }

    public Czytelnik(Integer id, String imie, String nazwisko, String pesel, String adres, String miasto) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.miasto = miasto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
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
        if (!(object instanceof Czytelnik)) {
            return false;
        }
        Czytelnik other = (Czytelnik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.maciejkolek.czytelnia.entity.Czytelnik[ id=" + id + " ]";
    }
    
}
