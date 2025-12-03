package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class accountHistoryController
{
    @javafx.fxml.FXML
    private TextField vehicleNoTextField;
    @javafx.fxml.FXML
    private TableView tableViewAccountsHistory;
    @javafx.fxml.FXML
    private DatePicker filterDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn customerColumn;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextField invoiceNoTextField;
    @javafx.fxml.FXML
    private TableColumn amountColumn;
    @javafx.fxml.FXML
    private TableColumn paidOrUnpaidColumn;
    @javafx.fxml.FXML
    private TableColumn invoiceNoColumn;
    @javafx.fxml.FXML
    private TableColumn dateColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
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
    public void showFullDetailsOnActionButton(ActionEvent actionEvent) {
    }
}