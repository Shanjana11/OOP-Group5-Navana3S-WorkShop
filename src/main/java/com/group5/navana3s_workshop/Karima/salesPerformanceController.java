package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class salesPerformanceController
{
    @javafx.fxml.FXML
    private TextArea reportAreaField;
    @javafx.fxml.FXML
    private TextField targetField;
    @javafx.fxml.FXML
    private TableColumn<salesPerformanceController,Integer> contactCol;
    @javafx.fxml.FXML
    private TableColumn<salesPerformanceController,String> nameCol;
    @javafx.fxml.FXML
    private TextField salesField;
    @javafx.fxml.FXML
    private TableView<salesPerformanceController> tableView;
    @javafx.fxml.FXML
    private TableColumn<salesPerformanceController,String> modelCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void pendingLeadsButton(ActionEvent actionEvent) {
    }
}