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

public class RequestsparepartsController
{
    @javafx.fxml.FXML
    private TableColumn<RequestSparePartModel,String> partnamecol;
    @javafx.fxml.FXML
    private TableColumn<RequestSparePartModel,Integer> qtycol;
    @javafx.fxml.FXML
    private TableColumn <RequestSparePartModel,String>reasoncol;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TextField quantityfield;
    @javafx.fxml.FXML
    private TableView<RequestSparePartModel> tableview;
    @javafx.fxml.FXML
    private TextArea textarea;

    private ObservableList<RequestSparePartModel> list = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        qtycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
       reasoncol.setCellValueFactory(new PropertyValueFactory<>("reason"));


        list.add(new RequestSparePartModel("Brake Pad", 4, "Wear & Tear"));
        list.add(new RequestSparePartModel("Engine Oil", 2, "Regular Service"));
        list.add(new RequestSparePartModel("Air Filter", 1, "Dirty Filter"));
        list.add(new RequestSparePartModel("Battery", 1, "Low Voltage"));
        list.add(new RequestSparePartModel("Spark Plug", 4, "Replacement"));


        tableview.setItems(list);


    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/technician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addrequestOnActionButton(ActionEvent actionEvent) {
        String part = partnamefield.getText();
        String qtyText = quantityfield.getText();
        String reason = textarea.getText();


        if (part.isEmpty() || qtyText.isEmpty() || reason.isEmpty()) {
            showAlert("Error","All fields are required!!!");
            return;

        }

        int qty;
        try {
            qty = Integer.parseInt(qtyText);
        } catch (NumberFormatException e) {
            showAlert("Error","Quantity must be a number !!");
            return;
        }

        RequestSparePartModel req = new RequestSparePartModel(part,qty,reason);
        list.add(req);



    }

    @javafx.fxml.FXML
    public void submittomanagerOnActionButton(ActionEvent actionEvent) {
        showAlert("Submitted","Request submitted to manager sucessfully!!");


    }

    private void showAlert(String title,String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}