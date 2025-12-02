package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.FinancingPlan;
import com.group5.navana3s_workshop.Karima.modelClass.salesHistory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class salesHistoryController
{
    @javafx.fxml.FXML
    private TableColumn<salesHistory,Integer> amountCol;
    @javafx.fxml.FXML
    private TableColumn<salesHistory, LocalDate> dateCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private DatePicker endDate;
    @javafx.fxml.FXML
    private TableColumn<salesHistory,String> nameCol;
    @javafx.fxml.FXML
    private TableView<salesHistory> tableView;
    @javafx.fxml.FXML
    private DatePicker startDate;
    @javafx.fxml.FXML
    private TableColumn<salesHistory,String> modelCol;

    ArrayList<salesHistory> sales = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        sales.add(new salesHistory("Karim", "Sedan", 1500000, "2025-01-12"));
        sales.add(new salesHistory("Lima", "SUV", 2200000, "2025-01-19"));
        sales.add(new salesHistory("Rafi", "Hatchback", 1250000, "2025-02-01"));
        sales.add(new salesHistory("Sonia", "Pickup", 1950000, "2025-02-10"));


        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));


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
        tableView.getItems().clear();

        if (startDate.getValue() == null || endDate.getValue() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please select both dates.");
            a.show();
            return;
        }

        String start = startDate.getValue().toString();
        String end = endDate.getValue().toString();

        for (salesHistory s : sales) {
            if (s.getDate().compareTo(start) >= 0 &&
                    s.getDate().compareTo(end) <= 0) {
                tableView.getItems().add(s);
            }
        }

    }
}


