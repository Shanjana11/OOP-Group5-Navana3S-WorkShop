package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.EditOffer;
import com.group5.navana3s_workshop.Tanaka.ModelClass.Offer;
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

public class editOfferController
{
    private String offerId;
    private String title;
    private String description;
    private double discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private String applicability;
    @javafx.fxml.FXML
    private TableColumn<EditOffer, Double> discountColumn;
    @javafx.fxml.FXML
    private TableView<EditOffer> editOfferTableView;
    @javafx.fxml.FXML
    private TableColumn<EditOffer, String> offerNameColumn;
    @javafx.fxml.FXML
    private DatePicker validityUpdateDatePicker;
    @javafx.fxml.FXML
    private TextField selectedOfferEditTextField;

    private final ObservableList<EditOffer> editOfferList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("offerName"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discountPercentage"));

        // demo data – replace with DB/shared list later if needed
        editOfferList.add(new EditOffer("New Year Discount", 10, "2025-01-01", "2025-01-31"));
        editOfferList.add(new EditOffer("Service Week Offer", 15, "2025-02-10", "2025-02-20"));
        editOfferList.add(new EditOffer("Monsoon Checkup", 20, "2025-06-01", "2025-06-30"));

        editOfferTableView.setItems(editOfferList);
        editOfferTableView.setPlaceholder(new Label("No offers available"));

        // when user selects a row, show its data in the fields
        editOfferTableView.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldSel, newSel) -> {
                    if (newSel != null) {
                        selectedOfferEditTextField.setText(newSel.getOfferName());
                        // parse endDate String to LocalDate if possible
                        try {
                            validityUpdateDatePicker.setValue(LocalDate.parse(newSel.getEndDate()));
                        } catch (Exception e) {
                            validityUpdateDatePicker.setValue(null);
                        }
                    }
                });
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void updateOfferOnActionButton(ActionEvent actionEvent) {
        EditOffer selected = editOfferTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("No Offer Selected");
            alert.setContentText("Please select an offer from the table first.");
            alert.show();
            return;
        }

        String newName = selectedOfferEditTextField.getText();
        LocalDate newValidity = validityUpdateDatePicker.getValue();

        if (newName == null || newName.isBlank() || newValidity == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Edit");
            alert.setContentText("Please enter offer name and validity date.");
            alert.show();
            return;
        }
        selected.setOfferName(newName);
        selected.setEndDate(newValidity.toString());

        editOfferTableView.refresh();

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Offer Updated");
        ok.setContentText("Offer '" + selected.getOfferName() + "' has been updated.");
        ok.show();
    }
}