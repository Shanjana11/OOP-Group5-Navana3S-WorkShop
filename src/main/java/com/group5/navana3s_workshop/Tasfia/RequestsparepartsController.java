package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RequestsparepartsController
{
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TableColumn qtycol;
    @javafx.fxml.FXML
    private TableColumn reasoncol;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TextField quantityfield;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TextArea textarea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addrequestOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void submittomanagerOnActionButton(ActionEvent actionEvent) {
    }
}