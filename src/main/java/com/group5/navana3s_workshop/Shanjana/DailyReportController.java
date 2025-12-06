package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DailyReportController {

    @FXML
    private TableView<DailyJob> dailyJobsTable;
    @FXML
    private TableColumn<DailyJob, String> vehicleCol;
    @FXML
    private TableColumn<DailyJob, String> serviceCol;
    @FXML
    private TableColumn<DailyJob, String> technicianCol;
    @FXML
    private TableColumn<DailyJob, String> statusCol;
    @FXML
    private DatePicker reportDatePicker;
    @FXML
    private Label infoLabel;

    private final String FILE_PATH = "daily_jobs.dat";
    private ObservableList<DailyJob> dailyJobsList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        vehicleCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("vehicleId"));
        serviceCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("serviceType"));
        technicianCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("technician"));
        statusCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));

        // Load data
        List<DailyJob> jobs = loadOrCreateData();
        dailyJobsList.setAll(jobs);
        dailyJobsTable.setItems(dailyJobsList);
    }

    private List<DailyJob> loadOrCreateData() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return createDummyData();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<DailyJob>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return createDummyData();
        }
    }

    private List<DailyJob> createDummyData() {
        List<DailyJob> dummy = new ArrayList<>();
        dummy.add(new DailyJob("VH101", "Oil Change", "Technician A", "Completed", LocalDate.now()));
        dummy.add(new DailyJob("VH102", "Brake Service", "Technician B", "In Progress", LocalDate.now()));
        dummy.add(new DailyJob("VH103", "AC Service", "Technician C", "Pending", LocalDate.now()));
        dummy.add(new DailyJob("VH104", "Engine Repair", "Technician D", "Completed", LocalDate.now()));
        dummy.add(new DailyJob("VH105", "Tire Change", "Technician E", "In Progress", LocalDate.now()));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(dummy);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dummy;
    }

    @FXML
    public void handleGenerateButton(ActionEvent actionEvent) {
        LocalDate selectedDate = reportDatePicker.getValue();
        if (selectedDate == null) {
            infoLabel.setText("Please select a date.");
            return;
        }

        List<DailyJob> filtered = new ArrayList<>();
        for (DailyJob job : dailyJobsList) {
            if (job.getDate().equals(selectedDate)) {
                filtered.add(job);
            }
        }

        dailyJobsTable.setItems(FXCollections.observableArrayList(filtered));
        infoLabel.setText("Showing report for: " + selectedDate);
    }

    @FXML
    public void handleSubmitToManagerButton(ActionEvent actionEvent) {
        infoLabel.setText("Report submitted to manager successfully.");
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
