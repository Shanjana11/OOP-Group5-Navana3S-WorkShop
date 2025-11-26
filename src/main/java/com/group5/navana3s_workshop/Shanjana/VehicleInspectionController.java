package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleInspectionController
{
    @javafx.fxml.FXML
    private TextField idField;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TextArea inspectionArea;
    @javafx.fxml.FXML
    private CheckBox tyreCondition;
    @javafx.fxml.FXML
    private CheckBox engineCondition;
    @javafx.fxml.FXML
    private CheckBox ac;
    @javafx.fxml.FXML
    private ComboBox<String> vehicleCombo;
    @javafx.fxml.FXML
    private CheckBox light;
    @javafx.fxml.FXML
    private DatePicker inspectDate;
    @javafx.fxml.FXML
    private CheckBox breakCondition;
    @javafx.fxml.FXML
    private ComboBox<String> fuelCombo;
    @javafx.fxml.FXML
    private CheckBox others;

    @javafx.fxml.FXML
    public void initialize() {
        fuelCombo.getItems().addAll("Full","Half", "Low");
        vehicleCombo.getItems().addAll("Bike","Car", "Truck");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
    }
}