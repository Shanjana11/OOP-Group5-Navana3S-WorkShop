package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class StartserviceController
{
    @javafx.fxml.FXML
    private TextField modelfield;
    @javafx.fxml.FXML
    private TextField jobidfield;
    @javafx.fxml.FXML
    private TextField vechiclenofield;
    @javafx.fxml.FXML
    private CheckBox brakeCheck;
    @javafx.fxml.FXML
    private CheckBox othersinspectionCheck;
    @javafx.fxml.FXML
    private CheckBox tyreCheck;
    @javafx.fxml.FXML
    private CheckBox electricalCheck;
    @javafx.fxml.FXML
    private CheckBox oilCheck;
    @javafx.fxml.FXML
    private CheckBox enginecheck;
    @javafx.fxml.FXML
    private TextArea textarea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void startserviceOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);

    }

    @javafx.fxml.FXML
    public void saveProgressOnAction(ActionEvent actionEvent) {
    }
}