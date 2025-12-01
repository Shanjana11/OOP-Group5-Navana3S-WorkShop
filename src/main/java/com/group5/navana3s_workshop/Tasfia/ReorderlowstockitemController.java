package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ReorderlowstockitemController
{
    @javafx.fxml.FXML
    private TableColumn partidcol;
    @javafx.fxml.FXML
    private TableColumn suggestedsuppliercol;
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TableColumn currentqtycol;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TableColumn reorderlevelcol;
    @javafx.fxml.FXML
    private ComboBox combobox;
    @javafx.fxml.FXML
    private TableColumn selectcol;
    @javafx.fxml.FXML
    private TextField thresholdfield;
    @javafx.fxml.FXML
    private TextField generatereorderfiled;
    @javafx.fxml.FXML
    private TextField nameidfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void exportlistOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);

    }

    @javafx.fxml.FXML
    public void createpurchaseorderOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void selectallOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void deselectallOnActionButton(ActionEvent actionEvent) {
    }
}