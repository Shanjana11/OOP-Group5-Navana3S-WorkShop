package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ServiceProgressController
{

    @javafx.fxml.FXML
    private TableColumn customerCol;
    @javafx.fxml.FXML
    private TableColumn progressCol;
    @javafx.fxml.FXML
    private TableView serviceProgressTable;
    @javafx.fxml.FXML
    private TableColumn serviceTypeCol;
    @javafx.fxml.FXML
    private TableColumn statusCol;
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private TableColumn jobCardCol;
    @javafx.fxml.FXML
    private TableColumn vehicleCol;
    @javafx.fxml.FXML
    private TextArea progressMessageArea;
    @javafx.fxml.FXML
    private TextField jobCard;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleUpdateProgressButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}