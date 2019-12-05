package Controles;

import Classes.Voyageur;
import DbHandler.ConnectionFactory;
import DbHandler.VoyageurDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class addVoyageurController {
    public JFXDatePicker date;
    public JFXTextField prenom;
    public JFXTextField nom;
    public JFXTextField IdRes;
    public JFXTextField idV;
    public JFXButton creat;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(idV.getText());
        int idre = Integer.parseInt(IdRes.getText());
        String name = nom.getText();
        String pnom = prenom.getText();
        java.sql.Date daten = java.sql.Date.valueOf(date.getValue());

        ConnectionFactory connectionFactory = new ConnectionFactory();
        VoyageurDao voyageurDao = new VoyageurDao(connectionFactory.getConnection());
        System.out.println(voyageurDao.create(new Voyageur(id,name,pnom,daten.toLocalDate(),idre)));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
