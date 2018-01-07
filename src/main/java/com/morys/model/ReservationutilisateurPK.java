/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morys.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pc
 */
@Embeddable
public class ReservationutilisateurPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "idReservation")
    private int idReservation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUtilisateur")
    private int idUtilisateur;

    public ReservationutilisateurPK() {
    }

    public ReservationutilisateurPK(int idReservation, int idUtilisateur) {
        this.idReservation = idReservation;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idReservation;
        hash += (int) idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservationutilisateurPK)) {
            return false;
        }
        ReservationutilisateurPK other = (ReservationutilisateurPK) object;
        if (this.idReservation != other.idReservation) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.ReservationutilisateurPK[ idReservation=" + idReservation + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
