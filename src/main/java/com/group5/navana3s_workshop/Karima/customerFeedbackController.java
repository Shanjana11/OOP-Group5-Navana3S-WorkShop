package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.complaint;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class customerFeedbackController
{
    @javafx.fxml.FXML
    private ComboBox<String> solutionCombobox;
    @javafx.fxml.FXML
    private TableColumn<complaint,Integer> idCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<complaint,String> nameCol;
    @javafx.fxml.FXML
    private TableView<complaint> tableView;
    @javafx.fxml.FXML
    private TableColumn<complaint,String> issueCol;
    @javafx.fxml.FXML
    private TableColumn<complaint,String> statusCol;

    @javafx.fxml.FXML
    public void initialize() {
        solutionCombobox.getItems().addAll("Repair", "Refund", "Replacement");
        idCol.setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableView.getItems().add(new complaint("C101", "Customer A", "Engine making noise","Pending"));
        tableView.getItems().add(new complaint("C102", "Customer B", "AC not cooling","Pending"));
        tableView.getItems().add(new complaint("C103", "Customer C", "Oil leakage","Pending"));
    }


    @javafx.fxml.FXML
    public void resolveComplaintButton(ActionEvent actionEvent) {
        complaint selected = tableView.getSelectionModel().getSelectedItem();
        String solution = (String) solutionCombobox.getValue();

        if (selected == null) {
            outputLabel.setText("Please select a complaint!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (solution == null) {
            outputLabel.setText("Please choose a solution!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        selected.setStatus("Resolved");

        tableView.refresh();

        outputLabel.setText("Complaint resolved successfully using: " + solution);
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button loginButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void viewComplaintButton(ActionEvent actionEvent) {
        complaint selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Select a complaint first!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        outputLabel.setText("Complaint Selected: " + selected.getIssue());
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
    }
}