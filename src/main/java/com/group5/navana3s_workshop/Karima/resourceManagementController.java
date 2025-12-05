package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.resourceAllocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class resourceManagementController
{
    @javafx.fxml.FXML
    private TableColumn<resourceAllocation,Integer> vehicleNoCol;
    @javafx.fxml.FXML
    private ComboBox<String> reallocateCombobox;
    @javafx.fxml.FXML
    private TableColumn<resourceAllocation,String> availabilityCol;
    @javafx.fxml.FXML
    private ComboBox<String> assignCombobox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<resourceAllocation,Integer> jobIdCol;
    @javafx.fxml.FXML
    private TableView<resourceAllocation> staffTable;
    @javafx.fxml.FXML
    private TableColumn<resourceAllocation,String> staffNameCol;
    @javafx.fxml.FXML
    private TableView<resourceAllocation> workloadTable;
    @javafx.fxml.FXML
    private BarChart<String, Number> barChart;
    @javafx.fxml.FXML
    private TableColumn<resourceAllocation,String> nameCol;

    @javafx.fxml.FXML
    public void initialize() {

        vehicleNoCol.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        jobIdCol.setCellValueFactory(new PropertyValueFactory<>("jobId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));


        staffNameCol.setCellValueFactory(new PropertyValueFactory<>("staffName"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));



        workloadTable.getItems().add(new resourceAllocation("Employee A", "Engine Repair", "Busy",1,123));
        workloadTable.getItems().add(new resourceAllocation("Employee B", "AC Service", "Busy",2,456));

        staffTable.getItems().add(new resourceAllocation("Employee C", "None", "Available",3,678));
        staffTable.getItems().add(new resourceAllocation("Employee D", "None", "Available",4,789));


        assignCombobox.getItems().addAll("Oil Change", "Battery Check", "Wheel Alignment", "Diagnosis");

        reallocateCombobox.getItems().addAll("Employee C","Employee D");

        XYChart.Series<String, Number> workloadSeries = new XYChart.Series<>();
        workloadSeries.setName("Current Workload");


        workloadSeries.getData().add(new XYChart.Data<>("Employee A", 5));
        workloadSeries.getData().add(new XYChart.Data<>("Employee B", 8));
        workloadSeries.getData().add(new XYChart.Data<>("Employee C", 2));
        workloadSeries.getData().add(new XYChart.Data<>("Employee D", 3));

        barChart.getData().clear();
        barChart.getData().add(workloadSeries);
    }

    @javafx.fxml.FXML
    public void saveAllocationButton(ActionEvent actionEvent) {
        String selectedStaff = reallocateCombobox.getValue();
        String newTask = assignCombobox.getValue();

        if (selectedStaff == null || newTask == null) {
            outputLabel.setText("Please select staff and task!");
            return;
        }

        // Event 4 → Verify staff availability
        for (resourceAllocation r : staffTable.getItems()) {

            if (r.getStaffName().equals(selectedStaff)) {

                if (!r.getAvailabilityStatus().equals("Available")) {
                    outputLabel.setText(selectedStaff + " is NOT available for reassignment!");
                    return;
                }
                r.setAssignedTask(newTask);
                r.setAvailabilityStatus("Busy");

                outputLabel.setText("Resource allocation saved successfully!");
                staffTable.refresh();
                return;
            }
        }

        outputLabel.setText("Error: Staff not found!");
        outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button logOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}