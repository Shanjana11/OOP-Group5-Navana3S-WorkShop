package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class customerManagementController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField numberField;
    @javafx.fxml.FXML
    private TableColumn<customerManagementController,Integer> contactCol;
    @javafx.fxml.FXML
    private TableColumn<customerManagementController,String> nameCol;
    @javafx.fxml.FXML
    private TextField interestField;
    @javafx.fxml.FXML
    private TableView<customerManagementController> tableView;
    @javafx.fxml.FXML
    private TableColumn<customerManagementController,String> interestCol;
    @javafx.fxml.FXML
    private TextField nameField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveCustomerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }
}