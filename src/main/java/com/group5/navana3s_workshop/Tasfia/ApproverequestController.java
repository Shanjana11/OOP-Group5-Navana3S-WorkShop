package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApproverequestController
{
    @javafx.fxml.FXML
    private TableColumn<PartRequest,String> techniciancol;
    @javafx.fxml.FXML
    private TableColumn <PartRequest,String>partnamecol;
    @javafx.fxml.FXML
    private TableColumn<PartRequest,Integer> qtycol;
    @javafx.fxml.FXML
    private TableColumn<PartRequest,String> reasoncol;
    @javafx.fxml.FXML
    private TableColumn<PartRequest,String> statuscol;
    @javafx.fxml.FXML
    private TableView <PartRequest>tableview;
    @javafx.fxml.FXML
    private ComboBox<String> selectstatusCombobox;

    private final String BINARY_FILE = "part_requests.dat";


    List<PartRequest> requestList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        selectstatusCombobox.getItems().addAll("Approved","Rejected","Pending");

        techniciancol.setCellValueFactory(new PropertyValueFactory<>("technicianName"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        qtycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        reasoncol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));




        requestList.add(new PartRequest("REQ001", "Brake Pad", 4, "Worn out", "Tariq", "Pending"));
        requestList.add(new PartRequest("REQ002", "Battery", 1, "Dead battery", "Nadia", "Pending"));
        requestList.add(new PartRequest("REQ003", "Wheel Bearing", 2, "Noise issue", "Hasan", "Rejected"));
        requestList.add(new PartRequest("REQ101", "Brake Fluid", 2, "Fluid Top-up", "Karim", "Approved"));




        tableview.getItems().setAll(requestList);




    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

}
