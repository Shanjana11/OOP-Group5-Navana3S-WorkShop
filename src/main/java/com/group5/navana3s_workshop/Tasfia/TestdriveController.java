package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TestdriveController
{
    @javafx.fxml.FXML
    private ComboBox <String>resultCombobox;
    @javafx.fxml.FXML
    private TextField brakefield;
    @javafx.fxml.FXML
    private TextField speedfield;
    @javafx.fxml.FXML
    private TextArea textarea;
    @javafx.fxml.FXML
    private TextField noisefield;

    @javafx.fxml.FXML
    public void initialize() {
        resultCombobox.getItems().addAll("Pass","Fail","Pending");
    }

    @javafx.fxml.FXML
    public void savereportOnActionButton(ActionEvent actionEvent) {
        String speed = speedfield.getText();
        String brake = brakefield.getText();
        String noise = noisefield.getText();
        String overall = textarea.getText();
        String result = resultCombobox.getValue();

        System.out.println("Speed Performance: " + speed);
        System.out.println("Brake Test: " + brake);
        System.out.println("Engine Noise: " + noise);
        System.out.println("Overall Performance: " + overall);
        System.out.println("Result: " + result);

        speedfield.clear();
        brakefield.clear();
        noisefield.clear();
        textarea.clear();
        resultCombobox.getSelectionModel().clearSelection();


    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);

    }
}