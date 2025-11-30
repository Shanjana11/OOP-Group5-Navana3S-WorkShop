package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class customerConsultationController
{
    @javafx.fxml.FXML
    private ComboBox<String> budgetField;
    @javafx.fxml.FXML
    private ComboBox<String> modelField;
    @javafx.fxml.FXML
    private TableColumn<customerConsultationController,String> budgetCol;
    @javafx.fxml.FXML
    private TableView<customerConsultationController> tableView;
    @javafx.fxml.FXML
    private TableColumn<customerConsultationController,String> colorCol;
    @javafx.fxml.FXML
    private ComboBox<String> colorField;
    @javafx.fxml.FXML
    private TableColumn<customerConsultationController,String> modelCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void quotationButton(ActionEvent actionEvent) {
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