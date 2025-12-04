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
import java.util.ArrayList;
import java.util.List;

public class ServiceHistoryController {

    @FXML
    private TableColumn<BookService, String> bookingIdCol;

    @FXML
    private TableColumn<BookService, String> dateCol;

    @FXML
    private TableColumn<BookService, String> serviceTypeCol;

    @FXML
    private TableView<BookService> serviceHistoryTable;

    private final String FILE_PATH = "bookings.dat";

    @FXML
    public void initialize() {

        bookingIdCol.setCellValueFactory(new PropertyValueFactory<>("confirmationId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        serviceTypeCol.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
    }

    // Load service history when clicking Load button
    @FXML
    public void LoadHistory(ActionEvent actionEvent) {

        List<BookService> bookingList = loadBookingData();

        if (bookingList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Data");
            alert.setHeaderText(null);
            alert.setContentText("No previous service history found.");
            alert.show();
            serviceHistoryTable.getItems().clear();
            return;
        }

        serviceHistoryTable.getItems().setAll(bookingList);
    }

    // Read bookings.dat
    private List<BookService> loadBookingData() {

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<BookService>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}
