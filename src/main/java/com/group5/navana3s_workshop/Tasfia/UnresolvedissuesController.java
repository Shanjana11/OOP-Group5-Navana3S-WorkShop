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

import java.io.*;
import java.util.ArrayList;

public class UnresolvedissuesController
{
    @javafx.fxml.FXML
    private TextField managerfield;
    @javafx.fxml.FXML
    private TableColumn<UnresolvedIssue,String> severitycol;
    @javafx.fxml.FXML
    private TableView <UnresolvedIssue>tableview;
    @javafx.fxml.FXML
    private TableColumn<UnresolvedIssue,String> managercol;
    @javafx.fxml.FXML
    private TextArea textarea;
    @javafx.fxml.FXML
    private ComboBox<String> combobox;
    @javafx.fxml.FXML
    private TableColumn descriptioncol;

    private final String filePath = "unresolved_issues.dat";



    private ObservableList<UnresolvedIssue> issueList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        combobox.getItems().addAll("Low","Medium","High");

        descriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        severitycol.setCellValueFactory(new PropertyValueFactory<>("severity"));
        managercol.setCellValueFactory(new PropertyValueFactory<>("manager"));


        loadIssues();



        issueList.addAll(
                new UnresolvedIssue("Engine overheating", "High", "Mr. Rahman"),
                new UnresolvedIssue("Brake malfunction", "Medium", "Ms. Fatima"),
                new UnresolvedIssue("Headlight not working", "Low", "Mr. Karim")
        );

        tableview.setItems(issueList);

    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/technician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void saveOnActionButton(ActionEvent actionEvent) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(new ArrayList<>(issueList));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved successfully!", ButtonType.OK);
            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to save!", ButtonType.OK);
            alert.showAndWait();
        }

    }

    private void loadIssues() {
        File file = new File(filePath);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<UnresolvedIssue> savedList = (ArrayList<UnresolvedIssue>) ois.readObject();
            issueList.addAll(savedList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void addissueOnActionButton(ActionEvent actionEvent) {
        String description = textarea.getText();
        String severity = combobox.getValue();
        String manager = managerfield.getText();

        if (description.isEmpty() || severity == null || manager.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Please fill all fields",ButtonType.OK);
            alert.showAndWait();
            return;

        }

        UnresolvedIssue newUnresolvedIssue = new UnresolvedIssue(description,severity,manager);
        issueList.add(newUnresolvedIssue);


    }
}