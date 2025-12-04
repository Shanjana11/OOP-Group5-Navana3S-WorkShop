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

    private final String FILE_PATH = "bookings.dat";

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
        String vehicleId = vehicleIdField.getText().trim();
        LocalDate date = datePicker.getValue();
        String serviceType = serviceTypeCombo.getValue();
        String timeSlot = slotCombo.getValue();

        // validation
        if (vehicleId.isEmpty() || date == null || serviceType == null || timeSlot == null) {
            statusLabel.setText("Please fill all fields.");
            return;
        }

        if (!checkSlotAvailability(date, timeSlot)) {
            statusLabel.setText("Selected slot is already full.");
            return;
        }

        //booking date must not be in past
        if (date.isBefore(LocalDate.now())) {
            statusLabel.setText("Booking Date cannot be in the past");
            return;
        }

        String confirmationId = generateConfirmationId();

        BookService booking = new BookService(vehicleId, date, timeSlot, serviceType, confirmationId);

        saveBookingBinary(booking);

        statusLabel.setText(
                "Booking confirmed! ID: " + confirmationId +
                        "\nDate: " + date +
                        "\nTime: " + timeSlot
        );
    }

    private boolean checkSlotAvailability(LocalDate date, String slot) {
        List<BookService> existing = loadBookingsBinary();

        long count = existing.stream()
                .filter(b -> b.getDate().equals(date) && b.getTimeSlot().equals(slot))
                .count();

        return count < 3;  // Example: 3 customers per slot max
    }

    private void saveBookingBinary(BookService booking) {
        List<BookService> bookings = loadBookingsBinary();
        bookings.add(booking);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(bookings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<BookService> loadBookingsBinary() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<BookService>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private String generateConfirmationId() {
        int num = new Random().nextInt(900000) + 100000;
        return "BK" + num;
    }
}