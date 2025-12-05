package com.group5.navana3s_workshop.Shanjana;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WarrantyClaimController {

    @FXML
    private Label infoLabel;
    @FXML
    private TextArea descriveArea;
    @FXML
    private ComboBox<String> BookIDCombo;
    @FXML
    private ComboBox<String> partsCombo;

    private final String BOOKINGS_FILE = "bookings.dat";
    private final String CLAIM_FILE = "warrantyClaims.dat";

    @FXML
    public void initialize() {
        loadBookingIDs();
        loadParts();
    }

    private void loadBookingIDs() {
        File file = new File(BOOKINGS_FILE);
        if (!file.exists()) {
            infoLabel.setText("No bookings found.");
            return;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            List<BookService> list = (List<BookService>) in.readObject();
            for (BookService b : list) {
                BookIDCombo.getItems().add(b.getBookingId());
            }
        } catch (Exception e) {
            infoLabel.setText("Unable to load booking IDs.");
        }
    }

    private void loadParts() {
        partsCombo.getItems().addAll(
                "Engine Part",
                "Brake System",
                "Electrical Component",
                "Suspension Part",
                "Cooling System",
                "Battery Related"
        );
    }

    @FXML
    public void Submit(ActionEvent actionEvent) {
        String bookingId = BookIDCombo.getValue();
        String part = partsCombo.getValue();
        String description = descriveArea.getText().trim();

        if (bookingId == null || part == null || description.isEmpty()) {
            infoLabel.setText("Fill every field before submitting.");
            return;
        }

        RequestWarranty claim = new RequestWarranty(
                bookingId,
                part,
                description,
                LocalDateTime.now()
        );

        saveClaim(claim);

        infoLabel.setText("Warranty claim submitted successfully!");
        descriveArea.clear();
        partsCombo.setValue(null);
        BookIDCombo.setValue(null);
    }

    private void saveClaim(RequestWarranty claim) {
        List<RequestWarranty> list = loadClaims();

        list.add(claim);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CLAIM_FILE))) {
            out.writeObject(list);
        } catch (IOException e) {
            infoLabel.setText("Error saving claim.");
        }
    }

    private List<RequestWarranty> loadClaims() {
        File file = new File(CLAIM_FILE);

        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(file))) {
            return (List<RequestWarranty>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
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
