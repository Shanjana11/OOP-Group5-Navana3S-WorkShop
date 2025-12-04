package com.group5.navana3s_workshop.Tasfia;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class StartserviceController
{
    @javafx.fxml.FXML
    private TextField modelfield;
    @javafx.fxml.FXML
    private TextField jobidfield;
    @javafx.fxml.FXML
    private TextField vechiclenofield;
    @javafx.fxml.FXML
    private CheckBox brakeCheck;
    @javafx.fxml.FXML
    private CheckBox othersinspectionCheck;
    @javafx.fxml.FXML
    private CheckBox tyreCheck;
    @javafx.fxml.FXML
    private CheckBox electricalCheck;
    @javafx.fxml.FXML
    private CheckBox oilCheck;
    @javafx.fxml.FXML
    private CheckBox enginecheck;
    @javafx.fxml.FXML
    private TextArea textarea;

    @javafx.fxml.FXML
    public void initialize() {
        jobidfield.setText("JOB-001");
        vechiclenofield.setText("DHAKA-XX-1234");
        modelfield.setText("Toyota Corolla");

        textarea.setPromptText("Describe the problem...");

            int random = (int) (Math.random() * 9000) + 1000;
            jobidfield.setText("JOB-" + random);


            vechiclenofield.clear();
            modelfield.clear();
            textarea.clear();


            textarea.setWrapText(true);
            textarea.setPromptText("Describe the vehicle problem...");


            enginecheck.setSelected(false);
            oilCheck.setSelected(false);
            brakeCheck.setSelected(false);
            tyreCheck.setSelected(false);
            electricalCheck.setSelected(false);
            othersinspectionCheck.setSelected(false);

            System.out.println("Start Service Form Loaded!");


    }

    @javafx.fxml.FXML
    public void startserviceOnAction(ActionEvent actionEvent) {
        String jobId = jobidfield.getText();
        String vehicleNo = vechiclenofield.getText();
        String model = modelfield.getText();
        String problem = textarea.getText();
        String checklist = getChecklistInfo();

        System.out.println("START SERVICE");
        System.out.println("Job ID: " + jobId);
        System.out.println("Vehicle No: " + vehicleNo);
        System.out.println("Model: " + model);
        System.out.println("Problem: " + problem);
        System.out.println("Checklist: " + checklist);
        System.out.println("");

    }

    @javafx.fxml.FXML
    public void backOnAction(ActionEvent actionEvent)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/techinician.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button signOutButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.setScene(scene);

    }

    @javafx.fxml.FXML
    public void saveProgressOnAction(ActionEvent actionEvent) {
        String jobId = jobidfield.getText();
        String vehicleNo = vechiclenofield.getText();
        String model = modelfield.getText();
        String checklist = getChecklistInfo();

        System.out.println("Progress Saved");
        System.out.println("Job ID: " + jobId);
        System.out.println("Vehicle: " + vehicleNo);
        System.out.println("Model: " + model);
        System.out.println("Checklist: " + checklist);
    }


    private String getChecklistInfo() {
        StringBuilder sb = new StringBuilder();

        if (enginecheck.isSelected()) sb.append("Engine Check, ");
        if (oilCheck.isSelected()) sb.append("Oil Level Check, ");
        if (brakeCheck.isSelected()) sb.append("Brake Check, ");
        if (tyreCheck.isSelected()) sb.append("Tyre Condition Check, ");
        if (electricalCheck.isSelected()) sb.append("Electrical Check, ");
        if (othersinspectionCheck.isSelected()) sb.append("Others Inspection, ");

        if (sb.length() > 2)
            sb.setLength(sb.length() - 2); 

        return sb.toString();
    }

}