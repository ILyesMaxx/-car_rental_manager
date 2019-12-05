package Controles;

import Classes.Facture;
import Classes.Reservation;
import DbHandler.ConnectionFactory;
import DbHandler.FactureDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

public class AddFacture {
    public JFXDatePicker date;
    public JFXTextField Reglee;
    public JFXTextField Totale;
    public JFXTextField IdRes;
    public JFXTextField idF;
    public JFXButton creat;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(idF.getText());
        int idre = Integer.parseInt(IdRes.getText());
        float total = Float.parseFloat( Totale.getText());
        boolean regle = Boolean.parseBoolean(Reglee.getText());
        java.sql.Date daten = java.sql.Date.valueOf(date.getValue());

        ConnectionFactory connectionFactory = new ConnectionFactory();
        FactureDao factureDao = new FactureDao(connectionFactory.getConnection());
        Reservation reservation = new Reservation(idre, LocalDate.now());
        Facture facture = new Facture(id,daten.toLocalDate(),total,regle,idre);
        facture.addReservation(reservation);
        System.out.println(factureDao.create(facture));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
