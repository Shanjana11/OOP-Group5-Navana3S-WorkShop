package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Shanjana.BookService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FeedbackComplaintController {

    private final String FEEDBACK_FILE = "feedback.dat";
    private final String BOOKING_FILE = "bookings.dat";

    @FXML private ComboBox<String> bookingIdCombo;
    @FXML private ComboBox<String> rateCombo;
    @FXML private ComboBox<String> typeCombo;
    @FXML private Label infoLabel;

    @FXML
    public void initialize() {
        rateCombo.getItems().addAll("Excellent", "Average", "Poor");
        typeCombo.getItems().addAll("Regular Service", "Oil Change", "Brake Service", "Engine Repair", "AC Service", "Tire Change");

        // Load booking IDs from bookings.dat
        List<BookService> bookings = loadBookings();

        for (BookService b : bookings) {
            bookingIdCombo.getItems().add(b.getBookingId());
        }
    }

    @FXML
    public void submitButton(ActionEvent actionEvent) {

        String bookingId = bookingIdCombo.getValue();
        String rating = rateCombo.getValue();
        String serviceType = typeCombo.getValue();

        if (bookingId == null || rating == null || serviceType == null) {
            infoLabel.setText("Please fill all fields.");
            return;
        }

        Feedback record = new Feedback(bookingId, serviceType, rating, LocalDateTime.now());

        saveFeedback(record);

        infoLabel.setText("Your feedback has been submitted successfully.");
    }

    private void saveFeedback(Feedback record) {
        List<Feedback> list = loadFeedback();

        list.add(record);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FEEDBACK_FILE))) {
            out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Feedback> loadFeedback() {
        File file = new File(FEEDBACK_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Feedback>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private List<BookService> loadBookings() {
        File file = new File(BOOKING_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<BookService>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
