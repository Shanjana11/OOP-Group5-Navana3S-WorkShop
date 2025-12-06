package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class paymentProcessController
{
    @javafx.fxml.FXML
    private TableColumn<Payment, Double> paymentAmountColumn;
    @javafx.fxml.FXML
    private TextField invoiceNumberTextField;
    @javafx.fxml.FXML
    private TextField paymentAmountTextField;
    @javafx.fxml.FXML
    private Label invoiceStatusLabel;
    @javafx.fxml.FXML
    private TextField transactionIDTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableView<Payment> processPaymrntTableView;
    @javafx.fxml.FXML
    private TableColumn<Payment, Integer> invoiceNumberColumn;

    private final ObservableList<Payment> paymentList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        paymentMethodComboBox.getItems().addAll("Cash", "Card", "Bank Transfer", "Mobile Banking");

        invoiceNumberColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        paymentAmountColumn.setCellValueFactory(new PropertyValueFactory<>("paymentAmount"));

        processPaymrntTableView.setItems(paymentList);
        processPaymrntTableView.setPlaceholder(new Label("No payments yet"));

        invoiceStatusLabel.setText("");
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);

    }

    private boolean validatePaymentForm() {

        String invoiceText = invoiceNumberTextField.getText();
        String amountText = paymentAmountTextField.getText();
        String method = paymentMethodComboBox.getValue();
        String txnId = transactionIDTextField.getText();

        StringBuilder errors = new StringBuilder();

        int invoiceNum = 0;
        if (invoiceText == null || invoiceText.isBlank()) {
            errors.append("• Invoice number is required.\n");
        } else {
            try {
                invoiceNum = Integer.parseInt(invoiceText);
                if (invoiceNum <= 0) {
                    errors.append("• Invoice number must be positive.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("• Invoice number must be a valid integer.\n");
            }
        }

        double amount = 0;
        if (amountText == null || amountText.isBlank()) {
            errors.append("• Payment amount is required.\n");
        } else {
            try {
                amount = Double.parseDouble(amountText);
                if (amount <= 0) {
                    errors.append("• Amount must be greater than 0.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("• Payment amount must be a valid number.\n");
            }
        }

        if (method == null || method.isBlank()) {
            errors.append("• Please select a payment method.\n");
        }

        if (txnId == null || txnId.isBlank()) {
            errors.append("• Transaction ID is required.\n");
        }

        if (errors.length() > 0) {
            invoiceStatusLabel.setStyle("-fx-text-fill: red;");
            invoiceStatusLabel.setText(errors.toString());
            return false;
        }

        invoiceStatusLabel.setStyle("-fx-text-fill: green;");
        invoiceStatusLabel.setText("✔ Payment details are valid.");
        return true;
    }

    @javafx.fxml.FXML
    public void validatepaymentOnActionButton(ActionEvent actionEvent) {
        validatePaymentForm();
    }

    @javafx.fxml.FXML
    public void submitPaymentOnActionButton(ActionEvent actionEvent) {
        if (!validatePaymentForm()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Validation Failed");
            alert.setContentText("Please correct the errors before submitting the payment.");
            alert.show();
            return;
        }

        int invoiceNum = Integer.parseInt(invoiceNumberTextField.getText());
        double amount = Double.parseDouble(paymentAmountTextField.getText());
        String method = paymentMethodComboBox.getValue();
        String txnId = transactionIDTextField.getText();

        // 🔹 create Payment object and add to list
        Payment payment = new Payment(invoiceNum, amount, method, txnId, "Processed");
        paymentList.add(payment);
        processPaymrntTableView.refresh();

        invoiceStatusLabel.setStyle("-fx-text-fill: green;");
        invoiceStatusLabel.setText("Payment submitted successfully for Invoice " + invoiceNum + ".");

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Payment Submitted");
        ok.setContentText(
                "Invoice: " + invoiceNum + "\n" +
                        "Amount: " + amount + "\n" +
                        "Method: " + method + "\n" +
                        "Transaction ID: " + txnId
        );
        ok.show();

        // clear form
        invoiceNumberTextField.clear();
        paymentAmountTextField.clear();
        transactionIDTextField.clear();
        paymentMethodComboBox.getSelectionModel().clearSelection();
    }
}