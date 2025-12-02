package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class BookServiceController
{

    @javafx.fxml.FXML
    private DatePicker datePicker;
    @javafx.fxml.FXML
    private TextField vehicleIdField;
    @javafx.fxml.FXML
    private ComboBox<String> slotCombo;
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeCombo;
    @javafx.fxml.FXML
    private Label statusLabel;

    @javafx.fxml.FXML
    public void initialize() {
        // Add service types
        serviceTypeCombo.getItems().addAll("Regular Service", "Oil Change", "Brake Service", "Engine Repair", "AC Service", "Tire Change");
        // Add time slots
        slotCombo.getItems().addAll("09:00 AM", "11:00 AM", "02:00 PM", "04:00 PM");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void SubmitBooking(ActionEvent actionEvent) {
        String vehicleId = vehicleIdField.getText();
        String serviceType = serviceTypeCombo.getValue();
        LocalDate date = datePicker.getValue();
        String time = slotCombo.getValue();

        // validation
        if (vehicleId.isEmpty() || serviceType == null || date == null || time == null) {
            statusLabel.setText("Please fill all fields!");
            return;
        }

        //Booking date must be in past
        if (date.isBefore(LocalDate.now())) {
            statusLabel.setText("Booking Date cannot be in the past!");
            return;
        }

        // Generate booking ID
        String bookingId = "BK" + String.format("%05d", new Random().nextInt(100000));

        // Save booking
        statusLabel.setText("Booking confirmed! ID: " + bookingId);

        // Show success message
        showAlert("Success", "Your service has been booked successfully!");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}