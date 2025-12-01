package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class paymentCoordinationController
{
    @javafx.fxml.FXML
    private TextField idField;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField referenceField;
    @javafx.fxml.FXML
    private TextField statusField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void verifyPaymentButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }
}