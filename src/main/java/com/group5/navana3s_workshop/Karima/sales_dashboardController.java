package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class sales_dashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void salesPerformance(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/servicePricing.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button salesPerformance = (Button) actionEvent.getSource();
        Stage stage = (Stage) salesPerformance.getScene().getWindow();
        stage.setScene(scene);
    }


    @javafx.fxml.FXML
    public void vehicleSpecification(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/vehicleSpecification.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button vehicleSpecification = (Button) actionEvent.getSource();
        Stage stage = (Stage) vehicleSpecification.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void financingOptions(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/financingOptions.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button financingOptions = (Button) actionEvent.getSource();
        Stage stage = (Stage) financingOptions.getScene().getWindow();
        stage.setScene(scene);
    }


    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button logOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(scene);
    }


    @javafx.fxml.FXML
    public void vehicleBooking(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/vehicleBooking.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button vehicleBooking = (Button) actionEvent.getSource();
        Stage stage = (Stage) vehicleBooking.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void customerConsultation(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/customerConsultation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button customerConsultation = (Button) actionEvent.getSource();
        Stage stage = (Stage) customerConsultation.getScene().getWindow();
        stage.setScene(scene);
    }



    @javafx.fxml.FXML
    public void customerManagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/customerManagement.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button customerManagement = (Button) actionEvent.getSource();
        Stage stage = (Stage) customerManagement.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void salesHistory(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/salesHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button salesHistory = (Button) actionEvent.getSource();
        Stage stage = (Stage) salesHistory.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void paymentCoordination(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/paymentCoordination.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button paymentCoordination = (Button) actionEvent.getSource();
        Stage stage = (Stage) paymentCoordination.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void servicePricing(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/servicePricing.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button paymentCoordination = (Button) actionEvent.getSource();
        Stage stage = (Stage) paymentCoordination.getScene().getWindow();
        stage.setScene(scene);
    }

}