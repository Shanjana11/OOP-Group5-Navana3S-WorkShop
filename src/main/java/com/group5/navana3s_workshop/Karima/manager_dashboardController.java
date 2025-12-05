package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class manager_dashboardController
{

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void dailySchedule(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/dailySchedule.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button dailySchedule = (Button) actionEvent.getSource();
        Stage stage = (Stage) dailySchedule.getScene().getWindow();
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

    @Deprecated
    public void serviceMonitoring(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/completedServices.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button serviceMonitoring = (Button) actionEvent.getSource();
        Stage stage = (Stage) serviceMonitoring.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void resourceManagement(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/resourceManagement.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button resourceManagement = (Button) actionEvent.getSource();
        Stage stage = (Stage) resourceManagement.getScene().getWindow();
        stage.setScene(scene);
    }


    @javafx.fxml.FXML
    public void serviceReports(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/serviceReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button serviceReports = (Button) actionEvent.getSource();
        Stage stage = (Stage) serviceReports.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void inventoryRequests(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/inventoryRequest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button inventoryRequests = (Button) actionEvent.getSource();
        Stage stage = (Stage) inventoryRequests.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void staffProductivity(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/staffProductivity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button staffProductivity = (Button) actionEvent.getSource();
        Stage stage = (Stage) staffProductivity.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void serviceDelays(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/serviceDelays.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button serviceDelays = (Button) actionEvent.getSource();
        Stage stage = (Stage)serviceDelays.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void customerFeedback(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/customerFeedback.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button customerFeedback = (Button) actionEvent.getSource();
        Stage stage = (Stage) customerFeedback.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void completedServices(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/completedServices.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button customerFeedback = (Button) actionEvent.getSource();
        Stage stage = (Stage) customerFeedback.getScene().getWindow();
        stage.setScene(scene);
    }
}