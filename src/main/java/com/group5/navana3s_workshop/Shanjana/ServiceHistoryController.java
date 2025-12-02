package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
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
            // adding sample data
            historyList.add(new ServiceHistory("BK001", LocalDate.of(2024, 11, 15), "Regular Service", "INV001", 5000.0, "Completed"));
            historyList.add(new ServiceHistory("BK002", LocalDate.of(2024, 10, 20), "Oil Change", "INV002", 1500.0, "Completed"));

            serviceHistoryTable.getItems().clear();
            serviceHistoryTable.getItems().addAll(historyList);

            // Show message if no records found
            if (historyList.isEmpty()) {
                invoiceInfoLabel.setText("No previous service history found for your account.");
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Error loading service history: " + e.getMessage());
            alert.show();
        }
    }



}