package Controles;

import Classes.CeateReport;
import Classes.Facture;
import DbHandler.ConnectionFactory;
import DbHandler.FactureDao;
import DbHandler.ReservationDao;
import DbHandler.TrainDao;
import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class GenereFacture {

    public JFXTextField idV;
    public JFXButton creat;
    public JFXTextField nome;
    public JFXTextField prenom;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException, DocumentException {

        int id = Integer.parseInt(idV.getText());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FactureDao factureDao = new FactureDao(connectionFactory.getConnection());
        Facture facture = factureDao.find(Integer.parseInt(idV.getText()));
        CeateReport ceateReport = new CeateReport();
        System.out.println(nome.getText());
        ceateReport.createThrReport("Facture"+facture.getId_facture(),nome.getText(),prenom.getText(),String.valueOf(facture.getDateEmission()),
                String.valueOf(facture.getIdre()),String.valueOf(facture.getTotal()));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
