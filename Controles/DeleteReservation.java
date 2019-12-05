package Controles;

import DbHandler.ConnectionFactory;
import DbHandler.ReservationDao;
import DbHandler.VoyageurDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteReservation {
    public JFXTextField idV;
    public JFXButton creat;

    public void createV(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(idV.getText());
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservationDao reservationDao = new ReservationDao(connectionFactory.getConnection());
        System.out.println(reservationDao.delete(id));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
