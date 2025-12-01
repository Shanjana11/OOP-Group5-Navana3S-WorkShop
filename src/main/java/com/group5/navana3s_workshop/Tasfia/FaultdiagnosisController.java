package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private TableView tableview;
    @javafx.fxml.FXML
    private TableColumn errorcol;
    @javafx.fxml.FXML
    private TableColumn descriptioncol;
    @javafx.fxml.FXML
    private TextArea descriptiontextarea;
    @javafx.fxml.FXML
    private TextArea textarea;

    @javafx.fxml.FXML
    public void initialize() {
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