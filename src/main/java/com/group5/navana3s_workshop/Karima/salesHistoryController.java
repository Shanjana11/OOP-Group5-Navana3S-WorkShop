package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class salesHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<salesHistoryController,Integer> amountCol;
    @javafx.fxml.FXML
    private TableColumn<salesHistoryController, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private DatePicker endDate;
    @javafx.fxml.FXML
    private TableColumn<salesHistoryController,String> nameCol;
    @javafx.fxml.FXML
    private TableView<salesHistoryController> tableView;
    @javafx.fxml.FXML
    private DatePicker startDate;
    @javafx.fxml.FXML
    private TableColumn<salesHistoryController,String> modelCol;

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
    public void viewHistoryButton(ActionEvent actionEvent) {
    }
}