package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class NbrPlace {
    @Id
    @GeneratedValue
    private Long idNbrplace;
    private int nombre;
    private Date dateAjout;
    private String typeReservation;
    @ManyToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    public NbrPlace() {
    }

    public NbrPlace( int nombre, Date dateAjout, String typeReservation, Reservation reservation) {
        this.nombre = nombre;
        this.dateAjout = dateAjout;
        this.typeReservation = typeReservation;
        this.reservation = reservation;
    }

    public Long getIdNbrplace() {
        return idNbrplace;
    }

    public void setIdNbrplace(Long idNbrplace) {
        this.idNbrplace = idNbrplace;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public String getTypeReservation() {
        return typeReservation;
    }

    public void setTypeReservation(String typeReservation) {
        this.typeReservation = typeReservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
