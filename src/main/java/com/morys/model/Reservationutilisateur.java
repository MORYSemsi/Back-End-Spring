/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morys.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "reservationutilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservationutilisateur.findAll", query = "SELECT r FROM Reservationutilisateur r")
    , @NamedQuery(name = "Reservationutilisateur.findByDateDebut", query = "SELECT r FROM Reservationutilisateur r WHERE r.dateDebut = :dateDebut")
    , @NamedQuery(name = "Reservationutilisateur.findByDateFin", query = "SELECT r FROM Reservationutilisateur r WHERE r.dateFin = :dateFin")
    , @NamedQuery(name = "Reservationutilisateur.findByMontant", query = "SELECT r FROM Reservationutilisateur r WHERE r.montant = :montant")
    , @NamedQuery(name = "Reservationutilisateur.findByIdReservation", query = "SELECT r FROM Reservationutilisateur r WHERE r.reservationutilisateurPK.idReservation = :idReservation")
    , @NamedQuery(name = "Reservationutilisateur.findByIdUtilisateur", query = "SELECT r FROM Reservationutilisateur r WHERE r.reservationutilisateurPK.idUtilisateur = :idUtilisateur")})
public class Reservationutilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservationutilisateurPK reservationutilisateurPK;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Double montant;
    @JoinColumn(name = "idReservation", referencedColumnName = "idReservation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservation reservation;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Reservationutilisateur() {
    }

    public Reservationutilisateur(ReservationutilisateurPK reservationutilisateurPK) {
        this.reservationutilisateurPK = reservationutilisateurPK;
    }

    public Reservationutilisateur(int idReservation, int idUtilisateur) {
        this.reservationutilisateurPK = new ReservationutilisateurPK(idReservation, idUtilisateur);
    }

    public ReservationutilisateurPK getReservationutilisateurPK() {
        return reservationutilisateurPK;
    }

    public void setReservationutilisateurPK(ReservationutilisateurPK reservationutilisateurPK) {
        this.reservationutilisateurPK = reservationutilisateurPK;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationutilisateurPK != null ? reservationutilisateurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservationutilisateur)) {
            return false;
        }
        Reservationutilisateur other = (Reservationutilisateur) object;
        if ((this.reservationutilisateurPK == null && other.reservationutilisateurPK != null) || (this.reservationutilisateurPK != null && !this.reservationutilisateurPK.equals(other.reservationutilisateurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.morys.model.Reservationutilisateur[ reservationutilisateurPK=" + reservationutilisateurPK + " ]";
    }
    
}
