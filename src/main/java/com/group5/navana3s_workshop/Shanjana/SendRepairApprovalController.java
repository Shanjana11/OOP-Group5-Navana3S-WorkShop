package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class SendRepairApprovalController {

    @FXML private TableView<TechRequest> tableView;
    @FXML private TableColumn<TechRequest, String> bookingIdCol;
    @FXML private TableColumn<TechRequest, String> repairDescCol;
    @FXML private TableColumn<TechRequest, Double> estimatedCostCol;
    @FXML private TableColumn<TechRequest, LocalDate> dateCol;

    private final String TECHREQ_FILE = "techReq.dat";
    private final String ADDITIONAL_FILE = "additionalParts.dat";

    private List<TechRequest> techRequests = new ArrayList<>();
    @FXML
    private Label infoLabel;

    @FXML
    public void initialize() {
        // Setup columns
        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        repairDescCol.setCellValueFactory(new PropertyValueFactory<>("repairDescription"));
        estimatedCostCol.setCellValueFactory(new PropertyValueFactory<>("estimatedCost"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Load data
        loadTechRequests();
        tableView.setItems(FXCollections.observableArrayList(techRequests));
    }

    private void loadTechRequests() {
        File file = new File(TECHREQ_FILE);
        if (!file.exists() || file.length() == 0) {
            // create dummy data
            techRequests = new ArrayList<>();
            techRequests.add(new TechRequest("BK101", "Engine Repair", 4500, LocalDate.now()));
            techRequests.add(new TechRequest("BK102", "Brake Service", 1200, LocalDate.now()));
            techRequests.add(new TechRequest("BK103", "AC Service", 1800, LocalDate.now()));
            saveTechRequests(); // save dummy data
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                techRequests = (List<TechRequest>) ois.readObject();
            } catch (Exception e) {
                infoLabel.setText("Error loading tech requests.");
                e.printStackTrace();
            }
        }
    }

    private void saveTechRequests() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TECHREQ_FILE))) {
            oos.writeObject(techRequests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Send(ActionEvent actionEvent) {
        TechRequest selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            infoLabel.setText("Select a request to send.");
            return;
        }

        // Convert to AdditionalRepair
        AdditionalRepair additional = new AdditionalRepair(
                selected.getBookingId(),
                selected.getRepairDescription(),
                selected.getEstimatedCost(),
                selected.getDate()
        );

        // Save to additionalParts.dat
        List<AdditionalRepair> list;
        File file = new File(ADDITIONAL_FILE);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                list = (List<AdditionalRepair>) ois.readObject();
            } catch (Exception e) {
                list = new ArrayList<>();
            }
        } else {
            list = new ArrayList<>();
        }

        list.add(additional);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
            infoLabel.setText("Request sent to additional parts.");
        } catch (IOException e) {
            infoLabel.setText("Error saving additional repair.");
            e.printStackTrace();
        }
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
