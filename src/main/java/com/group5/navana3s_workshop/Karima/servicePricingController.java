package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.servicePricing;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class servicePricingController
{
    @javafx.fxml.FXML
    private TableView<servicePricing> tableView;
    @javafx.fxml.FXML
    private TableColumn<servicePricing,String> serviceNameCol;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TableColumn<servicePricing,String> serviceIdCol;
    @javafx.fxml.FXML
    private TextField currentPriceField;
    @javafx.fxml.FXML
    private TextField newPriceField;
    @javafx.fxml.FXML
    private TableColumn<servicePricing,Double> currentPriceCol;
    @javafx.fxml.FXML
    private TextField serviceNameField;
    @javafx.fxml.FXML
    private TextField serviceidField;

    @javafx.fxml.FXML
    public void initialize() {
        serviceIdCol.setCellValueFactory(new PropertyValueFactory<>("serviceId"));
        serviceNameCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        currentPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView.getItems().add(new servicePricing("S101", "Engine Oil Change", 1500));
        tableView.getItems().add(new servicePricing("S102", "Full Service", 4500));
        tableView.getItems().add(new servicePricing("S103", "Wheel Alignment", 800));
        tableView.getItems().add(new servicePricing("S104", "AC Checkup", 1200));

        servicePricing selected = tableView.getSelectionModel().getSelectedItem();

        if (selected != null) {
            serviceidField.setText(selected.getServiceId());
            serviceNameField.setText(selected.getServiceName());
            currentPriceField.setText(String.valueOf(selected.getPrice()));
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
    public void updatePriceButton(ActionEvent actionEvent) {
        servicePricing selected = tableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a service first.");
            return;
        }

        String newPriceText = newPriceField.getText().trim();

        if (newPriceText.isEmpty()) {
            outputLabel.setText("Enter new price.");
            return;
        }

        double newPrice;

        try {
            newPrice = Double.parseDouble(newPriceText);
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid price.");
            return;
        }

        selected.setPrice(newPrice);

        tableView.refresh();

        currentPriceField.setText(String.valueOf(newPrice));

        newPriceField.clear();

        outputLabel.setText("Price updated successfully.");
    }

    @javafx.fxml.FXML
    public void savePricingButton(ActionEvent actionEvent) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pricing.bin"))) {

            for (servicePricing sp : tableView.getItems()) {
                out.writeObject(sp);
            }

            outputLabel.setText("Pricing saved!");
        } catch (Exception e) {
            outputLabel.setText("Error!");
        }
    }

    @javafx.fxml.FXML
    public void loadPricingButton(ActionEvent actionEvent) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pricing.bin"))) {

            while (true) {
                servicePricing sp = (servicePricing) in.readObject();
                tableView.getItems().add(sp);
            }

        } catch (EOFException e) {
            outputLabel.setText("Pricing loaded!");
        } catch (Exception e) {
            outputLabel.setText("Error!");
        }
    }
}