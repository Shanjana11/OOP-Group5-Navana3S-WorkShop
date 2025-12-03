package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackServiceController
{
    @javafx.fxml.FXML
    private ProgressBar progressBar;
    @javafx.fxml.FXML
    private Label progressStatus;
    @javafx.fxml.FXML
    private TextField bookID;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void trackButton(ActionEvent actionEvent) {
        String bookingId = bookID.getText();

        if (bookingId.isEmpty()) {
            progressStatus.setText("Enter booking ID!");
            return;
        }

        // Fetch status from database
        // sample data
        progressBar.setProgress(0.6);
        progressStatus.setText("Status: In Progress" + "\n" + "Estimated Completion: 2 hours" + "\n" + "Your vehicle is currently undergoing brake service and oil change.");
    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}