package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class InvoicePaymentController
{
    @javafx.fxml.FXML
    private TableColumn invoiceC;
    @javafx.fxml.FXML
    private TableColumn amountC;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn dateC;
    @javafx.fxml.FXML
    private TextField invoiceField;
    @javafx.fxml.FXML
    private TableColumn statusC;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void Filter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ResetFilter(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void PayButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Payment Dashboard");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}