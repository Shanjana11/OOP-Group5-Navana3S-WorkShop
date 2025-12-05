package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.inventoryRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class inventoryRequestController
{
    @javafx.fxml.FXML
    private TableColumn<inventoryRequest, String> requestedByCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<inventoryRequest, Integer> quantityCol;
    @javafx.fxml.FXML
    private TableView<inventoryRequest> tableView;
    @javafx.fxml.FXML
    private TextField stockField;
    @javafx.fxml.FXML
    private TextField itemField;
    @javafx.fxml.FXML
    private TextField reasonField;
    @javafx.fxml.FXML
    private TableColumn<inventoryRequest, String> itemNameCol;
    @javafx.fxml.FXML
    private TextField requestedByField;
    @javafx.fxml.FXML
    private TextField quantityField;

    ArrayList <inventoryRequest> requestList = new ArrayList<>();
    inventoryRequest selectedRequest;

    @javafx.fxml.FXML
    public void initialize() {
        itemNameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        requestedByCol.setCellValueFactory(new PropertyValueFactory<>("requestedBy"));


        requestList.add(new inventoryRequest("Brake Pads", 4, "Employee A", "Worn-out pads", 5, "Pending"));
        requestList.add(new inventoryRequest("Engine Oil", 2, "Employee B", "Routine service", 8, "Pending"));
        requestList.add(new inventoryRequest("Air Filter", 1, "Employee C", "Needs replacement", 2, "Pending"));

        tableView.getItems().addAll(requestList);


        tableView.setOnMouseClicked(event -> {
            selectedRequest = tableView.getSelectionModel().getSelectedItem();
            if (selectedRequest != null) {
                loadRequestDetails(selectedRequest);
            }
        });
    }

    private void loadRequestDetails(inventoryRequest req) {
        itemField.setText(req.getItemName());
        quantityField.setText(String.valueOf(req.getQuantity()));
        requestedByField.setText(req.getRequestedBy());
        reasonField.setText(req.getReason());
        stockField.setText(String.valueOf(req.getCurrentStock()));
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button logOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void rejectButton(ActionEvent actionEvent) {
        inventoryRequest selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a request first!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        selected.setStatus("Rejected");
        outputLabel.setText("Request Rejected!");
        outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    }

    @javafx.fxml.FXML
    public void approveButton(ActionEvent actionEvent) {
        inventoryRequest selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a request first!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        selected.setStatus("Approved");
        outputLabel.setText("Request approved successfully!");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
    }
}