package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class VehicleDeliveryController
{
    @javafx.fxml.FXML
    private TableColumn vehicleCol;
    @javafx.fxml.FXML
    private TableColumn invoiceCol;
    @javafx.fxml.FXML
    private TableColumn customerCol;
    @javafx.fxml.FXML
    private TextField signatureField;
    @javafx.fxml.FXML
    private TableView readyForDeliveryTable;
    @javafx.fxml.FXML
    private CheckBox invoicePaidCheckBox;
    @javafx.fxml.FXML
    private CheckBox vehicleCleanedCheckBox;
    @javafx.fxml.FXML
    private TableColumn serviceTypeCol;
    @javafx.fxml.FXML
    private TableColumn jobCardCol;
    @javafx.fxml.FXML
    private TableColumn paymentCol;
    @javafx.fxml.FXML
    private CheckBox documentsReadyCheckBox;
    @javafx.fxml.FXML
    private CheckBox customerNotifiedCheckBox;
    @javafx.fxml.FXML
    private CheckBox keysAvailableCheckBox;
    @javafx.fxml.FXML
    private CheckBox finalInspectionCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void handleCompleteDeliveryButton(ActionEvent actionEvent) {
    }
}