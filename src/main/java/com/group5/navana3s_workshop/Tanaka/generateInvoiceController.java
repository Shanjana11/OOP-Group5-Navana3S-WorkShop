package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class generateInvoiceController
{
    @javafx.fxml.FXML
    private TextField customerIDTextField;
    @javafx.fxml.FXML
    private TextField vehicleNoTextField;
    @javafx.fxml.FXML
    private DatePicker invoiceDateDatePicker;
    @javafx.fxml.FXML
    private TextArea maintenanceDetailsTextArea;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymenttypeComboBox;
    @javafx.fxml.FXML
    private TextField jobCardNoTextField;
    @javafx.fxml.FXML
    private Label validationMessagesLabel;

    private final ArrayList<String> invoiceList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        paymenttypeComboBox.getItems().addAll(
                "Cash",
                "Card",
                "Bank Transfer",
                "Mobile Banking");
        validationMessagesLabel.setText("");
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/accountsOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    private boolean validateForm() {
        String customerId = customerIDTextField.getText();
        String vehicleNo = vehicleNoTextField.getText();
        LocalDate invDate = invoiceDateDatePicker.getValue();
        String details = maintenanceDetailsTextArea.getText();
        String amountText = amountTextField.getText();
        String paymentType = paymenttypeComboBox.getValue();
        String jobCardNo = jobCardNoTextField.getText();

        StringBuilder errors = new StringBuilder();

        if (customerId == null || customerId.isBlank()) {
            errors.append("• Customer ID is required.\n");
        }
        if (vehicleNo == null || vehicleNo.isBlank()) {
            errors.append("• Vehicle No is required.\n");
        }
        if (invDate == null) {
            errors.append("• Invoice Date is required.\n");
        }
        if (details == null || details.isBlank()) {
            errors.append("• Maintenance Details are required.\n");
        }
        if (jobCardNo == null || jobCardNo.isBlank()) {
            errors.append("• Job Card No is required.\n");
        }
        if (paymentType == null || paymentType.isBlank()) {
            errors.append("• Payment Type must be selected.\n");
        }

        double amount = 0;
        if (amountText == null || amountText.isBlank()) {
            errors.append("• Amount is required.\n");
        } else {
            try {
                amount = Double.parseDouble(amountText);
                if (amount <= 0) {
                    errors.append("• Amount must be greater than 0.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("• Amount must be a valid number.\n");
            }
        }

        if (errors.length() > 0) {
            validationMessagesLabel.setStyle("-fx-text-fill: red;");
            validationMessagesLabel.setText(errors.toString());
            return false;
        } else {
            validationMessagesLabel.setStyle("-fx-text-fill: green;");
            validationMessagesLabel.setText("All fields are valid.");
            return true;
        }
    }

    @javafx.fxml.FXML
    public void validateOnActionButton(ActionEvent actionEvent) {
        validateForm();
    }

    @javafx.fxml.FXML
    public void generateInvoiceOnActionButton(ActionEvent actionEvent) {
        if (!validateForm()) {
            // invalid → do not generate
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Validation Failed");
            alert.setContentText("Please fix the highlighted issues before generating the invoice.");
            alert.show();
            return;
        }

        String customerId = customerIDTextField.getText();
        String vehicleNo = vehicleNoTextField.getText();
        LocalDate invDate = invoiceDateDatePicker.getValue();
        String details = maintenanceDetailsTextArea.getText();
        String amountText = amountTextField.getText();
        String paymentType = paymenttypeComboBox.getValue();
        String jobCardNo = jobCardNoTextField.getText();

        String invoiceId = "INV-" + System.currentTimeMillis();  // demo ID

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Invoice Generated");
        alert.setContentText(
                "Invoice ID: " + invoiceId + "\n" +
                        "Customer ID: " + customerId + "\n" +
                        "Vehicle No: " + vehicleNo + "\n" +
                        "Job Card No: " + jobCardNo + "\n" +
                        "Date: " + invDate + "\n" +
                        "Amount: " + amountText + " BDT\n" +
                        "Payment Type: " + paymentType + "\n\n" +
                        "Maintenance Details:\n" + details
        );
        alert.show();

        customerIDTextField.clear();
        vehicleNoTextField.clear();
        invoiceDateDatePicker.setValue(null);
        maintenanceDetailsTextArea.clear();
        amountTextField.clear();
        paymenttypeComboBox.getSelectionModel().clearSelection();
        jobCardNoTextField.clear();
        validationMessagesLabel.setText("");
    }
}