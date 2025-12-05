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

public class ReorderlowstockitemController
{
    @javafx.fxml.FXML
    private TableColumn partidcol;
    @javafx.fxml.FXML
    private TableColumn suggestedsuppliercol;
    @javafx.fxml.FXML
    private TableColumn partnamecol;
    @javafx.fxml.FXML
    private TableColumn currentqtycol;
    @javafx.fxml.FXML
    private TableView tableview;
    @javafx.fxml.FXML
    private TableColumn reorderlevelcol;
    @javafx.fxml.FXML
    private ComboBox<String> combobox;
    @javafx.fxml.FXML
    private TableColumn selectcol;
    @javafx.fxml.FXML
    private TextField thresholdfield;
    @javafx.fxml.FXML
    private TextField generatereorderfiled;
    @javafx.fxml.FXML
    private TextField nameidfield;

    private ObservableList<ReorderLowStockModel> dataList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        combobox.getItems().addAll("All Supplier","IFAD Auto","Bashundhara PArts","Rahim Auto");


        partidcol.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        currentqtycol.setCellValueFactory(new PropertyValueFactory<>("currentquantity"));
        reorderlevelcol.setCellValueFactory(new PropertyValueFactory<>("reorderlevel"));
        suggestedsuppliercol.setCellValueFactory(new PropertyValueFactory<>("suggestedsupplier"));

        tableview.setItems(dataList);
    }

    @javafx.fxml.FXML
    public void exportlistOnActionButton(ActionEvent actionEvent) {
        System.out.println("Exporting to CSV or File...");
    }

    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        System.out.println("Searching...");

        String threshold = thresholdfield.getText();
        String supplier = combobox.getValue();
        String key = nameidfield.getText();

        System.out.println("Threshold: " + threshold);
        System.out.println("Supplier: " + supplier);
        System.out.println("Search Key: " + key);
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
    public void createpurchaseorderOnActionButton(ActionEvent actionEvent) {
        System.out.println("Selected Items:");


    }

    @javafx.fxml.FXML
    public void selectallOnActionButton(ActionEvent actionEvent) {
        for (ReorderLowStockModel item : dataList) {
            item.setSelected(true);
        }
        tableview.refresh();
    }

    @javafx.fxml.FXML
    public void deselectallOnActionButton(ActionEvent actionEvent) {
        for (ReorderLowStockModel item : dataList) {
            item.setSelected(false);
        }
        tableview.refresh();
    }
}