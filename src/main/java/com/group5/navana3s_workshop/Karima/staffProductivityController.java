package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.CompletedService;
import com.group5.navana3s_workshop.Karima.modelClass.staffProductivity;
import com.group5.navana3s_workshop.Karima.modelClass.vehicleBooking;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class staffProductivityController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private BarChart<String, Number> barChart;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TextField statusField;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField hourField;

    ArrayList<staffProductivity> productivityList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {


        productivityList.add(new staffProductivity("Employee A", "Present", 8, 7,  "Excellent",5));
        productivityList.add(new staffProductivity("Employee B", "Present", 6, 8, "Good",4));
        productivityList.add(new staffProductivity("Employee C", "Absent", 0, 0, "N/A",0));



        XYChart.Series<String, Number> workloadSeries = new XYChart.Series<>();
        workloadSeries.setName("Productivity Rating");


        workloadSeries.getData().add(new XYChart.Data<>("Employee A", 5));
        workloadSeries.getData().add(new XYChart.Data<>("Employee B", 4));
        workloadSeries.getData().add(new XYChart.Data<>("Employee C", 0));


        barChart.getData().clear();
        barChart.getData().add(workloadSeries);


    }

    @javafx.fxml.FXML
    public void reportButton(ActionEvent actionEvent) {

        if (textArea == null) {
            outputLabel.setText("Please select a staff first.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        textArea.setText(
                "Staff Name: " + nameField.getText() + "\n" +
                        "Status: " + statusField.getText() + "\n" +
                        "Hours Worked: " + hourField.getText() + "\n" +
                        "Jobs Completed: " + getJobsCompleted(nameField.getText()) + "\n" +
                        "Rating: " + getRating(nameField.getText()) + "\n" +
                        "Efficiency: " + getEfficiency(nameField.getText())
        );

        outputLabel.setText("Productivity report generated successfully!");

    }

    private int getJobsCompleted(String name) {
        for (staffProductivity sp : productivityList) {
            if (sp.getStaffName().equalsIgnoreCase(name)) {
                return sp.getJobsCompleted();
            }
        }
        return 0;
    }

    private String getRating(String name) {
        for (staffProductivity sp : productivityList) {
            if (sp.getStaffName().equalsIgnoreCase(name)) {
                return sp.getRating();
            }
        }
        return "N/A";
    }

    private double getEfficiency(String name) {
        for (staffProductivity sp : productivityList) {
            if (sp.getStaffName().equalsIgnoreCase(name)) {
                return sp.getEfficiency();
            }
        }
        return 0.0;
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
    public void loadButton(ActionEvent actionEvent) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("productivity.bin"))) {
            productivityList = (ArrayList<staffProductivity>) in.readObject();
            outputLabel.setText("Loaded Successfully");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        } catch (Exception e) {
            outputLabel.setText("No file found!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("productivity.bin"))) {
            out.writeObject(productivityList);
            outputLabel.setText("Saved!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        } catch (Exception e) {
            outputLabel.setText("Save failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
}