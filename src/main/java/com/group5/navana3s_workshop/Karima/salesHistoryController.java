package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.FinancingPlan;
import com.group5.navana3s_workshop.Karima.modelClass.salesHistory;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
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
    @javafx.fxml.FXML
    private LineChart<String, Number> lineChart;
    @javafx.fxml.FXML
    private TableColumn<salesHistory,LocalDate> dateCol;

    ArrayList<salesHistory> sales = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {

        sales.add(new salesHistory("Employee A", "Toyota Corolla", 1500000, "2025-10-15"));
        sales.add(new salesHistory("Employee B", "Toyota Axio", 2200000,"2025-11-10"));
        sales.add(new salesHistory("Employee C", "Honda Civic", 1250000,"2025-11-05"));


        nameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("vehicleModel"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));



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
        lineChart.getData().clear();

        LocalDate start = startDate.getValue();
        LocalDate end = endDate.getValue();

        if (start == null || end == null) {
            outputLabel.setText("Select dates");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sales Amount");

       for (salesHistory s : sales) {

            LocalDate saleDate = LocalDate.parse(s.getDate());

            if ((saleDate.isEqual(start) || saleDate.isAfter(start)) &&
                   (saleDate.isEqual(end) || saleDate.isBefore(end))) {

                tableView.getItems().add(s);
                series.getData().add(
                        new XYChart.Data<>(s.getDate(), s.getAmount())
                );
            }
        }

        lineChart.getData().add(series);
        outputLabel.setText("Sales History Loaded & Chart Updated.");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

    }
}


