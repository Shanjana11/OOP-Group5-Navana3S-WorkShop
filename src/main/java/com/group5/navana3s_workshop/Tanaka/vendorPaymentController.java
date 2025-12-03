package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class vendorPaymentController
{
    @javafx.fxml.FXML
    private TableColumn DueDateColumn;
    @javafx.fxml.FXML
    private TableColumn paymentStatusColumn;
    @javafx.fxml.FXML
    private TableView vendorPaymentTableView;
    @javafx.fxml.FXML
    private TableColumn vendorNameColumn;
    @javafx.fxml.FXML
    private Label pendingTotalLabel;
    @javafx.fxml.FXML
    private TableColumn DueAmountColumn;
    @javafx.fxml.FXML
    private Label paidTotalLabel;

    @javafx.fxml.FXML
    public void initialize() {
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
    public void markPaidOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void processPaymentOnActionButton(ActionEvent actionEvent) {
    }
}