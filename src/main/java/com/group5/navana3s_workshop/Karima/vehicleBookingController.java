package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.vehicleBooking;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class vehicleBookingController {
    @javafx.fxml.FXML
    private ComboBox<String> modelField;
    @javafx.fxml.FXML
    private TextField numberField;
    @javafx.fxml.FXML
    private ComboBox<String> colorField;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private TextField nameField;

    private int corollaStock = 3;
    private int axioStock = 0;
    private int civicStock = 2;


    @javafx.fxml.FXML
    public void initialize() {
        modelField.getItems().addAll("Toyota Corolla", "Toyota Axio", "Honda Civic");
        colorField.getItems().addAll("White", "Black", "Silver");

        textArea.setText("");
    }

    @javafx.fxml.FXML
    public void availabilityButton(ActionEvent actionEvent) {
        String model = modelField.getValue();

        if (model == null) {
            textArea.setText("Please select a vehicle model first.");
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
    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void bookingButton(ActionEvent actionEvent) {

        String model = modelField.getValue();
        String name = nameField.getText();
        String color = colorField.getValue();
        String number = numberField.getText();

        if (model == null || color == null || name.isEmpty() || number.isEmpty()) {
            textArea.setText("Please fill all details before booking.");
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
            textArea.setText("Booking Failed!\n\nSorry, " + model + " is currently not available.\nPlease check availability or choose another model.");
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
                "=== Booking Receipt ===\n\n" +
                        "Customer Name: " + name + "\n" +
                        "Vehicle Model: " + model + "\n" +
                        "Color: " + color + "\n" +
                        "Contact Number: " + number + "\n\n" +
                        "Booking Status: Confirmed ✔"
        );

    }

}