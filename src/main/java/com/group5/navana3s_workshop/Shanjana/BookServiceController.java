package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    private static final String BookingFile = "bookings.bin";

    @javafx.fxml.FXML
    public void initialize() {
        serviceTypeCombo.getItems().addAll("Regular Service", "Oil Change", "Brake Service", "Engine Repair", "AC Service", "Tire Change");
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

        //Booking date must be in future
        if (date.isBefore(LocalDate.now())) {
            statusLabel.setText("Booking Date cannot be in the past!");
            return;
        }

        // Generate booking ID
        String bookingId = "BK" + String.format("%05d", new Random().nextInt(100000));

        // create booking object
        BookService newBooking = new BookService(bookingId, vehicleId, serviceType, date, time);

        // Save booking to file
        if (saveBookingToFile(newBooking)) {
            statusLabel.setText("Booking confirmed! ID: " + bookingId);
            showAlert("Success", "Your service has been booked successfully!\nBooking ID: " + bookingId);

            // Clear fields after successful booking
            clearFields();
        } else {
            statusLabel.setText("Failed to save booking!");
            showAlert("Error", "Could not save booking. Please try again.");
        }
    }

    private boolean saveBookingToFile(BookService booking) {
        List<BookService> bookings = loadExistingBookings();
        bookings.add(booking);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BookingFile))) {
            oos.writeObject(bookings);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<BookService> loadExistingBookings() {
        File file = new File(BookingFile);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BookingFile))) {
            return (List<BookService>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void clearFields() {
        vehicleIdField.clear();
        serviceTypeCombo.setValue(null);
        datePicker.setValue(null);
        slotCombo.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}