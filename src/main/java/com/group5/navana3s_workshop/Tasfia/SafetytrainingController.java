package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SafetytrainingController
{
    @javafx.fxml.FXML
    private DatePicker trainingdate;
    @javafx.fxml.FXML
    private ComboBox completioncombobox;
    @javafx.fxml.FXML
    private TableColumn notescol;
    @javafx.fxml.FXML
    private TableColumn datecol;
    @javafx.fxml.FXML
    private TableColumn statuscol;
    @javafx.fxml.FXML
    private AnchorPane namefield;
    @javafx.fxml.FXML
    private TableColumn modulecol;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private ComboBox combobox;
    @javafx.fxml.FXML
    private TextArea textarea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addtrainigOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
    }
}