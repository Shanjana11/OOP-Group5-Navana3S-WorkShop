package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.Claim;
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
import java.lang.reflect.Type;
import java.time.LocalDate;

public class claimsController {
    @javafx.fxml.FXML
    private TableColumn<Claim, LocalDate> dateTextField;
    @javafx.fxml.FXML
    private TextArea issueDetailsTextArea;
    @javafx.fxml.FXML
    private TableView<Claim> insuranceClaimsTableView;
    @javafx.fxml.FXML
    private TableColumn<Claim, Integer> ClaimIDColumn;
    @javafx.fxml.FXML
    private TableColumn<Claim, String> customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<Claim, String> approvalStatusTextField;
    @javafx.fxml.FXML
    private TextField invoiceNoTextField;
    @javafx.fxml.FXML
    private TableColumn<Claim, String> invoiceNoColumn;
    @javafx.fxml.FXML
    private ChoiceBox<String> claimTypeChoiceBox;
    @javafx.fxml.FXML
    private TableColumn<Claim, String> claimTypeTextField;

    private final ObservableList<Claim> claimList = FXCollections.observableArrayList();
    private int nextClaimId = 1;

    @javafx.fxml.FXML
    public void initialize() {

        claimTypeChoiceBox.getItems().addAll(
                "Accident",
                "Mechanical Failure",
                "Theft",
                "Fire",
                "Flood"
        );

        ClaimIDColumn.setCellValueFactory(new PropertyValueFactory<>("claimId"));
        invoiceNoColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        claimTypeTextField.setCellValueFactory(new PropertyValueFactory<>("claimType"));
        approvalStatusTextField.setCellValueFactory(new PropertyValueFactory<>("approvalStatus"));
        dateTextField.setCellValueFactory(new PropertyValueFactory<>("date"));

        insuranceClaimsTableView.setItems(claimList);
        insuranceClaimsTableView.setPlaceholder(new Label("No content in table"));
    }

    @javafx.fxml.FXML
    public void newClaimOnActionButton(ActionEvent actionEvent) {
        invoiceNoTextField.clear();
        claimTypeChoiceBox.getSelectionModel().clearSelection();
        issueDetailsTextArea.clear();
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
    public void submitOnActionButton(ActionEvent actionEvent) {

        String invoiceNo = invoiceNoTextField.getText();
        String claimType = claimTypeChoiceBox.getValue();
        String issueDetails = issueDetailsTextArea.getText();

        if (invoiceNo == null || invoiceNo.isBlank()
                || claimType == null || claimType.isBlank()
                || issueDetails == null || issueDetails.isBlank()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Claim");
            alert.setContentText("Please fill Invoice No, Claim Type and Issue Details.");
            alert.show();
            return;
        }

        int claimId = nextClaimId++;
        String displayId = String.format("CLM-%03d", claimId);

        String customerName = "Customer of " + invoiceNo;   // demo placeholder
        String approvalStatus = "Pending";
        String status = "Open";                       // or "Pending"
        LocalDate date = LocalDate.now();

        Claim claim = new Claim(
                claimId,
                invoiceNo,
                customerName,
                claimType,
                issueDetails,
                approvalStatus,
                status,
                date
        );

        claimList.add(claim);
        insuranceClaimsTableView.refresh();

        // clear form
        invoiceNoTextField.clear();
        claimTypeChoiceBox.getSelectionModel().clearSelection();
        issueDetailsTextArea.clear();

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Claim Submitted");
        ok.setContentText("New claim has been submitted with ID " + displayId + ".");
        ok.show();
    }

    @javafx.fxml.FXML
    public void updateStatusOnActionButton(ActionEvent actionEvent) {

        Claim selected = insuranceClaimsTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No Claim Selected");
            alert.setContentText("Please select a claim from the table to update its status.");
            alert.show();
            return;
        }

        String current = selected.getApprovalStatus();
        String next;

        if ("Pending".equalsIgnoreCase(current)) {
            next = "Approved";
        } else if ("Approved".equalsIgnoreCase(current)) {
            next = "Rejected";
        } else {
            next = "Pending";
        }

        selected.setApprovalStatus(next);
            // optional: also update `status` field
        selected.setStatus(next);

        insuranceClaimsTableView.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Status Updated");
        alert.setContentText("Claim " + selected.getClaimId() +
                    " status updated to: " + next);
        alert.show();

        }
}