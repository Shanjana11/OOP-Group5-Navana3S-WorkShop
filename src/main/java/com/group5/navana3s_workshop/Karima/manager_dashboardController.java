package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class manager_dashboardController
{
    @javafx.fxml.FXML
    private Label scheduleService;
    @javafx.fxml.FXML
    private Label assignStaff;
    @javafx.fxml.FXML
    private Label resourceAllocation;
    @javafx.fxml.FXML
    private TextField todaysJobsField;
    @javafx.fxml.FXML
    private Label staffPerformance;
    @javafx.fxml.FXML
    private Label activeStaffsLabel;
    @javafx.fxml.FXML
    private Label serviceReports;
    @javafx.fxml.FXML
    private TextField pendingField;
    @javafx.fxml.FXML
    private Label qualityInspection;
    @javafx.fxml.FXML
    private Label customerFeedback;
    @javafx.fxml.FXML
    private Label pendingLabel;
    @javafx.fxml.FXML
    private Label complaintResolution;
    @javafx.fxml.FXML
    private TextField activeStaffsField;
    @javafx.fxml.FXML
    private Label todaysJobsLabel;

    @javafx.fxml.FXML
    public void initialize() {
        updateDashboard(12, 8, 3);
        todaysJobsField.setText("12");
        activeStaffsField.setText("8");
        pendingField.setText("3");

    }

    public void updateDashboard(int jobs, int activeStaff, int pendingComplaints) {

    }

    @javafx.fxml.FXML
    public void resourceAllocationButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerFeedbackButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void qualityInspectionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void serviceReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void staffPerformanceButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void complaintResolutionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button loginButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void assignStaffButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void scheduleServiceButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/dailySchedule.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button loginButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }
}