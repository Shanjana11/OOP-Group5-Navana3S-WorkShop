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

    private final String FILE_PATH = "D:\\Study\\7th semester\\OOP Projects\\Navana3S_WorkShop\\service_progress.dat";

    @FXML
    public void trackButton(ActionEvent actionEvent) {

        // Load or create dummy data
        List<ServiceStatus> list = loadOrCreateDummyData();

        String enteredId = bookID.getText().trim();

        // If no ID entered, show all dummy data
        if (enteredId.isEmpty()) {
            StringBuilder sb = new StringBuilder("Service Progress (Dummy Data):\n");
            for (ServiceStatus s : list) {
                sb.append(s.getBookingId()).append(" → ").append(s.getStatus()).append("\n");
            }
            progressStatus.setText(sb.toString());
            return;
        }

        // Search for specific booking ID
        for (ServiceStatus s : list) {
            if (s.getBookingId().equalsIgnoreCase(enteredId)) {
                progressStatus.setText("Current Status: " + s.getStatus());
                return;
            }
        }

        // If booking ID not found
        progressStatus.setText("No matching booking ID found.");
    }

    private List<ServiceStatus> loadOrCreateDummyData() {

        File file = new File(FILE_PATH);

        // If file does not exist or is empty, create dummy data
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
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}
