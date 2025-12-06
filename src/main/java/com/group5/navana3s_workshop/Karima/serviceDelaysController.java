package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.serviceDelay;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class serviceDelaysController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<serviceDelay,String> serviceNameCol;
    @javafx.fxml.FXML
    private TableColumn<serviceDelay,Integer> idCol;
    @javafx.fxml.FXML
    private TableView<serviceDelay> delayServices;
    @javafx.fxml.FXML
    private ComboBox<String> combobox;
    @javafx.fxml.FXML
    private TableColumn<serviceDelay,String> delayedCol;
    @javafx.fxml.FXML
    private TextField completionField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField delayedByField;
    @javafx.fxml.FXML
    private TextField delayReasonField;

    ArrayList<serviceDelay> delayList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("serviceID"));
        serviceNameCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        delayedCol.setCellValueFactory(new PropertyValueFactory<>("delayedBy"));



        combobox.getItems().addAll("Rescheduled", "Parts Arrived", "Work Started", "Completed");

        delayList.add(new serviceDelay(101, "Engine Overhaul", "Employee A", "Parts Delay", "2 Days"));
        delayList.add(new serviceDelay(102, "AC Repair", "Employee B", "Mechanic Sick", "1 Day"));
        delayList.add(new serviceDelay(103, "Body Paint", "Employee C", "Color Shortage", "3 Days"));
        delayList.add(new serviceDelay(104, "Wheel Alignment", "Employee D", "Machine Issue", "5 Hours"));

        delayServices.getItems().addAll(delayList);

        delayServices.setOnMouseClicked(event -> {
            serviceDelay d = delayServices.getSelectionModel().getSelectedItem();
            if (d != null) {
                loadRequestDetails(d);
            }
        });
    }

    private void loadRequestDetails(serviceDelay Delay) {
        nameField.setText(Delay.getServiceName());
        delayedByField.setText(Delay.getDelayedBy());
        delayReasonField.setText(Delay.getDelayReason());
        completionField.setText(Delay.getExpectedCompletion());

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
    public void updateStatusButton(ActionEvent actionEvent) {
        serviceDelay selected = delayServices.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText(" Please select a delayed service!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (combobox.getValue() == null) {
            outputLabel.setText(" Please give a solution");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        selected.setExpectedCompletion(completionField.getText());

        delayServices.refresh();

        outputLabel.setText(" Delay handled successfully!");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
    }
}