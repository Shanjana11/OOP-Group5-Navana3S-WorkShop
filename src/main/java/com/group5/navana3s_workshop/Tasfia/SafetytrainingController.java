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
import java.time.LocalDate;
import java.util.ArrayList;

public class SafetytrainingController
{
    @javafx.fxml.FXML
    private DatePicker trainingdate;
    @javafx.fxml.FXML
    private ComboBox <String>completioncombobox;
    @javafx.fxml.FXML
    private TableColumn<SafetyTraningModel,String> notescol;
    @javafx.fxml.FXML
    private TableColumn<SafetyTraningModel, LocalDate> datecol;
    @javafx.fxml.FXML
    private TableColumn <SafetyTraningModel,String>statuscol;
    @javafx.fxml.FXML
    private TextField namefield;
    @javafx.fxml.FXML
    private TableColumn <SafetyTraningModel,String>modulecol;
    @javafx.fxml.FXML
    private TableView<SafetyTraningModel> tableview;
    @javafx.fxml.FXML
    private ComboBox<String> combobox;
    @javafx.fxml.FXML
    private TextArea textarea;

    private static final String FILE_NAME = "safety_training_data.dat";


    ObservableList<SafetyTraningModel> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        combobox.getItems().addAll("Fire Safety", "Electrical Safety", "Machine Handling", "First Aid", "Chemical Safety");

        completioncombobox.getItems().addAll("Completed","In Progress","Pending");

        modulecol.setCellValueFactory(new PropertyValueFactory<>("module"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
        notescol.setCellValueFactory(new PropertyValueFactory<>("notes"));


        loadDataFromFile();


        tableview.setItems(list);


        list.add(new SafetyTraningModel("Fire Safety", LocalDate.of(2024, 1, 10), "Completed", "Basic fire handling training"));
        list.add(new SafetyTraningModel("Machine Handling",LocalDate.of(2024, 2, 5), "Completed", "Trained for machine operation"));
        list.add(new SafetyTraningModel("First Aid", LocalDate.of(2024, 3, 12), "Pending", "Scheduled soon"));

    }

    @javafx.fxml.FXML
    public void addtrainigOnActionButton(ActionEvent actionEvent) {
        String module = combobox.getValue();
        LocalDate date = trainingdate.getValue();
        String status = completioncombobox.getValue();
        String notes = textarea.getText();

        if (module == null || date == null || status == null ) {
            showAlert("Please fill all required fields!!");
            return;
        }

        SafetyTraningModel s = new SafetyTraningModel(module,date,status,notes);
        list.add(s);




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
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(list)); // save as ArrayList
            showAlert("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error saving data: " + e.getMessage());

    }


    }


    private void showAlert( String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.show();
    }

    private void loadDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> savedList) {
                for (Object o : savedList) {
                    if (o instanceof SafetyTraningModel stm) {
                        list.add(stm);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found or error reading file.");
        }
    }


}