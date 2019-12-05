package Controles;

import DbHandler.AvionDao;
import DbHandler.ConnectionFactory;
import DbHandler.VoyageurDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteAvion {
    public JFXTextField idV;
    public JFXButton creat;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(idV.getText());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        AvionDao avionDao = new AvionDao(connectionFactory.getConnection());
        System.out.println(avionDao.delete(id));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
