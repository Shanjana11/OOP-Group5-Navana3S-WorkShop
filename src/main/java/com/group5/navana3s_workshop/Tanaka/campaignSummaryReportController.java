package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class campaignSummaryReportController
{
    @javafx.fxml.FXML
    private TableColumn customerCountColumn;
    @javafx.fxml.FXML
    private ComboBox capaignListComboBox;
    @javafx.fxml.FXML
    private TextField selectCampaignTextField;
    @javafx.fxml.FXML
    private TableColumn clicksColumn;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn reachColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableView campaignSummaryTableView;
    @javafx.fxml.FXML
    private TableColumn conversionsColumn;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn campaignNameColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Test Drive");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void exportOnActionButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void generateReportOnActionButton(ActionEvent actionEvent) {
    }
}