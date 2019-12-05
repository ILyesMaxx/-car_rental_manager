package Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class addTransportController {
    public void createAvion(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/AddAvion.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Create Avion");
        stage.setScene(new Scene(root, 600, 530));
        stage.show();

    }

    public void createTrain(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/AddTrain.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Create Train");
        stage.setScene(new Scene(root, 600, 530));
        stage.show();
    }
}
