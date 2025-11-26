package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class WarrantyClaimController
{
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TextArea descriveArea;
    @javafx.fxml.FXML
    private ComboBox<String> claimCombo;
    @javafx.fxml.FXML
    private TextField invoiceId;

    @javafx.fxml.FXML
    public void initialize() {
        claimCombo.getItems().addAll("Engine Issue", "Break Issue", "AC/Cooling Issue", "Body/Paint Defect", "Other/Miscellaneous");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
    }
}