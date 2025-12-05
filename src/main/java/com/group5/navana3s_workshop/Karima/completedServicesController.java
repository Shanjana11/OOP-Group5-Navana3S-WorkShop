package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.CompletedService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class completedServicesController {
    @javafx.fxml.FXML
    private TextField vehicleField;
    @javafx.fxml.FXML
    private TableColumn<CompletedService,Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<CompletedService,String> serviceTypeCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField mechanicField;
    @javafx.fxml.FXML
    private TableColumn<CompletedService,Integer> vehicleCol;
    @javafx.fxml.FXML
    private TableView<CompletedService> servicesTable;
    @javafx.fxml.FXML
    private TableColumn<CompletedService,String> mechanicCol;
    @javafx.fxml.FXML
    private TextField costField;
    @javafx.fxml.FXML
    private TextField typeField;

    ArrayList <CompletedService> serviceList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        vehicleCol.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        serviceTypeCol.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        mechanicCol.setCellValueFactory(new PropertyValueFactory<>("mechanicName"));

        serviceList.add(new CompletedService(1, "DHA-1234", "Oil Change", "Employee A", 5000));
        serviceList.add(new CompletedService(2, "DHA-5678", "Tire Change", "Employee B", 8000));

        servicesTable.getItems().addAll(serviceList);

    }

    private void loadRequestDetails(CompletedService s) {
        vehicleField.setText("Vehicle: " + s.getVehicleNumber());
        typeField.setText("Service: " + s.getServiceType());
        mechanicField.setText("Mechanic: " + s.getMechanicName());
        costField.setText("Cost: " + s.getServiceCost() + " BDT");
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
    public void viewDetailsButton(ActionEvent actionEvent) {
        CompletedService selected = servicesTable.getSelectionModel().getSelectedItem();

        if(selected == null) {
            outputLabel.setText("Please select a service first!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }
        loadRequestDetails(selected);

        outputLabel.setText("service details are shown");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
    }

}