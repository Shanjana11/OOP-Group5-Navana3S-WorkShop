package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class editOfferController
{
    @javafx.fxml.FXML
    private TableColumn discountColumn;
    @javafx.fxml.FXML
    private TableView editOfferTableView;
    @javafx.fxml.FXML
    private TableColumn offerNameColumn;
    @javafx.fxml.FXML
    private DatePicker validityUpdateDatePicker;
    @javafx.fxml.FXML
    private TextField selectedOfferEditTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setTitle("Test Drive");
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void updateOfferOnActionButton(ActionEvent actionEvent) {
    }
}