package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Avion extends Transport {

    private String compagnie;
    private String typeAppareil;

   /* public Avion(int id_transport, LocalDateTime dateDepar, LocalDateTime dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix, String compagnie, String typeAppareil) {
        super(id_transport, dateDepar, dateArrive, nbrsiegesOccupés, nbrsiegesTotale, prix);
        this.compagnie = compagnie;
        this.typeAppareil = typeAppareil;
    }*/
    public Avion(int id_transport, LocalDate dateDepar, LocalDate dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix, String compagnie, String typeAppareil) {
        super(id_transport, dateDepar, dateArrive, nbrsiegesOccupés, nbrsiegesTotale, prix);
        this.compagnie = compagnie;
        this.typeAppareil = typeAppareil;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(String typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    @Override
    public int calcuerNbrSeigesDispo() {
        return super.calcuerNbrSeigesDispo();
    }

    @Override
    public void addResarvation(Reservation reservation) {
        super.addResarvation(reservation);
    }

    @Override
    public void removeTranseport(Reservation reservation) {
        super.removeTranseport(reservation);
    }
}
