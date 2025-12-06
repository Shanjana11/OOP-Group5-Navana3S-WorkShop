package com.group5.navana3s_workshop.Shanjana;


import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceProgressController {

    @FXML
    private Label infoLabel;
    @FXML
    private TextArea serviceDetArea;
    @FXML
    private ComboBox<String> BookingIDCombo;

    private final String TECHNICIAN_FILE = "techniciantask.dat";
    private final String PROGRESS_FILE = "service_progress.dat";

    private List<ServiceStatus> bookingsList = new ArrayList<>();
    private List<ServiceStatus> progressList = new ArrayList<>();

    @FXML
    public void initialize() {
        loadBookings();
        loadProgress();
    }

    private void loadBookings() {
        File file = new File(TECHNICIAN_FILE);

        if (!file.exists() || file.length() == 0) {
            // Create dummy data if file not exist
            bookingsList = createDummyBookings();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                bookingsList = (List<ServiceStatus>) ois.readObject();
            } catch (Exception e) {
                bookingsList = createDummyBookings();
            }
        }

        BookingIDCombo.getItems().clear();
        for (ServiceStatus sp : bookingsList) {
            BookingIDCombo.getItems().add(sp.getBookingId());
        }
    }

    private List<ServiceStatus> createDummyBookings() {
        List<ServiceStatus> dummy = new ArrayList<>();
        dummy.add(new ServiceStatus("BK101", "Car-001", "Engine Repair", "Pending"));
        dummy.add(new ServiceStatus("BK102", "Car-002", "AC Service", "Pending"));
        dummy.add(new ServiceStatus("BK103", "Car-003", "Brake Service", "Pending"));
        dummy.add(new ServiceStatus("BK104", "Car-004", "Oil Change", "Pending"));
        return dummy;
    }

    private void loadProgress() {
        File file = new File(PROGRESS_FILE);
        if (!file.exists() || file.length() == 0) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            progressList = (List<ServiceStatus>) ois.readObject();
        } catch (Exception e) {
            progressList = new ArrayList<>();
        }
    }

    @FXML
    public void load(ActionEvent actionEvent) {
        String selectedId = BookingIDCombo.getValue();

        if (selectedId == null) {
            infoLabel.setText("Select a booking ID first.");
            return;
        }

        ServiceStatus sp = bookingsList.stream()
                .filter(b -> b.getBookingId().equals(selectedId))
                .findFirst()
                .orElse(null);

        if (sp == null) {
            infoLabel.setText("Booking ID not found.");
            serviceDetArea.clear();
            return;
        }

        serviceDetArea.setText(
                "Booking ID: " + sp.getBookingId() + "\n" +
                        "Vehicle ID: " + sp.getVehicleId() + "\n" +
                        "Service Type: " + sp.getServiceType() + "\n" +
                        "Status: " + sp.getStatus()
        );

        infoLabel.setText("Booking details loaded.");
    }

    @FXML
    public void handleUpdateProgressButton(ActionEvent actionEvent) {
        String selectedId = BookingIDCombo.getValue();

        if (selectedId == null) {
            infoLabel.setText("Select a booking ID first.");
            return;
        }

        ServiceStatus sp = bookingsList.stream().filter(b -> b.getBookingId().equals(selectedId)).findFirst().orElse(null);

        if (sp == null) {
            infoLabel.setText("Booking ID not found.");
            return;
        }

        // Update status from TextArea input (last line)
        String[] lines = serviceDetArea.getText().split("\n");
        if (lines.length < 4) {
            infoLabel.setText("Invalid format in text area.");
            return;
        }

        String newStatus = lines[3].replace("Status: ", "").trim();
        sp.setStatus(newStatus);

        // Save to service_progress.dat
        progressList.add(sp);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROGRESS_FILE))) {
            oos.writeObject(progressList);
        } catch (IOException e) {
            infoLabel.setText("Failed to save progress.");
            return;
        }

        infoLabel.setText("Progress updated and saved.");
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}
