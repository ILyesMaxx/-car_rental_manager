package Classes;

import java.time.LocalDate;

public class Voyageur {
    private int id_voyageur;
    private String nom;
    private String prenom;
    private LocalDate Date_nessence;
    private int id_resarvation;

    public int getId_resarvation() {
        return id_resarvation;
    }

    public void setId_resarvation(int id_resarvation) {
        this.id_resarvation = id_resarvation;
    }

    public Voyageur(int id_voyageur, String nom, String prenom, LocalDate date_nessence) {
        this.id_voyageur = id_voyageur;
        this.nom = nom;
        this.prenom = prenom;
        Date_nessence = date_nessence;
    }
    public Voyageur(int id_voyageur, String nom, String prenom, LocalDate date_nessence,int id_reservation) {
        this.id_voyageur = id_voyageur;
        this.nom = nom;
        this.prenom = prenom;
        Date_nessence = date_nessence;
        id_resarvation = id_reservation;
    }

    public int getId_voyageur() {
        return id_voyageur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDate_nessence() {
        return Date_nessence;
    }

    public void setId_voyageur(int id_voyageur) {
        this.id_voyageur = id_voyageur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_nessence(LocalDate date_nessence) {
        Date_nessence = date_nessence;
    }


    public int calculerAge(){
        return ((int)System.currentTimeMillis());
    }


}
