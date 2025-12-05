package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FaultdiagnosisController
{
    @javafx.fxml.FXML
    private TextField errorfield;
    @javafx.fxml.FXML
    private TextField vechiclefield;
    @javafx.fxml.FXML
    private TextField jobfield;
    @javafx.fxml.FXML
    private TableView <Diagnosis>tableview;
    @javafx.fxml.FXML
    private TableColumn<Diagnosis,String> errorcol;
    @javafx.fxml.FXML
    private TextArea descriptiontextarea;

    private final ObservableList<Diagnosis> diagnosisList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableColumn<Diagnosis,String> description;
    @javafx.fxml.FXML
    private TextArea detailstextarea;
    @javafx.fxml.FXML
    private TableColumn<Diagnosis,String> jobidcol;
    @javafx.fxml.FXML
    private TableColumn<Diagnosis,String> vechiclenocol;


    @javafx.fxml.FXML
    public void initialize() {
        jobidcol.setCellValueFactory(new PropertyValueFactory<>("jobid"));
        vechiclenocol.setCellValueFactory(new PropertyValueFactory<>("vechicleno"));
        errorcol.setCellValueFactory(new PropertyValueFactory<>("error"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));


        diagnosisList.addAll(
                new Diagnosis("Engine Overheating", "Coolant level low, radiator needs check", "J101", "Dhaka-1234"),
                new Diagnosis("Brake Failure", "Brake pads worn out, check brake fluid", "J102", "Dhaka-5678"),
                new Diagnosis("Battery Issue", "Battery voltage low, check connections", "J103", "Dhaka-9012")
        );

        tableview.setItems(diagnosisList);




    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addDiagnosisButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }
}