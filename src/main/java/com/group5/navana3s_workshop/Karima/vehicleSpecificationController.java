package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class vehicleSpecificationController
{
    @javafx.fxml.FXML
    private ComboBox<String> modelField;
    @javafx.fxml.FXML
    private TextField fuelTypeField;
    @javafx.fxml.FXML
    private TextField featuresField;
    @javafx.fxml.FXML
    private TextField engineTypeField;

    ArrayList<vehicle> vehicleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        vehicleList.add(new vehicle("Toyota Corolla", "Petrol",
                "ABS, Airbags, Cruise Control", "1.8L Dual VVT-i", 10));

        vehicleList.add(new vehicle("Toyota Axio", "Hybrid",
                "Auto AC, Eco Mode", "1.5L Hybrid", 5));

        vehicleList.add(new vehicle("Honda Civic", "Petrol",
                "Sunroof, Lane Assist", "1.5L Turbo", 3));


        for (vehicle v : vehicleList) {
            modelField.getItems().add(v.getModel());
        }

        modelField.setOnAction(e -> loadVehicleSpecs());
    }

    private void loadVehicleSpecs() {
        String selectedModel = modelField.getValue();

        if (selectedModel == null) {
            return;
        }


        for (vehicle v : vehicleList) {
            if (v.getModel().equals(selectedModel)) {
                fuelTypeField.setText(v.getFuelType());
                featuresField.setText(v.getFeatures());
                engineTypeField.setText(v.getEngineType());
                break;
            }
        }
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
    public void specSheetButton(ActionEvent actionEvent) {
        String model = modelField.getValue();
        if (model == null) return;

        Stage stage = new Stage();
        stage.setTitle(model + " Specification Sheet");

        VBox box = new VBox(10);
        box.setStyle("-fx-padding: 20;");

        box.getChildren().add(new Label("Model: " + model));
        box.getChildren().add(new Label("Fuel Type: " + fuelTypeField.getText()));
        box.getChildren().add(new Label("Engine Type: " + engineTypeField.getText()));
        box.getChildren().add(new Label("Features: " + featuresField.getText()));

        stage.setScene(new Scene(box, 350, 200));
        stage.show();
    }


}