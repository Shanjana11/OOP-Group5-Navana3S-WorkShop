package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class addOfferController
{
    @javafx.fxml.FXML
    private TextField discountPercentageTextField;
    @javafx.fxml.FXML
    private DatePicker offerStartDatePicker;
    @javafx.fxml.FXML
    private TextField offerNameTextField;
    @javafx.fxml.FXML
    private DatePicker offerEndDatePicker;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Test Drive");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addOfferOnActionButton(ActionEvent actionEvent) {
    }
}