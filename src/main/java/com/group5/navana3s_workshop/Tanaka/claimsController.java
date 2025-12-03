package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class claimsController
{
    @javafx.fxml.FXML
    private TableColumn dateTextField;
    @javafx.fxml.FXML
    private TextArea issueDetailsTextArea;
    @javafx.fxml.FXML
    private TableView insuranceClaimsTableView;
    @javafx.fxml.FXML
    private TableColumn ClaimIDColumn;
    @javafx.fxml.FXML
    private TableColumn customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn approvalStatusTextField;
    @javafx.fxml.FXML
    private TextField invoiceNoTextField;
    @javafx.fxml.FXML
    private TableColumn invoiceNoColumn;
    @javafx.fxml.FXML
    private ChoiceBox claimTypeChoiceBox;
    @javafx.fxml.FXML
    private TableColumn claimTypeTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void newClaimOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/accountsOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Test Drive");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void submitOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateStatusOnActionButton(ActionEvent actionEvent) {
    }
}