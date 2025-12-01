package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DailyReportController
{
    @javafx.fxml.FXML
    private TableView dailyJobsTable;
    @javafx.fxml.FXML
    private DatePicker reportDatePicker;
    @javafx.fxml.FXML
    private Label totalJobsLabel;
    @javafx.fxml.FXML
    private TableColumn customerCol;
    @javafx.fxml.FXML
    private Label totalRevenueLabel;
    @javafx.fxml.FXML
    private TableColumn amountCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private Label pendingJobsLabel;
    @javafx.fxml.FXML
    private TableColumn jobCardCol;
    @javafx.fxml.FXML
    private TableColumn vehicleCol;
    @javafx.fxml.FXML
    private TableColumn serviceCol;
    @javafx.fxml.FXML
    private Label completedJobsLabel;
    @javafx.fxml.FXML
    private Label infoLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmitToManagerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void handleGenerateButton(ActionEvent actionEvent) {
    }
}