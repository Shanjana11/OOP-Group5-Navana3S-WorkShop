package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.FinancingPlan;
import com.group5.navana3s_workshop.Tanaka.ModelClass.AddOffer;
import com.group5.navana3s_workshop.Tanaka.ModelClass.Offer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class addOfferController {
    @javafx.fxml.FXML
    private TextField discountPercentageTextField;
    @javafx.fxml.FXML
    private DatePicker offerStartDatePicker;
    @javafx.fxml.FXML
    private TextField offerNameTextField;
    @javafx.fxml.FXML
    private DatePicker offerEndDatePicker;
    @javafx.fxml.FXML
    private TableColumn<AddOffer, Double> discountPercentageColumn;
    @javafx.fxml.FXML
    private TableView<AddOffer> newOfferTableView;
    @javafx.fxml.FXML
    private TableColumn<AddOffer, String> offerNameColumn;
    @javafx.fxml.FXML
    private TableColumn<AddOffer, String> endOfferColunb;
    @javafx.fxml.FXML
    private TableColumn<AddOffer, String> startOfferColumn;

    private final ArrayList<AddOffer> addOfferList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("offerName"));
        discountPercentageColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        startOfferColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endOfferColunb.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        newOfferTableView.setPlaceholder(new Label("No offers added yet"));
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void addOfferOnActionButton(ActionEvent actionEvent) {
        String offerName = offerNameTextField.getText();
        String discountText = discountPercentageTextField.getText();
        LocalDate startDate = offerStartDatePicker.getValue();
        LocalDate endDate = offerEndDatePicker.getValue();

        if (offerName == null || offerName.isBlank()
                || discountText == null || discountText.isBlank()
                || startDate == null
                || endDate == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Offer Details");
            alert.setContentText("Please fill Offer Name, Discount, Start Date and End Date.");
            alert.show();
            return;
        }


        int discount;
        try {
            discount = Integer.parseInt(discountText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Discount");
            alert.setContentText("Discount must be a number.");
            alert.show();
            return;
        }

        if (discount <= 0 || discount > 100) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Discount");
            alert.setContentText("Discount must be between 1% and 100%.");
            alert.show();
            return;
        }

        if (endDate.isBefore(startDate)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Date Range");
            alert.setContentText("End date cannot be before start date.");
            alert.show();
            return;
        }

        String startStr = startDate.toString();
        String endStr = endDate.toString();

        AddOffer newOffer = new AddOffer(offerName, discount, startStr, endStr);
        addOfferList.add(newOffer);

        newOfferTableView.getItems().setAll(addOfferList);

        offerNameTextField.clear();
        discountPercentageTextField.clear();
        offerStartDatePicker.setValue(null);
        offerEndDatePicker.setValue(null);

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Offer Added Successfully");
        ok.setContentText("The offer has been added.");
        ok.show();
    }

}