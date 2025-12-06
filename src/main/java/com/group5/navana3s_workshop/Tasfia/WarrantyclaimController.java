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

public class WarrantyclaimController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn <WarrantyClaim,String>partnamecol;
    @javafx.fxml.FXML
    private TextArea claimarea;
    @javafx.fxml.FXML
    private TableColumn<WarrantyClaim,String> datecol;
    @javafx.fxml.FXML
    private TextField partnamefield;
    @javafx.fxml.FXML
    private TableView<WarrantyClaim> tabelview;
    @javafx.fxml.FXML
    private TableColumn<WarrantyClaim,String> descriptioncol;


    private ObservableList<WarrantyClaim> claimList = FXCollections.observableArrayList();

    private final String FILE_NAME = "warrantyclaims.bin";


    @javafx.fxml.FXML
    public void initialize() {
        partnamecol.setCellValueFactory(new PropertyValueFactory<>("partName"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("claimDate"));
        descriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));


        loadClaimsFromFile();


        claimList.add(new WarrantyClaim("Engine Part A", LocalDate.now().toString(), "Engine replacement needed"));
        claimList.add(new WarrantyClaim("Brake Pad", LocalDate.now().minusDays(2).toString(), "Brake malfunction"));
        claimList.add(new WarrantyClaim("Oil Filter", LocalDate.now().minusDays(5).toString(), "Regular maintenance"));




        tabelview.setItems(claimList);
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/sparepartsmanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void submitclaimOnActionButton(ActionEvent actionEvent) {
        LocalDate claimDate = date.getValue();
        String partName = partnamefield.getText().trim();
        String description = claimarea.getText().trim();


        if (claimDate == null || partName.isEmpty() || description.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all fields!!");
            alert.showAndWait();
            return;
        }
        WarrantyClaim claim = new WarrantyClaim(partName,claimDate.toString(),description);
        claimList.add(claim);

        date.setValue(null);
        partnamefield.clear();
        claimarea.clear();

    }

    private void saveClaimsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new ArrayList<>(claimList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadClaimsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            claimList.add(new WarrantyClaim("Engine Part A", LocalDate.now().toString(), "Engine replacement needed"));
            claimList.add(new WarrantyClaim("Brake Pad", LocalDate.now().minusDays(2).toString(), "Brake malfunction"));
            claimList.add(new WarrantyClaim("Oil Filter", LocalDate.now().minusDays(5).toString(), "Regular maintenance"));
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> list) {
                for (Object o : list) {
                    if (o instanceof WarrantyClaim claim) {
                        claimList.add(claim);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}