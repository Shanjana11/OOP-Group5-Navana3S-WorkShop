package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvoicePaymentController {

    private final String BOOKING_FILE = "bookings.dat";
    private final String PAYMENT_FILE = "payments.dat";

    @FXML private TableView<Invoice> tableView;
    @FXML private TableColumn<Invoice, String> BookIDC;
    @FXML private TableColumn<Invoice, String> amountC;
    @FXML private TableColumn<Invoice, String> statusC;
    @FXML private TableColumn<Invoice, String> dateC;
    @FXML private Label infoLabel;
    @FXML private ComboBox<String> methodCombo;

    private ObservableList<Invoice> invoiceList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        methodCombo.getItems().addAll("Cash", "Card", "Bkash", "Nagad");

        BookIDC.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        amountC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusC.setCellValueFactory(new PropertyValueFactory<>("status"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("date"));

        loadInvoices();
    }

    private void loadInvoices() {
        List<BookService> bookings = loadBookings();

        invoiceList.clear();

        for (BookService b : bookings) {
            double amount = calculateAmount(b.getServiceType());

            Invoice record = new Invoice(
                    b.getConfirmationId(),
                    b.getVehicleId(),
                    b.getServiceType(),
                    b.getDate(),
                    amount,
                    "Unpaid"
            );

            invoiceList.add(record);
        }

        tableView.setItems(invoiceList);
    }

    private double calculateAmount(String type) {
        return switch (type) {
            case "Regular Service" -> 1500;
            case "Oil Change" -> 700;
            case "Brake Service" -> 1200;
            case "Engine Repair" -> 4500;
            case "AC Service" -> 1800;
            case "Tire Change" -> 900;
            default -> 1000;
        };
    }

    private List<BookService> loadBookings() {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<BookService>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @FXML
    public void PayButton(ActionEvent actionEvent) {
        Invoice selected = tableView.getSelectionModel().getSelectedItem();
        String method = methodCombo.getValue();

        if (selected == null) {
            infoLabel.setText("Select a service to pay.");
            return;
        }
        if (method == null) {
            infoLabel.setText("Select a payment method.");
            return;
        }

        selected.setStatus("Paid");
        tableView.refresh();

        savePayment(selected);

        infoLabel.setText("Payment successful for " + selected.getBookingId());
    }

    private void savePayment(Invoice record) {
        List<Invoice> paid = loadPayments();
        paid.add(record);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PAYMENT_FILE))) {
            out.writeObject(paid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Invoice> loadPayments() {
        File file = new File(PAYMENT_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Invoice>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);
    }
}
