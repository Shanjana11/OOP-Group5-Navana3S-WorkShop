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

import java.io.IOException;
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


    List<PartRequest> requestList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        selectstatusCombobox.getItems().addAll("Approved","Rejected","Pending");

        techniciancol.setCellValueFactory(new PropertyValueFactory<>("technician"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partname"));
        qtycol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        reasoncol.setCellValueFactory(new PropertyValueFactory<>("reason"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));



        //Add some samplle data
        requestList.add(new PartRequest("REQ001", "Brake Pad", 4, "Worn out", "Tariq", "Pending"));
        requestList.add(new PartRequest("REQ002", "Battery", 1, "Dead battery", "Nadia", "Pending"));
        requestList.add(new PartRequest("REQ003", "Wheel Bearing", 2, "Noise issue", "Hasan", "Rejected"));

       //Set List into tableview


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