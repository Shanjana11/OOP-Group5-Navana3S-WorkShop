package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDeliveryController {

    @FXML private TableColumn<VehicleDelivery, String> vehicleCol;
    @FXML private TableColumn<VehicleDelivery, String> serviceTypeCol;
    @FXML private TableView<VehicleDelivery> readyForDeliveryTable;

    @FXML private CheckBox invoicePaidCheckBox;
    @FXML private CheckBox vehicleCleanedCheckBox;
    @FXML private CheckBox keysAvailableCheckBox;
    @FXML private CheckBox finalInspectionCheckBox;

    @FXML private ComboBox<String> bookingIDCombo;
    @FXML private Label infoLabel;

    private final String BOOKINGS_FILE = "bookings.dat";
    private final String DELIVERY_FILE = "delivery.dat";

    private List<BookService> bookingsList = new ArrayList<>();

    @FXML
    public void initialize() {
        vehicleCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("vehicleId"));
        serviceTypeCol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("serviceType"));

        loadBookings();
    }

    private void loadBookings() {
        File file = new File(BOOKINGS_FILE);

        if (!file.exists() || file.length() == 0) {
            loadDummyBookings();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                bookingsList = (List<BookService>) ois.readObject();
            } catch (Exception e) {
                loadDummyBookings();
            }
        }

        bookingIDCombo.getItems().clear();
        for (BookService b : bookingsList) {
            bookingIDCombo.getItems().add(b.getBookingId());
        }
    }

    private void loadDummyBookings() {
        bookingsList = new ArrayList<>();
        bookingsList.add(new BookService("Car-001", null, "09:00 AM", "Engine Service", "BK101"));
        bookingsList.add(new BookService("Car-002", null, "11:00 AM", "Brake Service", "BK102"));
        bookingsList.add(new BookService("Car-003", null, "02:00 PM", "AC Service", "BK103"));
    }

    @FXML
    public void showInfo(ActionEvent actionEvent) {
        String selectedId = bookingIDCombo.getValue();
        if (selectedId == null) {
            infoLabel.setText("Select a booking ID first.");
            return;
        }

        BookService match = bookingsList.stream()
                .filter(b -> b.getBookingId().equals(selectedId))
                .findFirst().orElse(null);

        if (match == null) {
            infoLabel.setText("No matching booking found.");
            readyForDeliveryTable.setItems(FXCollections.observableArrayList());
            return;
        }

        VehicleDelivery vd = new VehicleDelivery(
                match.getBookingId(),
                match.getVehicleId(),
                match.getServiceType(),
                "Pending"
        );

        readyForDeliveryTable.setItems(FXCollections.observableArrayList(vd));
        infoLabel.setText("Booking info loaded.");
    }

    @FXML
    public void handleCompleteDeliveryButton(ActionEvent actionEvent) {
        if (!invoicePaidCheckBox.isSelected() || !vehicleCleanedCheckBox.isSelected()
                || !keysAvailableCheckBox.isSelected() || !finalInspectionCheckBox.isSelected()) {
            infoLabel.setText("Complete all inspection steps.");
            return;
        }

        VehicleDelivery vd = readyForDeliveryTable.getItems().isEmpty() ? null : readyForDeliveryTable.getItems().get(0);

        if (vd == null) {
            infoLabel.setText("Load booking info first.");
            return;
        }

        vd.setDeliveryStatus("Delivered");
        saveDelivery(vd);
        infoLabel.setText("Delivery completed and saved.");
    }

    private void saveDelivery(VehicleDelivery vd) {
        List<VehicleDelivery> list;

        File file = new File(DELIVERY_FILE);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (List<VehicleDelivery>) ois.readObject();
            } catch (Exception e) {
                list = new ArrayList<>();
            }
        } else {
            list = new ArrayList<>();
        }

        list.add(vd);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
