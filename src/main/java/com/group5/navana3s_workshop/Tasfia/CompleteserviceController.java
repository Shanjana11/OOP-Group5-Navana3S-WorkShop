package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CompleteserviceController
{
    @javafx.fxml.FXML
    private TextArea remarksarea;
    @javafx.fxml.FXML
    private TextField vechiclenumberfield;
    @javafx.fxml.FXML
    private TextField jobidfield;
    @javafx.fxml.FXML
    private ComboBox <String>combobox;

    @javafx.fxml.FXML
    public void initialize() {
        combobox.getItems().addAll("Pending","In Progress","Completed","Cancelled");
    }

    @javafx.fxml.FXML
    public void updateserviceOnActionButton(ActionEvent actionEvent) {
        String jobId = jobidfield.getText();
        String vehicleNumber = vechiclenumberfield.getText();
        String remarks = remarksarea.getText();
        String status = combobox.getValue();


        if(jobId.isEmpty() || vehicleNumber.isEmpty() || remarks.isEmpty() || status == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields and select a status.");
            alert.showAndWait();
            return;
        }

        System.out.println("=== Service Update ===");
        System.out.println("Job ID: " + jobId);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Remarks: " + remarks);
        System.out.println("Status: " + status);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Service Updated");
        alert.setHeaderText(null);
        alert.setContentText("Service updated successfully!");
        alert.showAndWait();

        jobidfield.clear();
        vechiclenumberfield.clear();
        remarksarea.clear();
        combobox.getSelectionModel().clearSelection();





    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/technician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}