package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepairApprovalController {

    @FXML
    private TableView<AdditionalRepair> repairRequestTable;
    @FXML
    private TableColumn<AdditionalRepair, String> bookingIdCol;
    @FXML
    private TableColumn<AdditionalRepair, String> repairDescCol;
    @FXML
    private TableColumn<AdditionalRepair, Double> estimatedCostCol;
    @FXML
    private TableColumn<AdditionalRepair, LocalDate> dateCol;
    @FXML
    private Label infoLabel;

    private final String FILE_PATH = "additionalParts.dat";

    @FXML
    public void initialize() {
        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        repairDescCol.setCellValueFactory(new PropertyValueFactory<>("repairDescription"));
        estimatedCostCol.setCellValueFactory(new PropertyValueFactory<>("estimatedCost"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        repairRequestTable.getItems().addAll(loadOrCreateDummy());
    }

    private List<AdditionalRepair> loadOrCreateDummy() {
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return createDummyData();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<AdditionalRepair>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return createDummyData();
        }
    }

    private List<AdditionalRepair> createDummyData() {
        List<AdditionalRepair> list = new ArrayList<>();
        list.add(new AdditionalRepair("B001", "Front Brake Replacement", 5500.0, LocalDate.now()));
        list.add(new AdditionalRepair("B002", "Oil Filter + Engine Oil", 3200.0, LocalDate.now()));
        list.add(new AdditionalRepair("B003", "Suspension Tightening", 1500.0, LocalDate.now()));
        list.add(new AdditionalRepair("B004", "Battery Check & Charging", 800.0, LocalDate.now()));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @FXML
    public void Approve(ActionEvent actionEvent) {
        AdditionalRepair selected = repairRequestTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            infoLabel.setText("Select a repair request to approve.");
            return;
        }

        infoLabel.setText("Approved: " + selected.getRepairDescription());
    }

    @FXML
    public void Reject(ActionEvent actionEvent) {
        AdditionalRepair selected = repairRequestTable.getSelectionModel().getSelectedItem();

        if (selected == null) {
            infoLabel.setText("Select a repair request to reject.");
            return;
        }

        infoLabel.setText("Rejected: " + selected.getRepairDescription());
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(loader.load());
        Button btn = (Button) actionEvent.getSource();
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.setScene(scene);
    }
}
