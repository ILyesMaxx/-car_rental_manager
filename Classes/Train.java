package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Train extends Transport {
    private int nbrWagons;
    private boolean voiturCaffe;


    /*public Train(int id_transport, LocalDateTime dateDepar, LocalDateTime dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix, int nbrWagons, boolean voiturCaffe) {
        super(id_transport, dateDepar, dateArrive, nbrsiegesOccupés, nbrsiegesTotale, prix);
        this.nbrWagons = nbrWagons;
        this.voiturCaffe = voiturCaffe;
    }*/
    public Train(int id_transport, LocalDate dateDepar, LocalDate dateArrive, int nbrsiegesOccupés, int nbrsiegesTotale, float prix, int nbrWagons, boolean voiturCaffe) {
        super(id_transport, dateDepar, dateArrive, nbrsiegesOccupés, nbrsiegesTotale, prix);
        this.nbrWagons = nbrWagons;
        this.voiturCaffe = voiturCaffe;
    }

    public int getNbrWagons() {
        return nbrWagons;
    }

    public void setNbrWagons(int nbrWagons) {
        this.nbrWagons = nbrWagons;
    }

    public boolean isVoiturCaffe() {
        return voiturCaffe;
    }

    public void setVoiturCaffe(boolean voiturCaffe) {
        this.voiturCaffe = voiturCaffe;
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
