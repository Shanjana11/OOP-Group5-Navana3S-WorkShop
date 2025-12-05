package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.vehicleBooking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class vehicleBookingController {
    @FXML
    private ComboBox<String> modelField;
    @FXML
    private TextField numberField;
    @FXML
    private ComboBox<String> colorField;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField nameField;
    @FXML
    private Label outputLabel;

    private int corollaStock = 3;
    private int axioStock = 0;
    private int civicStock = 2;


    @FXML
    public void initialize() {
        modelField.getItems().addAll("Toyota Corolla", "Toyota Axio", "Honda Civic");
        colorField.getItems().addAll("White", "Black", "Silver");

        textArea.setText("");
    }

    @FXML
    public void availabilityButton(ActionEvent actionEvent) {
        String model = modelField.getValue();
        String customerName = nameField.getText();
        String contact = numberField.getText();

        if (customerName == null) {
            outputLabel.setText("Please enter Customer Name");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (contact == null) {
            outputLabel.setText("Please enter Contact Number");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (model == null) {
            outputLabel.setText("Please select a vehicle model first.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        if (model.equals("Toyota Corolla")) {
            if (corollaStock > 0) textArea.setText("Status: Available (" + corollaStock + " in stock)");
            else textArea.setText("Status: Not Available");
        } else if (model.equals("Toyota Axio")) {
            if (axioStock > 0) textArea.setText("Status: Available (" + axioStock + " in stock)");
            else textArea.setText("Status: Not Available");
        } else if (model.equals("Honda Civic")) {
            if (civicStock > 0) textArea.setText("Status: Available (" + civicStock + " in stock)");
            else textArea.setText("Status: Not Available");
        }

    }
    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void bookingButton(ActionEvent actionEvent) {

        String model = modelField.getValue();
        String name = nameField.getText();
        String color = colorField.getValue();
        String number = numberField.getText();

        if (model == null || color == null || name.isEmpty() || number.isEmpty()) {
            outputLabel.setText("Please fill all details before booking.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }


        int currentStock = 0;
        if (model.equals("Toyota Corolla")) {
            currentStock = corollaStock;
        } else if (model.equals("Toyota Axio")) {
            currentStock = axioStock;
        } else if (model.equals("Honda Civic")) {
            currentStock = civicStock;
        }


        if (currentStock == 0) {
            outputLabel.setText("Booking Failed!\n\nSorry, " + model + " is currently not available.\nPlease check availability or choose another model.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

            return;
        }


        if (model.equals("Toyota Corolla")) {
            corollaStock--;
        } else if (model.equals("Toyota Axio")) {
            axioStock--;
        } else if (model.equals("Honda Civic")) {
            civicStock--;
        }

        textArea.setText(
                " Booking Receipt \n\n" +
                        "Customer Name: " + name + "\n" +
                        "Vehicle Model: " + model + "\n" +
                        "Color: " + color + "\n" +
                        "Contact Number: " + number + "\n\n" +
                        "Booking Status: Confirmed ✔"
        );

    }

    @FXML
    public void loadButton(ActionEvent actionEvent) {
        ArrayList<vehicleBooking> vehicleList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("booking.bin"))) {
            vehicleList = (ArrayList<vehicleBooking>) in.readObject();
            outputLabel.setText("Loaded " + vehicleList.size() + " bookings");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        } catch (Exception e) {
            outputLabel.setText("No file found!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }

    @FXML
    public void saveButton(ActionEvent actionEvent) {

        ArrayList<vehicleBooking> vehicleList = new ArrayList<>();
        String customerName = "Customer Name";
        String model="model";
        String color="color";
        String contact="contact";


        vehicleBooking info = new vehicleBooking(customerName, model, color,contact);
        vehicleList.add(info);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("booking.bin"))) {
            out.writeObject(vehicleList);
            outputLabel.setText("Saved!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        } catch (Exception e) {
            outputLabel.setText("Save failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
}