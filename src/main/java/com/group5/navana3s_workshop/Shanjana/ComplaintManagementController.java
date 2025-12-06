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

public class ComplaintManagementController {

    @FXML
    private Label infoLabel;

    private final String BOOKING_FILE = "bookings.dat";
    private final String COMPLAINT_FILE = "complaints.dat";

    private List<BookService> bookings = new ArrayList<>();
    private List<Complaint> complaints = new ArrayList<>();
    @FXML
    private TextArea complaintTextArea;
    @FXML
    private ComboBox bookingIdCombo;

    @FXML
    public void initialize() {
        loadBookings();
        loadBookingIds();
        loadExistingComplaints();
    }

    private void loadBookings() {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            bookings = (List<BookService>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading bookings: " + e.getMessage());
        }
    }

    private void loadBookingIds() {
        bookingIdCombo.getItems().clear();
        for (BookService b : bookings) {
            if (b.getBookingId() != null) {
                bookingIdCombo.getItems().add(b.getBookingId());
            }
        }
    }

    private void loadExistingComplaints() {
        File file = new File(COMPLAINT_FILE);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            complaints = (List<Complaint>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading complaints: " + e.getMessage());
        }
    }

    private void saveComplaintsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMPLAINT_FILE))) {
            oos.writeObject(complaints);
        } catch (IOException e) {
            infoLabel.setText("Error saving complaint.");
        }
    }

    @FXML
    public void handleEscalateButton(ActionEvent actionEvent) {
        String selectedBooking = bookingIdCombo.getValue().toString();
        String complaintText = complaintTextArea.getText().trim();

        if (selectedBooking == null) {
            infoLabel.setText("Select a booking ID first.");
            return;
        }

        if (complaintText.isEmpty()) {
            infoLabel.setText("Enter the complaint details.");
            return;
        }

        Complaint newComplaint = new Complaint(selectedBooking, complaintText);
        complaints.add(newComplaint);
        saveComplaintsToFile();

        infoLabel.setText("The complaint is escalated to workshop manager.");
        complaintTextArea.clear();
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backBtn = (Button) actionEvent.getSource();
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(scene);
    }
}
