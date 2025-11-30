package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ApproverequestController
{
    @javafx.fxml.FXML
    private TableColumn techniciancol;
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TableColumn qtycol;
    @javafx.fxml.FXML
    private TableColumn reasoncol;
    @javafx.fxml.FXML
    private TableColumn statuscol;
    @javafx.fxml.FXML
    private TableView tableview;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/Approverequest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);


    }

    @javafx.fxml.FXML
    public void rejectOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void approveOnActionButton(ActionEvent actionEvent) {
    }
}