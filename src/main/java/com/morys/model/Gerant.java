/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "gerant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerant.findAll", query = "SELECT g FROM Gerant g")
    , @NamedQuery(name = "Gerant.findByIdGerant", query = "SELECT g FROM Gerant g WHERE g.idGerant = :idGerant")})
public class Gerant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGerant")
    private Integer idGerant;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne
    private Utilisateur idUtilisateur;

    public Gerant() {
    }

    public Gerant(Integer idGerant) {
        this.idGerant = idGerant;
    }

    public Integer getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(Integer idGerant) {
        this.idGerant = idGerant;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGerant != null ? idGerant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerant)) {
            return false;
        }
        Gerant other = (Gerant) object;
        if ((this.idGerant == null && other.idGerant != null) || (this.idGerant != null && !this.idGerant.equals(other.idGerant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.Gerant[ idGerant=" + idGerant + " ]";
    }
    
}
