package Controles;

import Classes.Address;
import Classes.Reservation;
import Classes.Voyageur;
import DbHandler.ConnectionFactory;
import DbHandler.ReservationDao;
import DbHandler.VoyageurDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class UpdateReservationController {
    public JFXDatePicker date;
    public JFXTextField Ville;
    public JFXTextField zip;
    public JFXTextField Rue;
    public JFXTextField idR;
    public JFXButton creat;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(idR.getText());
        String rue = Rue.getText();
        String ville = Ville.getText();
        String ZipCode = zip.getText();
        java.sql.Date daten = java.sql.Date.valueOf(date.getValue());

        Address address = new Address(rue,ZipCode,ville);
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservationDao reservationDao = new ReservationDao(connectionFactory.getConnection());
        Reservation reservation = new Reservation(id,daten.toLocalDate());
        reservation.addAddress(address);
        System.out.println(reservationDao.update(reservation));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
