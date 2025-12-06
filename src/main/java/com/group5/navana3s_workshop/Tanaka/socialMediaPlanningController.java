package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class socialMediaPlanningController
{
    @javafx.fxml.FXML
    private TextArea contentBodyTextArea;
    @javafx.fxml.FXML
    private CheckBox approvedCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> selectPlatformComboBox;

    private final List<String> plannedPosts = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        selectPlatformComboBox.getItems().addAll("Facebook", "Instagram", "YouTube", "X (Twitter)", "TikTok", "LinkedIn");
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }
}