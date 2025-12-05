package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class CheckstockController
{
    @javafx.fxml.FXML
    private TableColumn<StockModel,String> locationcol;
    @javafx.fxml.FXML
    private TableColumn<StockModel,String> partidcol;
    @javafx.fxml.FXML
    private TableColumn<StockModel,String> partnamecol;
    @javafx.fxml.FXML
    private TableColumn<StockModel,String> statuscol;
    @javafx.fxml.FXML
    private TableColumn<StockModel,Integer> quantitycol;
    @javafx.fxml.FXML
    private TextField searchfield;
    @javafx.fxml.FXML
    private TableView<StockModel> tableview;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TextField partidfield;
    @javafx.fxml.FXML
    private TextField quantityfield;
    @javafx.fxml.FXML
    private TextField locationfield;


    List<StockModel> stockList = new ArrayList<>();



    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Available","Low Stock","Out Of Stock");


        partidcol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("partId"));
        partnamecol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("partName"));
        quantitycol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
        locationcol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("location"));
        statuscol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("status"));


    }

    @javafx.fxml.FXML
    public void refreshOnActionButtons(ActionEvent actionEvent) {
        tableview.refresh();
        searchfield.clear();
        partidfield.clear();
        partnamefield.clear();
        quantityfield.clear();
        locationfield.clear();
        statusCB.setValue(null);
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        String keyword = searchfield.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Search Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a Part ID or Part Name to search!");
            alert.show();
            return;
        }

        List<StockModel> stockList = new ArrayList<>();

        if (stockList.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("No results");
            alert.setHeaderText(null);
            alert.setContentText("No matching stock found!!");
            alert.show();
        }





    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addButtonOnActionButton(ActionEvent actionEvent) {
        String id = partidfield.getText();
        String name = partnamefield.getText();
        int qty = Integer.parseInt(quantityfield.getText());
        String location = locationfield.getText();
        String status = statusCB.getValue();

        StockModel sm = new StockModel(id, name, qty, location, status);
        stockList.add(sm);

        tableview.getItems().setAll(stockList);

        partidfield.clear();
        partnamefield.clear();
        quantityfield.clear();
        locationfield.clear();
        statusCB.setValue(null);
        if (partidfield.getText().isBlank()
                || partnamefield.getText().isBlank()
                || quantityfield.getText().isBlank()
                || locationfield.getText().isBlank()
                || statusCB.getValue() == null) {

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Validation Error");
            alert.setContentText("Please fill up all fields before adding!!");
            alert.show();
            return;
        }

        StockModel stockModel = new StockModel(id, name, qty, location, status);

        stockList.add(sm);


        partidfield.clear();
        partnamefield.clear();
        quantityfield.clear();
        locationfield.clear();
        statusCB.setValue(null);




    }
}