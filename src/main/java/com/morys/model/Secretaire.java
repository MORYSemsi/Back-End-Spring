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
@Table(name = "secretaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretaire.findAll", query = "SELECT s FROM Secretaire s")
    , @NamedQuery(name = "Secretaire.findByIdSecretaire", query = "SELECT s FROM Secretaire s WHERE s.idSecretaire = :idSecretaire")})
public class Secretaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSecretaire")
    private Integer idSecretaire;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne
    private Utilisateur idUtilisateur;

    public Secretaire() {
    }

    public Secretaire(Integer idSecretaire) {
        this.idSecretaire = idSecretaire;
    }

    public Integer getIdSecretaire() {
        return idSecretaire;
    }

    public void setIdSecretaire(Integer idSecretaire) {
        this.idSecretaire = idSecretaire;
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
        hash += (idSecretaire != null ? idSecretaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretaire)) {
            return false;
        }
        Secretaire other = (Secretaire) object;
        if ((this.idSecretaire == null && other.idSecretaire != null) || (this.idSecretaire != null && !this.idSecretaire.equals(other.idSecretaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.Secretaire[ idSecretaire=" + idSecretaire + " ]";
    }
    
}
