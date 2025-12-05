package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class dailyScheduleController
{
    @javafx.fxml.FXML
    private TextField vehicleNumberField;
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeField;
    @javafx.fxml.FXML
    private ComboBox<String> mechanicField;
    @javafx.fxml.FXML
    private TextField timeField;
    @javafx.fxml.FXML
    private DatePicker serviceDateField;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
        serviceTypeField.getItems().addAll("Oil Change", "Regular Service", "Engine Repair", "Tire Change", "Brake Service");
        mechanicField.getItems().addAll("Employee A", "Employee B", "Employee C", "Employee D");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button loginButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void saveScheduleButton(ActionEvent actionEvent) {
        String vehicleNumber = vehicleNumberField.getText();
        String serviceType = serviceTypeField.getValue();
        String mechanic = mechanicField.getValue();
        String time = timeField.getText();
        LocalDate date = serviceDateField.getValue();

        LocalDate selectedDate = serviceDateField.getValue();

        if (selectedDate == null) {
            outputLabel.setText(" Please select a service date.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        if (!selectedDate.isAfter(LocalDate.now())) {
            outputLabel.setText(" Please select a future date.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        if(vehicleNumber.isEmpty() || serviceType == null || mechanic == null || time.isEmpty() || date == null){
            outputLabel.setText(" Please fill all fields!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        System.out.println("Schedule Saved:");
        System.out.println(vehicleNumber + " | " + serviceType + " | " + mechanic + " | " + time + " | " + date);


        outputLabel.setText("Schedule saved successfully ✓");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");


        vehicleNumberField.clear();
        serviceTypeField.getSelectionModel().clearSelection();
        mechanicField.getSelectionModel().clearSelection();
        timeField.clear();
        serviceDateField.setValue(LocalDate.now());
    }

}