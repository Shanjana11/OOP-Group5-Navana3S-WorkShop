package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentController
{
    @javafx.fxml.FXML
    private PasswordField passField;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TextField cardNo;
    @javafx.fxml.FXML
    private ComboBox<String> methodCombo;

    @javafx.fxml.FXML
    public void initialize() {
        methodCombo.getItems().addAll("Card", "Mobile Banking");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/invoicePayment.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Dashboard(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = null;
        stage = (Stage) infoLabel.getScene().getWindow();
        stage.setTitle("Customer Dashboard");
        stage.setScene(scene);
    }
}