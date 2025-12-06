package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.VendorPayment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class vendorPaymentController
{
    @javafx.fxml.FXML
    private TableColumn<VendorPayment, String> DueDateColumn;
    @javafx.fxml.FXML
    private TableColumn<VendorPayment, String> paymentStatusColumn;
    @javafx.fxml.FXML
    private TableView <VendorPayment> vendorPaymentTableView;
    @javafx.fxml.FXML
    private TableColumn<VendorPayment, String> vendorNameColumn;
    @javafx.fxml.FXML
    private Label pendingTotalLabel;
    @javafx.fxml.FXML
    private TableColumn<VendorPayment, String> DueAmountColumn;
    @javafx.fxml.FXML
    private Label paidTotalLabel;

    private final ObservableList<VendorPayment> vendorPaymentList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        vendorNameColumn.setCellValueFactory(new PropertyValueFactory<>("vendorName"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        DueAmountColumn.setCellValueFactory(new PropertyValueFactory<>("dueAmount"));
        paymentStatusColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));

        vendorPaymentList.add(new VendorPayment("ABC Parts Ltd.", 50000.0, "2025-12-10", "Pending"));
        vendorPaymentList.add(new VendorPayment("EngineWorks Co.", 30000.0, "2025-12-15", "Paid"));
        vendorPaymentList.add(new VendorPayment("TyreHub BD", 45000.0, "2025-12-20", "Pending"));

        vendorPaymentTableView.setItems(vendorPaymentList);
        vendorPaymentTableView.setPlaceholder(new Label("No vendor payments"));

        updateTotals();
    }

    private void updateTotals() {
        double pending = 0;
        double paid = 0;

        for (VendorPayment vp : vendorPaymentList) {
            if ("Paid".equalsIgnoreCase(vp.getPaymentStatus())) {
                paid += vp.getDueAmount();
            } else {
                pending += vp.getDueAmount();
            }
        }

        pendingTotalLabel.setText("Pending Total: " + pending + " BDT");
        paidTotalLabel.setText("Paid Total: " + paid + " BDT");
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountsOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void markPaidOnActionButton(ActionEvent actionEvent) {
        VendorPayment selected = vendorPaymentTableView
                .getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No Vendor Selected");
            alert.setContentText("Please select a vendor payment from the table.");
            alert.show();
            return;
        }

        selected.setPaymentStatus("Paid");
        vendorPaymentTableView.refresh();
        updateTotals();

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Payment Marked as Paid");
        ok.setContentText("Vendor: " + selected.getVendorName()
                + "\nAmount: " + selected.getDueAmount() + " BDT");
        ok.show();
    }

    @javafx.fxml.FXML
    public void processPaymentOnActionButton(ActionEvent actionEvent) {
        VendorPayment selected = vendorPaymentTableView
                .getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No Vendor Selected");
            alert.setContentText("Please select a vendor payment from the table.");
            alert.show();
            return;
        }

        // here you could open another screen or just simulate processing
        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Processing Payment");
        ok.setContentText(
                "Processing payment for:\n" +
                        "Vendor: " + selected.getVendorName() + "\n" +
                        "Due Date: " + selected.getDueDate() + "\n" +
                        "Amount: " + selected.getDueAmount() + " BDT\n" +
                        "Current Status: " + selected.getPaymentStatus()
        );
        ok.show();
    }
}