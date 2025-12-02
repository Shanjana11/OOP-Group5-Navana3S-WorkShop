package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WarrantyclaimController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TextArea claimarea;
    @javafx.fxml.FXML
    private TableColumn datecol;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TableView tabelview;
    @javafx.fxml.FXML
    private TableColumn descriptioncol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void submitclaimOnActionButton(ActionEvent actionEvent) {
    }
}