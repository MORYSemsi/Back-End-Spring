/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morys.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "voiture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voiture.findAll", query = "SELECT v FROM Voiture v")
    , @NamedQuery(name = "Voiture.findByIdVoiture", query = "SELECT v FROM Voiture v WHERE v.idVoiture = :idVoiture")
    , @NamedQuery(name = "Voiture.findByModele", query = "SELECT v FROM Voiture v WHERE v.modele = :modele")
    , @NamedQuery(name = "Voiture.findByPrix", query = "SELECT v FROM Voiture v WHERE v.prix = :prix")
    , @NamedQuery(name = "Voiture.findByMarque", query = "SELECT v FROM Voiture v WHERE v.marque = :marque")
    , @NamedQuery(name = "Voiture.findByMatricule", query = "SELECT v FROM Voiture v WHERE v.matricule = :matricule")
    , @NamedQuery(name = "Voiture.findByPanne", query = "SELECT v FROM Voiture v WHERE v.panne = :panne")})
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVoiture")
    private Integer idVoiture;
    @Size(max = 254)
    @Column(name = "modele")
    private String modele;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Double prix;
    @Size(max = 254)
    @Column(name = "marque")
    private String marque;
    @Size(max = 254)
    @Column(name = "matricule")
    private String matricule;
    @Column(name = "panne")
    private Boolean panne;
    @ManyToMany(mappedBy = "voitureList")
    private List<Categorie> categorieList;
    @OneToMany(mappedBy = "idVoiture")
    private List<Reservation> reservationList;

    public Voiture() {
    }

    public Voiture(Integer idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Integer getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Integer idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Boolean getPanne() {
        return panne;
    }

    public void setPanne(Boolean panne) {
        this.panne = panne;
    }

    @XmlTransient
    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    @XmlTransient
    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoiture != null ? idVoiture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voiture)) {
            return false;
        }
        Voiture other = (Voiture) object;
        if ((this.idVoiture == null && other.idVoiture != null) || (this.idVoiture != null && !this.idVoiture.equals(other.idVoiture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.Voiture[ idVoiture=" + idVoiture + " ]";
    }
    
}
