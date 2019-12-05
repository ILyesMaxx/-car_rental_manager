package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class  Transport {
    protected int id_transport;
    protected LocalDate dateDepar;
    protected LocalDate dateArrive;
    protected int nbrsiegesOccupés;
    protected int nbrsiegesTotale;
    protected float prix;
    protected Set<Reservation> reservations;


    public Transport(int id_transport, LocalDate dateDepar, LocalDate dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix) {
        this.id_transport = id_transport;
        this.dateDepar = dateDepar;
        this.dateArrive = dateArrive;
        this.nbrsiegesOccupés = nbrsiegesOccupés;
        this.nbrsiegesTotale = nbrsiegesTotale;
        this.prix = prix;

    }
    public Transport(int id_transport, LocalDateTime dateDepar, LocalDateTime dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix){
        reservations = new HashSet<Reservation>();
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public void setDateDepar(LocalDate dateDepar) {
        this.dateDepar = dateDepar;
    }

    public void setDateArrive(LocalDate dateArrive) {
        this.dateArrive = dateArrive;
    }

    public void setNbrsiegesOccupés(int nbrsiegesOccupés) {
        this.nbrsiegesOccupés = nbrsiegesOccupés;
    }

    public void setNbrsiegesTotale(int nbrsiegesTotale) {
        this.nbrsiegesTotale = nbrsiegesTotale;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_transport() {
        return id_transport;
    }

    public LocalDate getDateDepar() {
        return dateDepar;
    }

    public LocalDate getDateArrive() {
        return dateArrive;
    }

    public int getNbrsiegesOccupés() {
        return nbrsiegesOccupés;
    }

    public int getNbrsiegesTotale() {
        return nbrsiegesTotale;
    }

    public float getPrix() {
        return prix;
    }

    public int calcuerNbrSeigesDispo(){
        return nbrsiegesTotale-nbrsiegesOccupés;
    }

    public void addResarvation(Reservation reservation){
        if(!getReservations().contains(reservation)){
            reservation.getTransports().add(this);
            getReservations().add(reservation);
        }
    }
    public void removeTranseport(Reservation reservation){
        if(getReservations().contains(reservation)){
            getReservations().remove(reservation);
            reservation.getTransports().remove(this);
        }
    }


}
