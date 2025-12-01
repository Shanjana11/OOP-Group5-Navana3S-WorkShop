package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RepairApprovalController
{
    @javafx.fxml.FXML
    private ComboBox<String> approveCombo;
    @javafx.fxml.FXML
    private Label approveInfo;
    @javafx.fxml.FXML
    private Label repairDetails;

    @javafx.fxml.FXML
    public void initialize() {
        approveCombo.getItems().addAll("Yes", "No");
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