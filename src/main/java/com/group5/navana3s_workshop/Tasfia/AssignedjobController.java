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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssignedjobController
{
    @javafx.fxml.FXML
    private TextField textSearch;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> statuscol;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> jobIDcol;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> assigneddatecol;
    @javafx.fxml.FXML
    private TableView<AssignedJob> jobTable;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> vechiclenocol;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> problemcol;
    @javafx.fxml.FXML
    private TableColumn<AssignedJob,String> modelcol;

    private List<AssignedJob> jobList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        jobIDcol.setCellValueFactory(new PropertyValueFactory<>("jobID"));
        vechiclenocol.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        modelcol.setCellValueFactory(new PropertyValueFactory<>("model"));
        problemcol.setCellValueFactory(new PropertyValueFactory<>("problem"));
        assigneddatecol.setCellValueFactory(new PropertyValueFactory<>("assignedDate"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void loadTableData() {
        // Demo Data

    }

    @javafx.fxml.FXML
    public void startServiceOnAction(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void viewdetailsOnAction(ActionEvent actionEvent) {


    }

    @javafx.fxml.FXML
    public void refreshOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}