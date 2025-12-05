package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class MonthlystockreportController
{
    @javafx.fxml.FXML
    private TableColumn<MonthlyStockReportModel,Integer> closingstatuscol;
    @javafx.fxml.FXML
    private TableColumn <MonthlyStockReportModel,String>partidcol;
    @javafx.fxml.FXML
    private TableColumn<MonthlyStockReportModel,String> partnamecol;
    @javafx.fxml.FXML
    private TableColumn<MonthlyStockReportModel,Integer> usedcol;
    @javafx.fxml.FXML
    private TableColumn <MonthlyStockReportModel,Integer>receivedcol;
    @javafx.fxml.FXML
    private TableView<MonthlyStockReportModel> tableview;
    @javafx.fxml.FXML
    private TableColumn <MonthlyStockReportModel,Integer>openingstockcol;
    @javafx.fxml.FXML
    private ComboBox<String> combobox;


    private ObservableList<MonthlyStockReportModel> list = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        partidcol.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        openingstockcol.setCellValueFactory(new PropertyValueFactory<>("openingStock"));
        receivedcol.setCellValueFactory(new PropertyValueFactory<>("received"));
        usedcol.setCellValueFactory(new PropertyValueFactory<>("used"));
        closingstatuscol.setCellValueFactory(new PropertyValueFactory<>("closingStatus"));


        tableview.setItems(list);

        combobox.getItems().addAll("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    }

    @javafx.fxml.FXML
    public void generatereportOnActionButton(ActionEvent actionEvent) {
        String selectedMonth = combobox.getValue();
        if (selectedMonth == null || selectedMonth.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No month selected Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a month to generate the report.");
            alert.showAndWait();
            return;
        }

        list.clear();

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