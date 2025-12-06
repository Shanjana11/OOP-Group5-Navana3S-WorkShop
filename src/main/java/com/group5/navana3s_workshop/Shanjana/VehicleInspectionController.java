package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleInspectionController {

    @FXML
    private CheckBox tyreCondition;
    @FXML
    private CheckBox engineCondition;
    @FXML
    private CheckBox breakCondition;
    @FXML
    private CheckBox others;
    @FXML
    private ComboBox<String> conditionCombo;
    @FXML
    private DatePicker inspectDate;
    @FXML
    private Label infoLabel;
    @FXML
    private ComboBox<String> bookIdCombo;

    private final String FILE_PATH = "inspection.dat";
    private final String BOOKINGS_FILE = "bookings.dat";

    @FXML
    public void initialize() {
        conditionCombo.getItems().addAll("Good", "Bad", "Worse");
        loadBookingIds();
    }

    private void loadBookingIds() {
        File file = new File(BOOKINGS_FILE);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            List<BookService> bookings = (List<BookService>) in.readObject();

            for (BookService b : bookings) {
                if (b.getBookingId() != null && !b.getBookingId().isEmpty()) {
                    bookIdCombo.getItems().add(b.getBookingId());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) event.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void Submit(ActionEvent event) {

        String bookingId = (String) bookIdCombo.getValue();
        LocalDate date = inspectDate.getValue();
        String condition = conditionCombo.getValue();

        if (bookingId == null || date == null || condition == null) {
            infoLabel.setText("Please fill all fields.");
            return;
        }

        if (date.isBefore(LocalDate.now())) {
            infoLabel.setText("Inspection date cannot be in the past.");
            return;
        }

        // Build issues list
        List<String> issues = new ArrayList<>();

        if (tyreCondition.isSelected()) issues.add("Tyre Issue");
        if (engineCondition.isSelected()) issues.add("Engine Issue");
        if (breakCondition.isSelected()) issues.add("Brake Issue");
        if (others.isSelected()) issues.add("Other Issue");

        // Create inspection object
        VehicleInspection inspection = new VehicleInspection(bookingId, date.toString(), condition, issues);

        saveInspection(inspection);

        infoLabel.setText("Inspection saved successfully.");
    }

    private void saveInspection(VehicleInspection inspection) {
        List<VehicleInspection> list = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                list = (List<VehicleInspection>) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        list.add(inspection);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
