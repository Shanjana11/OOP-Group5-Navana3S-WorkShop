package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;

public class InventoryupdateController
{
    @javafx.fxml.FXML
    private TextField newquantityfield;
    @javafx.fxml.FXML
    private TableColumn <Part,Integer>partidcol;
    @javafx.fxml.FXML
    private TableColumn<Part,String> partnamecol;
    @javafx.fxml.FXML
    private TableColumn <Part,Integer> quantitycol;
    @javafx.fxml.FXML
    private TableView<Part> tableview;
    @javafx.fxml.FXML
    private TextField searchfield;

    private ObservableList<Part> partsList = FXCollections.observableArrayList();




    @javafx.fxml.FXML
    public void initialize() {
        partidcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantitycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        loadBinary();

        tableview.setItems(partsList);

        partsList.addAll(
                new Part(101, "Brake Pad", 50),
                new Part(102, "Engine Oil", 120),
                new Part(103, "Battery", 40)
        );


    }


    @javafx.fxml.FXML
    public void searchOnActionButton(ActionEvent actionEvent) {
        String search = searchfield.getText().toLowerCase().trim();

        if (search.isEmpty()) {
            tableview.setItems(partsList);
            return;
        }
        ObservableList<Part> filtered = FXCollections.observableArrayList();


        for (Part p : partsList) {
            if (p.getName().toLowerCase().contains(search)) {
                filtered.add(p);
            }
        }

        tableview.setItems(filtered);
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    private void showAlert(String title,String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void updateOnActionButton(ActionEvent actionEvent) {
        Part selected = tableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("No selection","Please select a part from the table.");
            return;
        }

        if (newquantityfield.getText().isEmpty()) {
            showAlert("Empty field","Please enter new quantity.");
            return;
        }
        try {
            int newQTy = Integer.parseInt(newquantityfield.getText());

            selected.setQuantity(newQTy);
            tableview.refresh();

            showAlert("Success","Quantity updated sucessfully!!");
            } catch (NumberFormatException e) {
              showAlert("Invalid Input","Quantity must be a number.");
        }
    }

    private void saveBinary() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("parts.bin"))) {
            oos.writeObject(new ArrayList<>(partsList));
        } catch (IOException e) {
            showAlert("Error", "Failed to save binary file.");
        }

    }

    private void loadBinary() {
        File file = new File("parts.bin");
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Part> data = (List<Part>) ois.readObject();
            partsList.setAll(data);
        } catch (Exception e) {
            showAlert("Error", "Failed to load binary file.");
        }

    }

}