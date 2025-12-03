package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class pettyCashController
{
    @javafx.fxml.FXML
    private TableView pettyCashTableView;
    @javafx.fxml.FXML
    private TextField entryAmountTextField;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TableColumn typeColumn;
    @javafx.fxml.FXML
    private TableColumn descriptionColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/accountsOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Test Drive");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addNewOnActionButton(ActionEvent actionEvent) {
    }
}