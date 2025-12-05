package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstimateGenerationController {

    @FXML
    private TextField serviceType;
    @FXML
    private TextField unitPrice;
    @FXML
    private TextField quantity;
    @FXML
    private Label estimateInfo;
    @FXML
    private ComboBox<String> bookingIdCombo;

    private final String BOOKING_FILE = "bookings.dat";
    private final String ESTIMATE_FILE = "estimates.dat";

    private List<BookService> bookings = new ArrayList<>();
    private List<Estimate> estimates = new ArrayList<>();


    @FXML
    public void initialize() {
        loadBookings();
        loadBookingIds();
        loadExistingEstimates();

        bookingIdCombo.setOnAction(event -> {
            String selectedId = bookingIdCombo.getValue();
            if (selectedId != null) {
                fillServiceType(selectedId);
            }
        });
    }

    private void loadBookings() {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            bookings = (List<BookService>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }
    }

    private void loadBookingIds() {
        for (BookService b : bookings) {
            bookingIdCombo.getItems().add(b.getBookingId());
        }
    }

    private void fillServiceType(String bookingId) {
        for (BookService b : bookings) {
            if (b.getBookingId().equals(bookingId)) {
                serviceType.setText(b.getServiceType());
                return;
            }
        }
    }

    private void loadExistingEstimates() {
        File file = new File(ESTIMATE_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            estimates = (List<Estimate>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading estimates: " + e.getMessage());
        }
    }

    private void saveEstimatesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ESTIMATE_FILE))) {
            oos.writeObject(estimates);
        } catch (IOException e) {
            estimateInfo.setText("Error saving estimate.");
        }
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void GenerateButton(ActionEvent actionEvent) {
        String selectedBooking = bookingIdCombo.getValue();

        if (selectedBooking == null) {
            estimateInfo.setText("Please select a booking ID.");
            return;
        }

        String sType = serviceType.getText();
        if (sType.isEmpty()) {
            estimateInfo.setText("Service type is missing.");
            return;
        }

        int qty;
        double price;

        try {
            qty = Integer.parseInt(quantity.getText());
            price = Double.parseDouble(unitPrice.getText());
        } catch (NumberFormatException e) {
            estimateInfo.setText("Enter valid numbers.");
            return;
        }

        double total = qty * price;

        // Display output
        estimateInfo.setText(
                "Booking ID: " + selectedBooking + "\n" +
                        "Service: " + sType + "\n" +
                        "Quantity: " + qty + "\n" +
                        "Unit Price: " + price + "\n" +
                        "-------------------------------\n" +
                        "Total Estimate: " + total
        );

        // Save to file
        Estimate newEstimate = new Estimate(
                selectedBooking, sType, qty, price, total
        );

        estimates.add(newEstimate);
        saveEstimatesToFile();

        estimateInfo.setText("Estimate generated and saved.");
    }
}
