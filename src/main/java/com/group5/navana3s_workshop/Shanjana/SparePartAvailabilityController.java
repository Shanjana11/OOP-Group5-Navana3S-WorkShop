package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tasfia.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SparePartAvailabilityController {

    @FXML
    private TextField partName;

    @FXML
    private Label partInfo;

    private final String FILE_PATH = "D:\\Study\\7th semester\\OOP Projects\\Navana3S_WorkShop\\spareParts.dat";

    @FXML
    public void initialize() {
        // Optional: You could pre-load dummy data here
    }

    @FXML
    public void checkPart(ActionEvent actionEvent) {
        String searchText = partName.getText().trim();

        if (searchText.isEmpty()) {
            partInfo.setText("Please enter part name or ID");
            return;
        }

        List<Part> list = loadOrCreateDummyData();

        // Search by part name or ID
        for (Part p : list) {
            if (p.getPartName().equalsIgnoreCase(searchText) || p.getPartId().equalsIgnoreCase(searchText)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Part Name: ").append(p.getPartName()).append("\n");
                sb.append("Part ID: ").append(p.getPartId()).append("\n");
                sb.append("Availability: ").append(p.getAvailability()).append("\n");
                sb.append("Price: BDT ").append(p.getPrice()).append("\n");
                sb.append("Alternative Parts: ").append(String.join(", ", p.getAlternativeParts()));
                partInfo.setText(sb.toString());
                return;
            }
        }

        partInfo.setText("No matching part found.");
    }

    private List<Part> loadOrCreateDummyData() {
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            return createDummyFile();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Part>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return createDummyFile();
        }
    }

    private List<Part> createDummyFile() {
        List<Part> dummy = new ArrayList<>();
        dummy.add(new Part("Brake Pad", "BP-2024", "In Stock", 2500.0, Arrays.asList("BP-2023", "BP-2025")));
        dummy.add(new Part("Oil Filter", "OF-101", "In Stock", 800.0, Arrays.asList("OF-100", "OF-102")));
        dummy.add(new Part("Air Filter", "AF-150", "Out of Stock", 1200.0, Arrays.asList("AF-149", "AF-151")));
        dummy.add(new Part("Spark Plug", "SP-300", "In Stock", 500.0, Arrays.asList("SP-299", "SP-301")));
        dummy.add(new Part("Timing Belt", "TB-450", "Low Stock", 3500.0, Arrays.asList("TB-449", "TB-451")));

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(dummy);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return dummy;
    }

    @FXML
    public void Back(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }
}
