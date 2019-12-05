package Classes;

import java.time.LocalDate;
import java.util.*;

public class Reservation {
    private int id_resarvation;
    private LocalDate dateResservation;
    private Voyageur voyageurs;
    private Facture facture;
    private Set<Voyageur> Svoyageur;
    private Address address;
    private Set<Transport> transports;




    public Reservation(int id_resarvation, LocalDate dateResservation) {
        this.id_resarvation = id_resarvation;
        this.dateResservation = dateResservation;
        Svoyageur = new HashSet<Voyageur>();
        transports = new HashSet<Transport>();
    }


    public Set<Transport> getTransports() {
        return transports;
    }

    public void setTransports(Set<Transport> transports) {
        this.transports = transports;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Voyageur> getSvoyageur() {
        return Svoyageur;
    }

    public void setSvoyageur(Set<Voyageur> svoyageur) {
        Svoyageur = svoyageur;
    }

    public void setId_resarvation(int id_resarvation) {
        this.id_resarvation = id_resarvation;
    }

    public void setDateResservation(LocalDate dateResservation) {
        this.dateResservation = dateResservation;
    }

    public LocalDate getDateResservation() {
        return dateResservation;
    }

    public int getId_resarvation() {
        return id_resarvation;
    }



    public Voyageur getVoyageurs() {
        return voyageurs;
    }

    public void setVoyageurs(Voyageur voyageurs) {
        this.voyageurs = voyageurs;
    }

    public void addVoyageur(Voyageur voyageur){
        setVoyageurs(voyageur);
    }
    public void removeVoyaguer(Voyageur voyageur){
        setVoyageurs(null);
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public void addFacture(Facture facture){
        if(facture.getReservation() != null) facture.removeReservation();
        if(getFacture() != null) removeFacture();
        setFacture(facture);
        facture.setReservation(this);
    }

    public void removeFacture() {
        if(getFacture() != null) getFacture().setReservation(null);
        setFacture(null);

    }

    public void addSVoyageur(Voyageur voyageur){
        if(!getSvoyageur().contains(voyageur)){
            getSvoyageur().add(voyageur);
        }
    }

    public void removeSvoyageur(Voyageur voyageur){
        if(getSvoyageur().contains(voyageur)){
            getSvoyageur().remove(voyageur);
        }
    }

    public void addAddress(Address address){
        setAddress(address);
    }
    public void removeAddress(Address address){
        setAddress(null);
    }

    public void addTransport(Transport transport){
        if(!getTransports().contains(transport)){
            transport.getReservations().add(this);
            getTransports().add(transport);
        }

    }
    public void removeTransport(Transport transport){
        if(getTransports().contains(transport)){
            getTransports().remove(transport);
            transport.getReservations().remove(transport);
        }
    }


}
