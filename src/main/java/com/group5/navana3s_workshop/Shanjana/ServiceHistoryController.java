package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, String> bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, String> serviceTypeCol;
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, Double> amountCol;
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<ServiceHistory, String> invoiceNoCol;
    @javafx.fxml.FXML
    private TableView<ServiceHistory> serviceHistoryTable;
    @javafx.fxml.FXML
    private TextField invoiceSearchF;
    @javafx.fxml.FXML
    private Label invoiceInfoLabel;

    private List<ServiceHistory> historyList = new ArrayList<>();
    private static final String BookingFile = "bookings.bin";

    @javafx.fxml.FXML
    public void initialize() {
        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("serviceDate"));
        serviceTypeCol.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        invoiceNoCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load data from database
        //loadServiceHistory();
    }

    @javafx.fxml.FXML
    public void InvoiceButton(ActionEvent actionEvent) {
        String invoiceId = invoiceSearchF.getText().trim();

        if (invoiceId.isEmpty()) {
            invoiceInfoLabel.setText("Please enter an invoice ID!");
            return;
        }

        // Search for the invoice in the history list
        ServiceHistory foundService = null;
        for (ServiceHistory service : historyList) {
            if (service.getInvoiceNo().equalsIgnoreCase(invoiceId)) {
                foundService = service;
                break;
            }
        }

        if (foundService == null) {
            invoiceInfoLabel.setText("Invoice not found!");
            return;
        }

        // Display invoice details in the label
        String details = "Invoice Details:\n" +
                "Invoice No: " + foundService.getInvoiceNo() + "\n" +
                "Booking ID: " + foundService.getBookingId() + "\n" +
                "Service Date: " + foundService.getServiceDate() + "\n" +
                "Service Type: " + foundService.getServiceType() + "\n" +
                "Amount: BDT " + foundService.getAmount() + "\n" +
                "Status: " + foundService.getStatus();

        invoiceInfoLabel.setText(details);
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void LoadHistory(ActionEvent actionEvent) {
        try {
            historyList.clear();

            // Load bookings from file using ObjectInputStream
            List<BookService> bookings = loadBookingsFromFile();

            if (bookings.isEmpty()) {
                invoiceInfoLabel.setText("No previous service history found.");
                return;
            }

            // Convert Booking objects to ServiceHistory objects
            for (BookService booking : bookings) {
                // Generate invoice number based on booking ID
                String invoiceNo = "INV" + booking.getBookingId().substring(2);

                // Create ServiceHistory from Booking File
                ServiceHistory history = new ServiceHistory(
                        booking.getBookingId(),
                        booking.getBookingDate(),
                        booking.getServiceType(),
                        invoiceNo,
                        generateAmount(booking.getServiceType()), // Generate amount based on service type
                        "Completed"
                );

                historyList.add(history);
            }

            // Display in table
            serviceHistoryTable.getItems().clear();
            serviceHistoryTable.getItems().addAll(historyList);

            invoiceInfoLabel.setText("Service history loaded successfully! Total records: " + historyList.size());

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Error loading service history: " + e.getMessage());
            alert.show();
            e.printStackTrace();
        }
    }

    private List<BookService> loadBookingsFromFile() {
        File file = new File(BookingFile);

        if (!file.exists()) {
            System.out.println("Booking file does not exist.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BookingFile))) {
            return (List<BookService>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading bookings from file: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Helper method to generate amount based on service type
    private double generateAmount(String serviceType) {
        switch (serviceType) {
            case "Regular Service":
                return 5000.0;
            case "Oil Change":
                return 1500.0;
            case "Brake Service":
                return 3500.0;
            case "Engine Repair":
                return 8000.0;
            case "AC Service":
                return 4000.0;
            case "Tire Change":
                return 6000.0;
            default:
                return 2000.0;
        }


    }
}