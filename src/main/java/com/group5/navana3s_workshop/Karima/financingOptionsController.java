package com.group5.navana3s_workshop.Karima;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.FinancingPlan;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class financingOptionsController
{
    @javafx.fxml.FXML
    private TextField incomeField;
    @javafx.fxml.FXML
    private TableView<FinancingPlan> tableField;
    @javafx.fxml.FXML
    private TableColumn<FinancingPlan,Double> emiCol;
    @javafx.fxml.FXML
    private TableColumn<FinancingPlan,String> planCol;
    @javafx.fxml.FXML
    private TableColumn<FinancingPlan,Integer> paymentCol;
    @javafx.fxml.FXML
    private TextField vehicleModelField;
    @javafx.fxml.FXML
    private Label outputLabel;

    ArrayList<FinancingPlan> plans = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {


        planCol.setCellValueFactory(new PropertyValueFactory<>("planName"));
        emiCol.setCellValueFactory(new PropertyValueFactory<>("emi"));
        paymentCol.setCellValueFactory(new PropertyValueFactory<>("downPayment"));

        System.out.println("planCol: " + planCol);
        System.out.println("emiCol: " + emiCol);
        System.out.println("paymentCol: " + paymentCol);


    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {

        FinancingPlan selected = tableField.getSelectionModel().getSelectedItem();

        if (selected == null) {
            outputLabel.setText("Please select a plan first.");
            return;
        }

        outputLabel.setText("Application sent to Accounts Officer ✔");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/sales_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void searchPlanButton(ActionEvent actionEvent) {
        String model = vehicleModelField.getText();
        String incomeText = incomeField.getText();

        outputLabel.setText("");

        if (model.isEmpty() || incomeText.isEmpty()) {
            outputLabel.setText("Please enter model & income.");
            return;
        }

        int income;
        try {
            income = Integer.parseInt(incomeText);
        } catch (Exception e) {
            outputLabel.setText("Income must be a number.");
            return;
        }



        if (income < 30000) {
            plans.add(new FinancingPlan("Basic Plan", "12,000 BDT/month", "10% Downpayment"));
        } else if (income < 60000) {
            plans.add(new FinancingPlan("Standard Plan", "18,000 BDT/month", "15% Downpayment"));
            plans.add(new FinancingPlan("Comfort Plan", "22,000 BDT/month", "20% Downpayment"));
        } else {
            plans.add(new FinancingPlan("Premium Plan", "30,000 BDT/month", "25% Downpayment"));
            plans.add(new FinancingPlan("Gold Plan", "35,000 BDT/month", "30% Downpayment"));
            plans.add(new FinancingPlan("Platinum Plan", "40,000 BDT/month", "35% Downpayment"));
        }


        tableField.getItems().clear();
        tableField.getItems().addAll(plans);
//        for (FinancingPlan p : plans) {
//            tableField.getItems().add(p);
//        }

        outputLabel.setText("Available plans generated.");
    }
}