package org.example.model;
import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Reservation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date dateReservation;
    private boolean confirmation;
    @OneToMany(mappedBy = "reservation")
    private Collection<NbrPlace> nbrPlacetablesByIdReservation;
    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Apprenant apprenant;

    public Reservation() {
    }

    public Reservation(Date dateReservation, boolean confirmation, Collection<NbrPlace> nbrPlacetablesByIdReservation, Apprenant apprenant) {
        this.dateReservation = dateReservation;
        this.confirmation = confirmation;
        this.nbrPlacetablesByIdReservation = nbrPlacetablesByIdReservation;
        this.apprenant = apprenant;
    }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    public Collection<NbrPlace> getNbrPlacetablesByIdReservation() {
        return nbrPlacetablesByIdReservation;
    }

    public void setNbrPlacetablesByIdReservation(Collection<NbrPlace> nbrPlacetablesByIdReservation) {
        this.nbrPlacetablesByIdReservation = nbrPlacetablesByIdReservation;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
