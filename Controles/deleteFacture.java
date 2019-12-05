package Controles;

import DbHandler.AvionDao;
import DbHandler.ConnectionFactory;
import DbHandler.FactureDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class deleteFacture {
    public JFXButton creat;
    public JFXTextField idV;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(idV.getText());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FactureDao factureDao = new FactureDao(connectionFactory.getConnection());
        System.out.println(factureDao.delete(id));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
