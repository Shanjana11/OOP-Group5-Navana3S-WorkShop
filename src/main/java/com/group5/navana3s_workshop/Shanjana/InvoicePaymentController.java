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

public class InvoicePaymentController
{
    @javafx.fxml.FXML
    private TableColumn<Invoice, String> invoiceC;
    @javafx.fxml.FXML
    private TableColumn<Invoice, Double> amountC;
    @javafx.fxml.FXML
    private ComboBox<String> statusCombo;
    @javafx.fxml.FXML
    private TableView<Invoice> tableView;
    @javafx.fxml.FXML
    private TableColumn<Invoice, LocalDate> dateC;
    @javafx.fxml.FXML
    private TableColumn<Invoice, String> statusC;
    @javafx.fxml.FXML
    private ComboBox<String> methodCombo;
    @javafx.fxml.FXML
    private Label infoLabel;

    private List<Invoice> invoiceList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        statusCombo.getItems().addAll("Paid","Unpaid");
        methodCombo.getItems().addAll("Credit Card", "Debit Card","Bkash", "Nagad");

        invoiceC.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        dateC.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        amountC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        statusC.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        loadInvoices();
    }

    private void loadInvoices() {
        invoiceList.add(new Invoice("INV001", LocalDate.of(2025,3,10), 6500.0, "Unpaid"));
        invoiceList.add(new Invoice("INV002", LocalDate.of(2025,7,20), 1500.0, "Paid"));
        invoiceList.add(new Invoice("INV003", LocalDate.of(2025,11,27), 4500.0, "Paid"));
        invoiceList.add(new Invoice("INV004", LocalDate.of(2025,12,1), 1000.0, "Unpaid"));
        tableView.getItems().addAll(invoiceList);
    }

    @javafx.fxml.FXML
    public void Filter(ActionEvent actionEvent) {
        String statusFilter = statusCombo.getValue();

        tableView.getItems().clear();
        for (Invoice u : invoiceList){
            if (u.getPaymentStatus().equals(statusFilter)){
                tableView.getItems().add(u);
            }
        }
    }

    @javafx.fxml.FXML
    public void ResetFilter(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(invoiceList);
    }

    @javafx.fxml.FXML
    public void PayButton(ActionEvent actionEvent) throws IOException {
        Invoice selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            infoLabel.setText("Select an invoice first!");
            return;
        }

        String method = methodCombo.getValue();
        if (method == null) {
            infoLabel.setText("Choose payment method!");
            return;
        }

        // Process payment
        selected.setPaymentStatus("Paid");
        tableView.refresh();
        infoLabel.setText("Payment successful!");
    }


    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}