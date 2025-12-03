package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class generateInvoiceController
{
    @javafx.fxml.FXML
    private TextField customerIDTextField;
    @javafx.fxml.FXML
    private TextField vehicleNoTextField;
    @javafx.fxml.FXML
    private DatePicker invoiceDateDatePicker;
    @javafx.fxml.FXML
    private TextArea maintenanceDetailsTextArea;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private ComboBox paymenttypeComboBox;
    @javafx.fxml.FXML
    private TextField jobCardNoTextField;
    @javafx.fxml.FXML
    private Label validationMessagesLabel;

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
    public void validateOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateInvoiceOnActionButton(ActionEvent actionEvent) {
    }
}