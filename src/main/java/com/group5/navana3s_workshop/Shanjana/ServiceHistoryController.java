package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ServiceHistoryController
{
    @javafx.fxml.FXML
    private TableColumn bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn serviceTypeCol;
    @javafx.fxml.FXML
    private TableColumn amountCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TableColumn invoiceNoCol;
    @javafx.fxml.FXML
    private TableView serviceHistoryTable;
    @javafx.fxml.FXML
    private TextField invoiceSearchF;
    @javafx.fxml.FXML
    private Label invoiceInfoLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void InvoiceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}