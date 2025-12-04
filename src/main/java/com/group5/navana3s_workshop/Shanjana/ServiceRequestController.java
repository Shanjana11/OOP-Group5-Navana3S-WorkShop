package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceRequestController {

    @javafx.fxml.FXML
    private TextField vehicleField;
    @javafx.fxml.FXML
    private ComboBox<String> serviceCombo;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private DatePicker datePick;
    @javafx.fxml.FXML
    private TextField bookingID;

    private final String FILE_PATH = "bookings.dat";

    @javafx.fxml.FXML
    public void initialize() {
        serviceCombo.getItems().addAll(
                "Regular Service",
                "Oil Change",
                "Brake Service",
                "Engine Repair",
                "AC Service",
                "Tire Change"
        );
    }

    @javafx.fxml.FXML
    public void generateID(ActionEvent actionEvent) {
        int randomNum = new Random().nextInt(90000) + 10000;
        String id = "BK" + randomNum;
        bookingID.setText(id);
        infoLabel.setText("Generated Booking ID");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
        String id = bookingID.getText().trim();
        String vehicle = vehicleField.getText().trim();
        String service = serviceCombo.getValue();
        LocalDate date = datePick.getValue();

        if (id.isEmpty() || vehicle.isEmpty() || service == null || date == null) {
            infoLabel.setText("Please fill all fields");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            infoLabel.setText("Booking Date cannot be in the past");
            return;
        }

        // Use "N/A" for timeSlot as service request form has no slot
        BookService newBooking = new BookService(vehicle, date, "N/A", service, id);

        saveBooking(newBooking);
        infoLabel.setText("Booking Saved Successfully");
    }

    private void saveBooking(BookService booking) {
        List<BookService> list = loadBookings();
        list.add(booking);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<BookService> loadBookings() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<BookService>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
