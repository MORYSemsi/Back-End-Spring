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
@Table(name = "chauffeur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chauffeur.findAll", query = "SELECT c FROM Chauffeur c")
    , @NamedQuery(name = "Chauffeur.findByIdChauffeur", query = "SELECT c FROM Chauffeur c WHERE c.idChauffeur = :idChauffeur")
    , @NamedQuery(name = "Chauffeur.findByNom", query = "SELECT c FROM Chauffeur c WHERE c.nom = :nom")
    , @NamedQuery(name = "Chauffeur.findByPrenom", query = "SELECT c FROM Chauffeur c WHERE c.prenom = :prenom")
    , @NamedQuery(name = "Chauffeur.findByCin", query = "SELECT c FROM Chauffeur c WHERE c.cin = :cin")})
public class Chauffeur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChauffeur")
    private Integer idChauffeur;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "cin")
    private String cin;
    @OneToMany(mappedBy = "idChauffeur")
    private List<Reservation> reservationList;

    public Chauffeur() {
    }

    public Chauffeur(Integer idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public Integer getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(Integer idChauffeur) {
        this.idChauffeur = idChauffeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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
        hash += (idChauffeur != null ? idChauffeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chauffeur)) {
            return false;
        }
        Chauffeur other = (Chauffeur) object;
        if ((this.idChauffeur == null && other.idChauffeur != null) || (this.idChauffeur != null && !this.idChauffeur.equals(other.idChauffeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.Chauffeur[ idChauffeur=" + idChauffeur + " ]";
    }
    
}
