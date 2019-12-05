package Classes;

import java.time.LocalDate;

public class Facture {
    private int id_facture;
    private LocalDate dateEmission;
    private float total;
    private boolean reglee;
    private Reservation reservation;
    private int idre;

    public int getIdre() {
        return idre;
    }

    public void setIdre(int idre) {
        this.idre = idre;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

    public void setDateEmission(LocalDate dateEmission) {
        this.dateEmission = dateEmission;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setReglee(boolean reglee) {
        this.reglee = reglee;
    }

    public int getId_facture() {
        return id_facture;
    }

    public LocalDate getDateEmission() {
        return dateEmission;
    }

    public float getTotal() {
        return total;
    }

    public boolean isReglee() {
        return reglee;
    }

    public Facture(int id_facture, LocalDate dateEmission, float total, boolean reglee,int id_reservation) {
        this.id_facture = id_facture;
        this.dateEmission = dateEmission;
        this.total = total;
        this.reglee = reglee;
        idre =  id_reservation;
    }
    public Facture(int id_facture, LocalDate dateEmission, float total, boolean reglee) {
        this.id_facture = id_facture;
        this.dateEmission = dateEmission;
        this.total = total;
        this.reglee = reglee;
    }

    ///// we must impmemt it later

    public void imprimerFactur(){

    }
    public void addReservation(Reservation reservation){
        if(reservation.getFacture() != null) reservation.removeFacture();
        if(getReservation() != null) removeReservation();
        setReservation(reservation);
        reservation.setFacture(this);

    }

    public void removeReservation() {
        if(getReservation() != null)getReservation().setFacture(null);
        setReservation(null);
    }
}
