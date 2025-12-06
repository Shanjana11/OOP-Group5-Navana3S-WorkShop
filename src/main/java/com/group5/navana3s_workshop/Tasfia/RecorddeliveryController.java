package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecorddeliveryController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<Delivery,String> deliverydatecol;
    @javafx.fxml.FXML
    private TableColumn<Delivery,String> partnamecol;
    @javafx.fxml.FXML
    private TextField namefield;
    @javafx.fxml.FXML
    private TableColumn <Delivery,Integer>quantitycol;
    @javafx.fxml.FXML
    private TextField quantityfield;
    @javafx.fxml.FXML
    private TableView<Delivery> tableview;


    private final String FILE_PATH = "delivery_records.bin";


    private ObservableList<Delivery> deliveryList = FXCollections.observableArrayList();




    @javafx.fxml.FXML
    public void initialize() {
        partnamecol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("partName"));
        quantitycol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("quantity"));
        deliverydatecol.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("deliveryDate"));


        loadDeliveryRecords();






        tableview.setItems(deliveryList);


    }

    @javafx.fxml.FXML
    public void adddeliveryOnActionButton(ActionEvent actionEvent) {
        String partName = namefield.getText();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityfield.getText());
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Enter a alid number for quantity.").showAndWait();
            return;
        }
        String deliveryDate = (date.getValue() != null) ? date.getValue().toString() : "";

        if (partName.isEmpty() || deliveryDate.isEmpty()) {
            new Alert(Alert.AlertType.WARNING,"Please fill all fields.").showAndWait();
            return;
        }

        Delivery newDelivery = new Delivery(partName, quantity, deliveryDate);
        deliveryList.add(newDelivery);


        namefield.clear();
        quantityfield.clear();
        date.setValue(null);



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
    public void saveOnActionButton(ActionEvent actionEvent) {
      savedDeliveryRecords();

        }


        private void savedDeliveryRecords() {
            try (ObjectOutputStream oos =
                         new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

                oos.writeObject(new ArrayList<>(deliveryList));

                new Alert(Alert.AlertType.INFORMATION,
                        "Delivery records saved successfully").showAndWait();

            } catch (IOException e) {
                new Alert(Alert.AlertType.ERROR,
                        "Error saving file: " + e.getMessage()).showAndWait();
            }

        }

    private void loadDeliveryRecords() {
        File file = new File(FILE_PATH);

        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            Object obj = ois.readObject();

            if (obj instanceof ArrayList<?>) {

                ArrayList<?> list = (ArrayList<?>) obj;

                deliveryList.clear();

                for (Object o : list) {
                    if (o instanceof Delivery) {
                        deliveryList.add((Delivery) o);
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,
                    "Error loading saved records: " + e.getMessage()).showAndWait();
        }
    }





}


