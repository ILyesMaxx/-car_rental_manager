package Classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Test {
    public static void main(String[]args){
        Address address = new Address("fezeher","05010","Khanchela");
        Reservation reservation = new Reservation(0, LocalDate.now());
        Facture facture = new Facture(0,LocalDate.of(2018, 3, 2),1500,true);
        Voyageur voyageur = new Voyageur(0,"Salah","Zeggada",LocalDate.of(1977, 3, 2));
        Avion avion = new Avion(0, LocalDate.now(), LocalDate.now(),15,30,
                1200,"airAlg","GEG-1800");
        Train train = new Train(1,LocalDateTime.now().toLocalDate(), LocalDateTime.now().toLocalDate(),14,20,1500,
                15,true);

        reservation.addFacture(facture);
        reservation.addVoyageur(voyageur);
        avion.addResarvation(reservation);
        reservation.addAddress(address);


    }
}
