package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FeedbackComplaintController {
    @javafx.fxml.FXML
    private ComboBox<String> rateCombo;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TextField customerNF;
    @javafx.fxml.FXML
    private ComboBox<String> typeCombo;

    private static final String FeedbackFile = "feedbacks.bin";

    @javafx.fxml.FXML
    public void initialize() {
        rateCombo.getItems().addAll("★☆☆☆☆ - Very Poor","★★☆☆☆ - Poor","★★★☆☆ - Average","★★★★☆ - Good","★★★★★ - Excellent");
        typeCombo.getItems().addAll("Regular Service", "Oil Change", "Brake Service", "Engine Repair", "AC Service", "Tire Change");

        infoLabel.setText("");  //clear infolabel initially
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
        String customerName = customerNF.getText().trim();
        String serviceType = typeCombo.getValue();
        String rating = rateCombo.getValue();

        // Validation
        if (customerName.isEmpty() || serviceType == null || rating == null) {
            alert("Please fill all required fields!");
            infoLabel.setText("");
            return;
        }

        // Generate feedback ID
        String feedbackId = "FB" + String.format("%05d", (int)(Math.random() * 100000));

        // Create Feedback object
        Feedback feedback = new Feedback(feedbackId, customerName, serviceType, rating, LocalDateTime.now());

        // Save to file
        if (saveFeedbackToFile(feedback)) {
            // Show thank you message on label
            infoLabel.setText("Thank you " + customerName + " for your feedback!\nReference ID: " + feedbackId);
            infoLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

            // Show alert message
            alert("Thank you! Your feedback has been submitted successfully.\nReference ID: " + feedbackId);

            // Clear form
            clearForm();
        } else {
            infoLabel.setText("Failed to submit feedback. Please try again!");
            infoLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            alert("Error submitting feedback. Please try again!");
        }
    }

    private boolean saveFeedbackToFile(Feedback feedback) {
        List<Feedback> feedbacks = loadExistingFeedbacks();
        feedbacks.add(feedback);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FeedbackFile))) {
            oos.writeObject(feedbacks);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Feedback> loadExistingFeedbacks() {
        File file = new File(FeedbackFile);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FeedbackFile))) {
            return (List<Feedback>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void clearForm() {
        customerNF.clear();
        typeCombo.setValue(null);
        rateCombo.setValue(null);
    }

    private void alert(String message) {
        Alert msgBox = new Alert(Alert.AlertType.INFORMATION);
        msgBox.setContentText(message);
        msgBox.show();
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}