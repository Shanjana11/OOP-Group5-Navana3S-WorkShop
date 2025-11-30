package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ServiceRequestController
{
    @javafx.fxml.FXML
    private TextField vehicleField;
    @javafx.fxml.FXML
    private ComboBox<String> serviceCombo;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private DatePicker datePick;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private ComboBox<String> typeCombo;
    @javafx.fxml.FXML
    private TableColumn typeC;
    @javafx.fxml.FXML
    private TableColumn cardC;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private TableColumn dateC;
    @javafx.fxml.FXML
    private TableColumn statusC;

    @javafx.fxml.FXML
    public void initialize() {
        typeCombo.getItems().addAll("Online","Walk-in");
    }

    @javafx.fxml.FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void Submit(ActionEvent actionEvent) {
    }
}