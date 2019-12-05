package Controles;

import Classes.Train;
import DbHandler.ConnectionFactory;
import DbHandler.TrainDao;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddTrain {
    public JFXTextField id;
    public JFXTextField nbrdes;
    public JFXTextField nbrttl;
    public JFXTextField prix;
    public JFXTextField nbrw;
    public JFXDatePicker dateA;
    public JFXTimePicker timeAr;
    public JFXDatePicker dateDe;
    public JFXTimePicker timeDe;
    public JFXTextField voiturC;
    public JFXButton creat;

    public void creat(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        int idT = Integer.parseInt(id.getText());
        int nbrd = Integer.parseInt(nbrdes.getText());
        int nbrt = Integer.parseInt(nbrttl.getText());
        float prixt = Float.parseFloat(prix.getText());
        int nbrwa = Integer.parseInt(nbrw.getText());
        boolean voitur = Boolean.parseBoolean(voiturC.getText());
        java.sql.Date datariv = java.sql.Date.valueOf(dateA.getValue());
        java.sql.Date dateDep = java.sql.Date.valueOf(dateDe.getValue());

        ConnectionFactory connectionFactory = new ConnectionFactory();
        TrainDao trainDao = new TrainDao(connectionFactory.getConnection());
        System.out.println(trainDao.create(new Train(idT,dateDep.toLocalDate(),datariv.toLocalDate(),nbrd,nbrt,prixt,nbrwa,voitur)));
        Stage stage = (Stage) creat.getScene().getWindow();
        // do what you have to do
        stage.close();


    }
}
