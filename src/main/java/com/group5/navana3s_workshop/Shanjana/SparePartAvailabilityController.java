package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SparePartAvailabilityController
{
    @javafx.fxml.FXML
    private TextField partName;
    @javafx.fxml.FXML
    private Label partInfo;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkPart(ActionEvent actionEvent) {
        String searchText = partName.getText();

        if (searchText.trim().isEmpty()) {
            partInfo.setText("Please enter part name or ID");
            return;
        }

        // Search in database
        // Sample data
        partInfo.setText("Part Name: Brake Pad" + "\n"+"Part ID: BP-2024" + "\n" + "Availability: In Stock"+ "\n"+"Price: BDT 2500"+"\n"+ "Alternative Parts: BP-2023, BP-2025");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}