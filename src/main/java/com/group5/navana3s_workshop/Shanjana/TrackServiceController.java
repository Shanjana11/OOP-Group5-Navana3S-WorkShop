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

public class TrackServiceController {

    @FXML
    private Label progressStatus;
    @FXML
    private TextField bookID;

    private final String FILE_PATH = "service_progress.dat";
    private List<ServiceStatus> serviceList;

    @FXML
    public void initialize() {
        // Load data
        serviceList = loadOrCreateDummyData();
    }

    @FXML
    public void trackButton(ActionEvent actionEvent) {
        String enteredId = bookID.getText().trim();

        if (enteredId.isEmpty()) {
            showAllProgress();
            return;
        }

        boolean found = false;
        for (ServiceStatus s : serviceList) {
            if (s.getBookingId().equalsIgnoreCase(enteredId)) {
                progressStatus.setText("Current Status: " + s.getStatus());
                found = true;
                break;
            }
        }

        if (!found) {
            progressStatus.setText("No matching booking ID found.");
        }
    }

    private void showAllProgress() {
        StringBuilder sb = new StringBuilder("Service Progress:\n");
        for (ServiceStatus s : serviceList) {
            sb.append(s.getBookingId()).append(" → ").append(s.getStatus()).append("\n");
        }
        progressStatus.setText(sb.toString());
    }

    private List<ServiceStatus> loadOrCreateDummyData() {
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return createDummyFile();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<ServiceStatus>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return createDummyFile();
        }
    }

    private List<ServiceStatus> createDummyFile() {
        List<ServiceStatus> dummy = new ArrayList<>();
        dummy.add(new ServiceStatus("BK101", "Received"));
        dummy.add(new ServiceStatus("BK102", "Diagnosis Stage"));
        dummy.add(new ServiceStatus("BK103", "Repair Ongoing"));
        dummy.add(new ServiceStatus("BK104", "Quality Check"));
        dummy.add(new ServiceStatus("BK105", "Ready for Delivery"));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(dummy);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dummy;
    }

    @FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
