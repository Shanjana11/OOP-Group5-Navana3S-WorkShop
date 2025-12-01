package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ComplaintManagementController
{
    @javafx.fxml.FXML
    private TableView complaintsTable;
    @javafx.fxml.FXML
    private TableColumn bookingIdCol;
    @javafx.fxml.FXML
    private TableColumn typeCol;
    @javafx.fxml.FXML
    private TableColumn customerCol;
    @javafx.fxml.FXML
    private TableColumn complaintIdCol;
    @javafx.fxml.FXML
    private TableColumn dateCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private TableColumn priorityCol;
    @javafx.fxml.FXML
    private TextArea resolutionNotesArea;
    @javafx.fxml.FXML
    private Label complaintDetailsLabel;
    @javafx.fxml.FXML
    private ComboBox actionComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void handleEscalateButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleResolveButton(ActionEvent actionEvent) {
    }
}