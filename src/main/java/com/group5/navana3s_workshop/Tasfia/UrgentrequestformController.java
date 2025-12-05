package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class UrgentrequestformController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel,String> reqidcol;
    @javafx.fxml.FXML
    private Spinner<Integer> qunatityspinner;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel,String> partidcol;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel,String> partnamecol;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel,Integer> qtycol;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel, LocalDate> requiredcol;
    @javafx.fxml.FXML
    private TextField partidfield;
    @javafx.fxml.FXML
    private TextArea textarea;
    @javafx.fxml.FXML
    private TableColumn<UrgentRequestModel,String> statuscol;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TableView<UrgentRequestModel> tableview;
    @javafx.fxml.FXML
    private CheckBox managerapprovedcheckbox;

    private ObservableList<UrgentRequestModel> list = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() {
        qunatityspinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

        reqidcol.setCellValueFactory(new PropertyValueFactory<>("requestId"));
        partidcol.setCellValueFactory(new PropertyValueFactory<>("partId"));
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        qtycol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        requiredcol.setCellValueFactory(new PropertyValueFactory<>("requiredBy"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tableview.setItems(list);
    }

    @javafx.fxml.FXML
    public void updatedashboardOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Dashboard updated successfully!", ButtonType.OK);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void saveandnotifyvendorOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Record saved and vendor notified!", ButtonType.OK);
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void generaterecordOnAction(ActionEvent actionEvent) {
        if(partidfield.getText().isEmpty() || partnamefield.getText().isEmpty() || date.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all mandatory fields!", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        UrgentRequestModel req = new UrgentRequestModel(
                "REQ" + (list.size() + 1),
                partidfield.getText(),
                partnamefield.getText(),
                qunatityspinner.getValue(),
                date.getValue(),
                managerapprovedcheckbox.isSelected() ? "Approved" : "Pending"
        );


        list.add(req);
        clearFields();
    }

    private void clearFields() {
        partidfield.clear();
        partnamefield.clear();
        qunatityspinner.getValueFactory().setValue(1);
        date.setValue(null);
        textarea.clear();
        managerapprovedcheckbox.setSelected(false);
    }
}