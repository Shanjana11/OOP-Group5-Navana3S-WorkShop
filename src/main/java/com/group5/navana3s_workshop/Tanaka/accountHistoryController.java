package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.AccountOfficer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class accountHistoryController {

    @javafx.fxml.FXML
    private TextField vehicleNoTextField;
    @javafx.fxml.FXML
    private TableView<AccountOfficer> tableViewAccountsHistory;
    @javafx.fxml.FXML
    private DatePicker filterDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AccountOfficer, String> customerColumn;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextField invoiceNoTextField;
    @javafx.fxml.FXML
    private TableColumn<AccountOfficer, Double> amountColumn;
    @javafx.fxml.FXML
    private TableColumn<AccountOfficer, String> paidOrUnpaidColumn;
    @javafx.fxml.FXML
    private TableColumn<AccountOfficer, String> invoiceNoColumn;
    @javafx.fxml.FXML
    private TableColumn<AccountOfficer, String> dateColumn;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final ObservableList<AccountOfficer> masterList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        // columns ↔ model er property name
        invoiceNoColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paidOrUnpaidColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        masterList.add(new AccountOfficer("INV001", "Rahim", 15000, "Paid",   "2025-12-01"));
        masterList.add(new AccountOfficer("INV002", "Karim", 12000, "Unpaid", "2025-12-02"));
        masterList.add(new AccountOfficer("INV003", "Selina",18000, "Paid",   "2025-12-03"));

        tableViewAccountsHistory.setItems(masterList);
        tableViewAccountsHistory.setPlaceholder(new Label("No content in table"));

        if (statusLabel != null) {
            statusLabel.setText("Showing all invoices (" + masterList.size() + ")");
        }
    }

    private void refreshTable(ObservableList<AccountOfficer> data) {
        tableViewAccountsHistory.setItems(data);
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {

        String c = customerNameTextField.getText() == null
                ? "" : customerNameTextField.getText().trim().toLowerCase();
        String i = invoiceNoTextField.getText() == null
                ? "" : invoiceNoTextField.getText().trim().toLowerCase();
        String v = vehicleNoTextField.getText() == null
                ? "" : vehicleNoTextField.getText().trim().toLowerCase();
        String d = (filterDateDatePicker.getValue() != null)
                ? filterDateDatePicker.getValue().toString()
                : "";

        if (c.isEmpty() && i.isEmpty() && v.isEmpty() && d.isEmpty()) {
            refreshTable(masterList);
            if (statusLabel != null) {
                statusLabel.setStyle("-fx-text-fill: black;");
                statusLabel.setText("Showing all invoices (" + masterList.size() + ")");
            }
            return;
        }

        ObservableList<AccountOfficer> filtered = FXCollections.observableArrayList();

        for (AccountOfficer item : masterList) {

            boolean ok = true;

            if (!c.isEmpty() &&
                    !item.getCustomerName().toLowerCase().contains(c)) {
                ok = false;
            }

            if (!i.isEmpty() &&
                    !item.getInvoiceNo().toLowerCase().contains(i)) {
                ok = false;
            }


            if (!d.isEmpty() && !item.getDate().equals(d)) {
                ok = false;
            }

            if (ok) {
                filtered.add(item);
            }
        }

        refreshTable(filtered);

        if (statusLabel != null) {
            if (filtered.isEmpty()) {
                statusLabel.setStyle("-fx-text-fill: red;");
                statusLabel.setText("No invoices found for given filters.");
            } else {
                statusLabel.setStyle("-fx-text-fill: green;");
                statusLabel.setText("Search completed: " + filtered.size() + " invoice(s) found");
            }
        }
    }

    @javafx.fxml.FXML
    public void showFullDetailsOnActionButton(ActionEvent actionEvent) {

        AccountOfficer selected =
                tableViewAccountsHistory.getSelectionModel().getSelectedItem();

        if (selected == null) {
            if (statusLabel != null) {
                statusLabel.setStyle("-fx-text-fill: red;");
                statusLabel.setText("⚠ Please select an invoice first!");
            }
            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invoice Details");
        alert.setHeaderText("Invoice: " + selected.getInvoiceNo());
        alert.setContentText(
                "Customer: " + selected.getCustomerName() + "\n" +
                        "Amount:   " + selected.getAmount() + " BDT\n" +
                        "Status:   " + selected.getPaymentStatus() + "\n" +
                        "Date:     " + selected.getDate());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}