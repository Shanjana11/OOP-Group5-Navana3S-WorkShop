package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.DeleteOffer;
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

public class deleteOfferController {
    @javafx.fxml.FXML
    private TableView<DeleteOffer> deleteOfferTableView;
    @javafx.fxml.FXML
    private TableColumn<DeleteOffer, String> selectOrDeleteColumn;
    @javafx.fxml.FXML
    private CheckBox selectCheckbox;
    @javafx.fxml.FXML
    private CheckBox deleteCheckBox;
    @javafx.fxml.FXML
    private TableColumn<DeleteOffer, String> offerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<DeleteOffer, LocalDate> expiryDateColumn;
    @javafx.fxml.FXML
    private Label confirmationLabel;

    private final ObservableList<DeleteOffer> offerList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("offerName"));
        expiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        offerList.add(new DeleteOffer("New Year Discount", 10, "2025-01-01", "2025-01-31"));

        offerList.add(new DeleteOffer("Service Week Offer", 15, "2025-02-10", "2025-02-20"));

        offerList.add(new DeleteOffer("Monsoon Checkup", 20, "2025-06-01", "2025-06-30"));

        deleteOfferTableView.setItems(offerList);
        deleteOfferTableView.setPlaceholder(new Label("No offers available"));
        confirmationLabel.setText("");
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
    public void deleteOfferOnActionButton(ActionEvent actionEvent) {

        DeleteOffer selected = deleteOfferTableView.getSelectionModel().getSelectedItem();

        if (!selectCheckbox.isSelected()) {
            confirmationLabel.setText("Please tick 'Select' before deleting.");
            return;

        }

        if (!deleteCheckBox.isSelected()) {
            confirmationLabel.setText("Please tick 'Delete' to confirm deletion.");
            return;

        }

        if (selected == null) {
            confirmationLabel.setText("Please select an offer from the table.");
            return;
        }

        offerList.remove(selected);
        deleteOfferTableView.refresh();

        confirmationLabel.setText("Offer '" + selected.getOfferName() + "' deleted successfully.");

                selectCheckbox.setSelected(false);
                deleteCheckBox.setSelected(false);
    }
}