package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class dailyLedgerController
{
    @javafx.fxml.FXML
    private TableView tableViewLedger;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker entryDateDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TextField creditTextField;
    @javafx.fxml.FXML
    private TableColumn balanceColumn;
    @javafx.fxml.FXML
    private TableColumn debitColumn;
    @javafx.fxml.FXML
    private TextField openingTextField;
    @javafx.fxml.FXML
    private TextField closingTextField;
    @javafx.fxml.FXML
    private TableColumn dateColumn;
    @javafx.fxml.FXML
    private TextField descriptionTextField;
    @javafx.fxml.FXML
    private TableColumn creditColumn;
    @javafx.fxml.FXML
    private TableColumn descriptionColumn;
    @javafx.fxml.FXML
    private TextField debitTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void onActionApplyFilterButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onActionExportLedgerButton(ActionEvent actionEvent) {
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
    public void addEntryOnActionButton(ActionEvent actionEvent) {
    }
}