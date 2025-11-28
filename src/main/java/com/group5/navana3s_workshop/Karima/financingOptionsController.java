package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class financingOptionsController
{
    @javafx.fxml.FXML
    private TextField incomeField;
    @javafx.fxml.FXML
    private TableView<financingOptionsController> tableField;
    @javafx.fxml.FXML
    private TableColumn<financingOptionsController,String> emiCol;
    @javafx.fxml.FXML
    private TableColumn<financingOptionsController,String> planCol;
    @javafx.fxml.FXML
    private TableColumn<financingOptionsController,String> paymentCol;
    @javafx.fxml.FXML
    private TextField vehicleModelField;
    @javafx.fxml.FXML
    private Label outputLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void searchPlanButton(ActionEvent actionEvent) {
    }
}