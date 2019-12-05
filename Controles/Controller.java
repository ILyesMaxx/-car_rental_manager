package Controles;

import Classes.CeateReport;
import Classes.Reservation;
import DbHandler.*;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable  {


    public AnchorPane mainPane;
    public JFXButton transport;
    public JFXButton voyageur;
    public JFXButton Reservation;
    public JFXButton menue;
    public JFXNodesList nodelist;
    public JFXListView listView;
    public JFXPopup popup;
    public JFXButton Facture;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    nodelist.setSpacing(60d);
    popup = new JFXPopup(listView);


    }




    public void getAll(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        getAllReservation();
    }

    public void popup(MouseEvent mouseEvent) throws IOException, SQLException, ClassNotFoundException {
        if(mouseEvent.getButton() == MouseButton.SECONDARY) {
            JFXButton b1 = new JFXButton("update");
            JFXButton b2 = new JFXButton("delete");
            VBox vBox = new VBox(b1, b2);
            popup.setPopupContent(vBox);

            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    boolean s1 = listView.getSelectionModel().getSelectedItem().toString().contains("idT");
                    boolean s2 = listView.getSelectionModel().getSelectedItem().toString().contains("idAV");
                    boolean s3 = listView.getSelectionModel().getSelectedItem().toString().contains("idV");
                    boolean s4 = listView.getSelectionModel().getSelectedItem().toString().contains("idR");
                    boolean s5 = listView.getSelectionModel().getSelectedItem().toString().contains("idFA");
                    if(s1){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateTrain.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Update Train");
                        stage.setScene(new Scene(root, 600, 530));
                        stage.show();
                    }
                    if(s2){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateAvion.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Update Avion");
                        stage.setScene(new Scene(root, 600, 530));
                        stage.show();
                    }
                    if(s3){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateVoyageur.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Update Voyageur");
                        stage.setScene(new Scene(root, 600, 450));
                        stage.show();}
                    if(s4){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateReservation.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Update Reservation");
                        stage.setScene(new Scene(root, 600, 530));
                        stage.show();}
                    if(s5){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateFacture.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Update Facture");
                        stage.setScene(new Scene(root, 600, 450));
                        stage.show();}
                }
            });
            b2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    boolean s1 = listView.getSelectionModel().getSelectedItem().toString().contains("idT");
                    boolean s2 = listView.getSelectionModel().getSelectedItem().toString().contains("idAV");
                    boolean s3 = listView.getSelectionModel().getSelectedItem().toString().contains("idV");
                    boolean s4 = listView.getSelectionModel().getSelectedItem().toString().contains("idR");
                    boolean s5 = listView.getSelectionModel().getSelectedItem().toString().contains("idFA");

                    if(s1){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/DeleteTrain.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Delete Train");
                        stage.setScene(new Scene(root, 400, 200));
                        stage.show();
                    }
                    if(s2){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/DeleteAvion.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Delete Avion");
                        stage.setScene(new Scene(root, 400, 200));
                        stage.show();
                    }
                    if(s3){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/DeleteVoyageur.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Delete Voyageur");
                        stage.setScene(new Scene(root, 400, 200));
                        stage.show();}
                    if(s4){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/deleteReservation.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Delete Reservation");
                        stage.setScene(new Scene(root, 400, 200));
                        stage.show();}
                    if(s5){
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/deleteFacture.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("Confirme voter Delete Facture");
                        stage.setScene(new Scene(root, 400, 200));
                        stage.show();}
                }
            });

            popup.show(listView, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, mouseEvent.getX(), mouseEvent.getY());
        }else{
            boolean s1 = listView.getSelectionModel().getSelectedItem().toString().contains("idT");
            boolean s2 = listView.getSelectionModel().getSelectedItem().toString().contains("idAV");
            boolean s3 = listView.getSelectionModel().getSelectedItem().toString().contains("idV");
            boolean s4 = listView.getSelectionModel().getSelectedItem().toString().contains("idR");
            boolean s5 = listView.getSelectionModel().getSelectedItem().toString().contains("idFA");
            if(s1){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateTrain.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Confirme voter Update Train");
                stage.setScene(new Scene(root, 600, 530));
                stage.show();
            }
            if(s2){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateAvion.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Confirme voter Update Avion");
                stage.setScene(new Scene(root, 600, 530));
                stage.show();
            }
            if(s3){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateVoyageur.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Confirme voter Update Voyageur");
                stage.setScene(new Scene(root, 600, 450));
                stage.show();}
            if(s4){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/UpdateReservation.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Confirme voter Update Reservation");
                stage.setScene(new Scene(root, 600, 530));
                stage.show();}
            if(s5){
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/GenereFacture.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Confirem voter generation de la Facture");
                stage.setScene(new Scene(root, 600, 450));
                stage.show();
            }


        }


    }


    public void getAllTrensport(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        TrainDao trainDao = new TrainDao(connectionFactory.getConnection());
        AvionDao avionDao = new AvionDao(connectionFactory.getConnection());
        List<Classes.Train> trains = trainDao.findAll();
        List<Classes.Avion> avions = avionDao.findAll();
        listView.getItems().clear();
        for(int i=0;i<trains.size();i++){
            String id = "idT: "+trains.get(i).getId_transport();
            String DateDepart = " Date depart: "+trains.get(i).getDateDepar();
            String DateArive = " Date Arive: "+trains.get(i).getDateArrive();
            String nbro = " Nomber occupé: "+trains.get(i).getNbrsiegesOccupés();
            String nbrt =" Nomber Totale: "+trains.get(i).getNbrsiegesTotale();
            String prix =" Prix: "+trains.get(i).getPrix();
            String nbrw = " Nomber Waggons: "+trains.get(i).getNbrWagons();
            String cafe = " Voitur Caffée: "+trains.get(i).isVoiturCaffe();
            String ttl = "Train "+id+DateDepart+DateArive+nbro+nbrt+prix+nbrw+cafe;
            System.out.println(ttl);
            Label label = new Label(ttl);
            listView.getItems().add(label);
        }
        for(int i=0;i<avions.size();i++){
            String id = "idAV: "+avions.get(i).getId_transport();
            String DateDepart = " Date depart: "+avions.get(i).getDateDepar();
            String DateArive = " Date Arive: "+avions.get(i).getDateArrive();
            String nbro = " Nomber occupé: "+avions.get(i).getNbrsiegesOccupés();
            String nbrt =" Nomber Totale: "+avions.get(i).getNbrsiegesTotale();
            String prix =" Prix: "+avions.get(i).getPrix();
            String nbrw = " Comagnie: "+avions.get(i).getCompagnie();
            String cafe = " Type Appareil: "+avions.get(i).getTypeAppareil();
            String ttl = "Avion: "+id+DateDepart+DateArive+nbro+nbrt+prix+nbrw+cafe;
            Label label = new Label(ttl);
            listView.getItems().add(label);
        }
    }

    public void getAllVoyageur(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        listView.getItems().clear();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        VoyageurDao voyageurDao = new VoyageurDao(connectionFactory.getConnection());
        List<Classes.Voyageur> voyageurs = voyageurDao.findAll();
        for(int i=0;i<voyageurs.size();i++){
            String id = "idV: "+voyageurs.get(i).getId_voyageur();
            String idr = " id_reservation: "+voyageurs.get(i).getId_resarvation();
            String nom = " Nom: "+voyageurs.get(i).getNom();
            String premon = " Prenom: "+voyageurs.get(i).getPrenom();
            String date = " Date Nessence: "+voyageurs.get(i).getDate_nessence();
            Label label = new Label(id+idr+nom+premon+date);
            listView.getItems().add(label);
        }
    }
    public void getAllReservation() throws SQLException, ClassNotFoundException {
        listView.getItems().clear();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservationDao reservationDao = new ReservationDao(connectionFactory.getConnection());
        List<Classes.Reservation> reservationList = reservationDao.findAll();
        for(int i=0;i<reservationList.size();i++){
            String id = "idR: "+reservationList.get(i).getId_resarvation();
            String date = " Date: "+reservationList.get(i).getDateResservation();
            String rue = " Rue: "+reservationList.get(i).getAddress().getRue();
            String zip = " Zip code: "+ reservationList.get(i).getAddress().getCodePostal();
            String ville = " Ville: "+reservationList.get(i).getAddress().getVille();
            Label label = new Label(id+date+rue+zip+ville);
            listView.getItems().add(label);
        }
    }

    public void getAllFacture(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        listView.getItems().clear();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        FactureDao factureDao = new FactureDao(connectionFactory.getConnection());
        List<Classes.Facture> factures = factureDao.findAll();
        for(int i=0;i<factures.size();i++){
            String id = "idFA: "+factures.get(i).getId_facture();
            String idr = " id_reservation: "+factures.get(i).getIdre();
            String nom = " Totale: "+factures.get(i).getTotal();
            String premon = " Reglee: "+factures.get(i).isReglee();
            String date = " Date : "+factures.get(i).getDateEmission();
            Label label = new Label(id+idr+nom+premon+date);
            listView.getItems().add(label);
        }
    }


    public void createVoyageur(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY){

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/AddVoyaguer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Create Voyageur");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }}

    public void createTrensport(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/addTrensport.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Create Trensport");
        stage.setScene(new Scene(root, 400, 160));
        stage.show();
    }
    }

    public void createReservation(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/AddReservation.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Create Trensport");
            stage.setScene(new Scene(root, 600, 530));
            stage.show();
        }
    }

    public void createFacture(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.SECONDARY){
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("Interfaces/AddFacture.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setTitle("Create Trensport");
            stage.setScene(new Scene(root, 600, 450));
            stage.show();
        }
    }
}
