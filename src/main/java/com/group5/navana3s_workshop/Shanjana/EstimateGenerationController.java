package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class EstimateGenerationController
{
    @javafx.fxml.FXML
    private TextField idField;
    @javafx.fxml.FXML
    private Label infoLabel;
    @javafx.fxml.FXML
    private TableColumn unitPC;
    @javafx.fxml.FXML
    private TableColumn hourC;
    @javafx.fxml.FXML
    private TableColumn laborC;
    @javafx.fxml.FXML
    private TableColumn partC;
    @javafx.fxml.FXML
    private TableView tableView;
    @javafx.fxml.FXML
    private Label estimateInfo;
    @javafx.fxml.FXML
    private TableColumn serviceC;
    @javafx.fxml.FXML
    private TableColumn totalC;
    @javafx.fxml.FXML
    private TableColumn quantityC;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void GenerateButton(ActionEvent actionEvent) {
    }
}