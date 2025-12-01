package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckstockController
{
    @javafx.fxml.FXML
    private TableColumn locationcol;
    @javafx.fxml.FXML
    private TableColumn partidcol;
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TableColumn statuscol;
    @javafx.fxml.FXML
    private TableColumn quantitycol;
    @javafx.fxml.FXML
    private TextField searchfield;
    @javafx.fxml.FXML
    private TableView tableview;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}