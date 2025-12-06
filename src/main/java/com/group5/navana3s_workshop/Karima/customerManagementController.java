package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.customerManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class customerManagementController
{
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField numberField;
    @javafx.fxml.FXML
    private TableColumn<customerManagement,String> contactCol;
    @javafx.fxml.FXML
    private TableColumn<customerManagement,String> nameCol;
    @javafx.fxml.FXML
    private TextField interestField;
    @javafx.fxml.FXML
    private TableView<customerManagement> tableView;
    @javafx.fxml.FXML
    private TableColumn<customerManagement,String> interestCol;
    @javafx.fxml.FXML
    private TextField nameField;


    @javafx.fxml.FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        interestCol.setCellValueFactory(new PropertyValueFactory<>("interestModel"));
    }

    @javafx.fxml.FXML
    public void saveCustomerButton(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String contact = numberField.getText().trim();
        String interest = interestField.getText().trim();

        if (name.isEmpty() || contact.isEmpty() || interest.isEmpty()) {
            outputLabel.setText("Please fill all fields.");
            return;
        }

        if (!contact.matches("\\d{11}")) {
            outputLabel.setText("Enter a 11 digit valid contact number.");
            return;
        }


        customerManagement existing = null;
        for (customerManagement c : tableView.getItems()) {
            if (c.getContact().equals(contact)) {
                existing = c;
                break;
            }
        }


        if (existing == null) {
            customerManagement CustomerManagement = new customerManagement(name, contact, interest);
            tableView.getItems().add(CustomerManagement);
        } else {
            existing.setName(name);
            existing.setInterestModel(interest);
            tableView.refresh();
        }


        outputLabel.setText("Customer saved successfully.");

        nameField.clear();
        numberField.clear();
        interestField.clear();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("management.bin"))) {

            for (customerManagement s : tableView.getItems()) {
                out.writeObject(s);
            }

            outputLabel.setText("Customer saved!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        } catch (IOException ex) {
            outputLabel.setText("Saving failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }

    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void loadButton(ActionEvent actionEvent) {
        tableView.getItems().clear();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("management.bin"))) {

            while (true) {
                customerManagement m = (customerManagement) in.readObject();
                tableView.getItems().add(m);
            }

        } catch (EOFException ex) {
            outputLabel.setText("Sales loaded!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        } catch (Exception ex) {
            outputLabel.setText("Loading failed!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
}

