package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.customerConsultation;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class customerConsultationController
{
    @javafx.fxml.FXML
    private ComboBox<String> budgetField;
    @javafx.fxml.FXML
    private ComboBox<String> modelField;
    @javafx.fxml.FXML
    private TableColumn<customerConsultation,String> budgetCol;
    @javafx.fxml.FXML
    private TableView<customerConsultation> tableView;
    @javafx.fxml.FXML
    private TableColumn<customerConsultation,String> colorCol;
    @javafx.fxml.FXML
    private ComboBox<String> colorField;
    @javafx.fxml.FXML
    private TableColumn<customerConsultation,String> modelCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @FXML
    private BarChart<String, Number> barChart;

    @javafx.fxml.FXML
    public void initialize() {
        budgetField.getItems().addAll("10-15 Lakh", "15-20 Lakh", "20-25 Lakh");
        modelField.getItems().addAll("Toyota Corolla", "Toyota Axio", "Honda Civic");
        colorField.getItems().addAll("White", "Black", "Silver");

        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));

        XYChart.Series<String, Number> workloadSeries = new XYChart.Series<>();
        workloadSeries.setName("Customer Consultation");


        workloadSeries.getData().add(new XYChart.Data<>("Toyota Corolla", 15));
        workloadSeries.getData().add(new XYChart.Data<>("Toyota Axio", 20));
        workloadSeries.getData().add(new XYChart.Data<>("Honda Civic", 25));


        barChart.getData().clear();
        barChart.getData().add(workloadSeries);


    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String b = budgetField.getValue();
        String m = modelField.getValue();
        String c = colorField.getValue();


        if(b == null || m == null || c == null) {
            return;
        }
        tableView.getItems().clear();
        if(m.equals("Toyota Corolla")) {
            tableView.getItems().add(new customerConsultation(b, "Toyota Corolla", c));
            tableView.getItems().add(new customerConsultation(b, "Toyota Corolla XLE", c));
        } else {
            tableView.getItems().add(new customerConsultation(b, m, c));
        }

        outputLabel.setText(" Search completed: " + tableView.getItems().size() + " vehicle(s) found");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
    }

    @FXML
    public void quotationButton(ActionEvent actionEvent) {
        customerConsultation v = tableView.getSelectionModel().getSelectedItem();

        if (v == null) {
            outputLabel.setText(" Please select a vehicle first!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        String basePrice = v.getBudget();

        int minPrice = Integer.parseInt(basePrice.split("-")[0]) * 100000;
        int maxPrice = Integer.parseInt(basePrice.split("-")[1].split(" ")[0]) * 100000;
        int estimated = (minPrice + maxPrice) / 2;

        double vat = estimated * 0.15;
        double total = estimated + vat;


        outputLabel.setStyle("-fx-text-fill: green; -fx-font-size: 14px;");
        outputLabel.setText(
                "Quotation for " + v.getModel() + "\n" +
                        "Base Price: " + estimated + " BDT\n" +
                        "VAT (15%): " + vat + " BDT\n" +
                        "Total Cost: " + total + " BDT"
        );
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }


    @FXML
    public void loadButton(ActionEvent actionEvent) {
        tableView.getItems().clear();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("sales.bin"))) {

            while (true) {
                customerConsultation s = (customerConsultation) in.readObject();
                tableView.getItems().add(s);
            }

        } catch (EOFException ex) {
            outputLabel.setText("Sales loaded!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        } catch (Exception ex) {
            outputLabel.setText("Loading failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }


    @FXML
    public void saveButton(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sales.bin"))) {

            for (customerConsultation s : tableView.getItems()) {
                out.writeObject(s);
            }

            outputLabel.setText("Sales saved!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        } catch (IOException ex) {
            outputLabel.setText("Saving failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
}
