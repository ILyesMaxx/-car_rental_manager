package Classes;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.*;

public class ModelTester {
    /*************************************************
     Comme nous avons deux 'fixture' différents pour les tests,
     nous devrions avoir deux classes. Mais, pour éviter toute
     complexité lors de l'exécution, nous n'en utilisons qu'une.
     *****************************************************/


    /*******************************
     les variables de la première série de tests.
     ********************************/
    private Reservation r1;
    private Voyageur v0, v1, v2, v3;


    /*******************************
     les variables du deuxième série de tests.
     ********************************/
    private Reservation r2;
    private Voyageur v4, v5;
    private Facture f1, f2;
    private Avion av1;
    private Address adr1;
    private Train train1;


    @Before()
    public void setUp() {

        /******************************
         la préparation de la première série de tests.
         ********************************/
        r1 = new Reservation(1, LocalDate.now());
        v0 = new Voyageur(1, "Nahas", "Zakariyya",LocalDate.of(1977, 3, 2));
        v1 = new Voyageur(2, "Shalhoub", "Wasim", LocalDate.of(1977, 3, 2));
        v2 = new Voyageur(3, "Bakr", "Shadid",LocalDate.of(1977, 3, 2));
        v3 = new Voyageur(4, "Ata", "Kedar",LocalDate.of(1977, 3, 2));
        r1.addSVoyageur(v0);
        r1.addSVoyageur(v1);
        r1.addSVoyageur(v2);
        r1.addSVoyageur(v3);
        r1.removeSvoyageur(v0);

        /******************************
         la préparation de la deuxième série de tests.
         ********************************/
        r2 = new Reservation(2, LocalDate.now());
        v4 = new Voyageur(5, "Fakhoury", "Sarraf", LocalDate.of(1977, 3, 2));
        v5 = new Voyageur(6, "Murshid", "Abdul-Hamid", LocalDate.of(1977, 3, 2));
        av1 = new Avion(1, LocalDate.now(), LocalDate.now(), 0, 123, 5156, "", "");
        adr1 = new Address("Virage", "25000", "Constontine");
        train1 = new Train(1, LocalDateTime.now().toLocalDate(), LocalDateTime.now().toLocalDate(), 0, 15, 5616, 1, false);
        f1 = new Facture(1, LocalDate.of(2018, 3, 2), 5616, false);
        f2 = new Facture(2, LocalDate.of(2018, 3, 2), 4616, false);

        r2.addFacture(f1);
        r2.addVoyageur(v4);
        r2.addVoyageur(v5);
        r2.addTransport(av1);
        train1.addResarvation(r2);
        r2.addFacture(f2);
        r2.addAddress(adr1);
    }

    /*******************************
     la première série de tests.
     ********************************/
    @Test()
    public void addVShouldUpdateVoyageurSet() {
        assertEquals("En ajoutant 3 voyageurs, la taille de Set<Voyageur> doit être égale à 3.",
                3, r1.getSvoyageur().size());
    }

    @Test()
    public void VoyageurSetShouldContainAddedVoyageur() {
        assertTrue("En ajoutant V2,Il doit être contenu dans le Set<Voyageur>.", r1.getSvoyageur().contains(v2));
    }

    @Test()
    public void VoyageurSetShouldNotContainDeletedVoyageur() {
        assertFalse("En en supprimant V0,il ne doit pas être contenu par le Set<Voyageur>.", r1.getSvoyageur().contains(v0));
    }

    /*******************************
     la deuxième série de tests.
     ********************************/
    @Test()
    public void FactureReservationShouldBeNull() {
        assertNull("la réservation de la Facture 1 doit être nulle", f1.getReservation());
    }

    @Test()
    public void addTransportAndAddReservationShouldUpdateTransportSet() {
        assertEquals("En ajoutant av1 à r2 et r2 à train1, la taille de Set<Transport> doit être égale à 2. ", 2, r2.getTransports().size());
    }

    @Test()
    public void addTransportShouldUpdateReservationSet() {
        assertTrue("En ajoutant av1 à r2, r2 doit être dans Set<Reservation>. ", av1.getReservations().contains(r2));
    }

    @Test()
    public void nbrOfVoyageurInReservationShouldEqualOccupiedInTrain() {

        /**
         il existe un getter pour le nombre de sièges occupés;
         **/
        int nbrSigeOccuperTrain1 = train1.getNbrsiegesTotale() - train1.calcuerNbrSeigesDispo();
        assertEquals("le nombre de voyageurs dans r2 doit être égal au nombre de places occupées dans le train1", r2.getSvoyageur().size(), nbrSigeOccuperTrain1);
    }
}
