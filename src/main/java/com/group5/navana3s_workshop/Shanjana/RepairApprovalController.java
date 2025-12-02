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

public class RepairApprovalController
{

    @javafx.fxml.FXML
    private TableColumn<RepairApproval, String> bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn<RepairApproval, Double> estimatedCostCol;
    @javafx.fxml.FXML
    private TableColumn<RepairApproval, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<RepairApproval, String> statusCol;
    @javafx.fxml.FXML
    private Label repairDetailsLabel;
    @javafx.fxml.FXML
    private TableView<RepairApproval> repairRequestTable;
    @javafx.fxml.FXML
    private TableColumn<RepairApproval, String> repairDescCol;

    private List<RepairApproval> approvalList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        repairDescCol.setCellValueFactory(new PropertyValueFactory<>("repairDescription"));
        estimatedCostCol.setCellValueFactory(new PropertyValueFactory<>("estimatedCost"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        fetchApprovalRequests();

        repairRequestTable.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null) {
                repairDetailsLabel.setText(
                        "Booking ID: " + newValue.getBookingId() + "\n" +
                                "Description: " + newValue.getRepairDescription() + "\n" +
                                "Estimated Cost: " + newValue.getEstimatedCost() + "\n" +
                                "Date: " + newValue.getRequestDate() + "\n" +
                                "Status: " + newValue.getStatus()
                );
            }
        });

    }

    private void fetchApprovalRequests() {
        // Load from database
        approvalList.add(new RepairApproval("BK003", "Brake pad replacement needed", 3000.0, LocalDate.of(2024, 11, 28), "Pending"));
        approvalList.add(new RepairApproval("BK004", "Engine oil change", 1500.0, LocalDate.of(2024, 11, 29), "Pending"));
        approvalList.add(new RepairApproval("BK005", "Tire replacement", 8000.0, LocalDate.of(2024, 11, 30), "Pending"));
        repairRequestTable.getItems().clear();
        repairRequestTable.getItems().addAll(approvalList);
    }

    @javafx.fxml.FXML
    public void Reject(ActionEvent actionEvent) {
        RepairApproval selected = repairRequestTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Rejected");
            repairRequestTable.refresh();
            repairDetailsLabel.setText("Repair rejected!");
        } else {
            repairDetailsLabel.setText("Please select a repair request");
        }
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
    public void Approve(ActionEvent actionEvent) {
        RepairApproval selected = repairRequestTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setStatus("Approved");
            repairRequestTable.refresh();
            repairDetailsLabel.setText("Repair approved successfully!");
        } else {
            repairDetailsLabel.setText("Please select a repair request");
        }
    }
}