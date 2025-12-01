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

public class AssignedjobController
{
    @javafx.fxml.FXML
    private TextField textSearch;
    @javafx.fxml.FXML
    private TableColumn statuscol;
    @javafx.fxml.FXML
    private TableColumn jobIDcol;
    @javafx.fxml.FXML
    private TableColumn assigneddatecol;
    @javafx.fxml.FXML
    private TableView jobTable;
    @javafx.fxml.FXML
    private TableColumn vechiclenocol;
    @javafx.fxml.FXML
    private TableColumn problemcol;
    @javafx.fxml.FXML
    private TableColumn modelcol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void startServiceOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void viewdetailsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
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