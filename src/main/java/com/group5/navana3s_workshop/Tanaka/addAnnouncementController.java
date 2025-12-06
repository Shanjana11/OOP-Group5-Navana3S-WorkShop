package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Karima.modelClass.salesHistory;
import com.group5.navana3s_workshop.Tanaka.ModelClass.Announcement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class addAnnouncementController
{
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private TableColumn<Announcement, String> priorityColumn;
    @javafx.fxml.FXML
    private TableView<Announcement> announcementTableView;
    @javafx.fxml.FXML
    private TableColumn<Announcement, String> messageColumn;
    @javafx.fxml.FXML
    private TextArea messageTextArea;
    @javafx.fxml.FXML
    private DatePicker announcementDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Announcement, String> sentByColumn;
    @javafx.fxml.FXML
    private TableColumn<Announcement, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private CheckBox sendAllCustomersCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
        priorityComboBox.getItems().addAll("High", "Medium", "Low");

        messageColumn.setCellValueFactory(new PropertyValueFactory<>("message"));
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
        sentByColumn.setCellValueFactory(new PropertyValueFactory<>("sentBy"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        announcementTableView.setPlaceholder(new Label("No announcements added yet"));
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void submitOnActionButton(ActionEvent actionEvent) {

        String priority = priorityComboBox.getValue();
        String message = messageTextArea.getText();
        LocalDate date = announcementDateDatePicker.getValue();
        boolean sendAll = sendAllCustomersCheckBox.isSelected();

        String sentBy = "Marketing Dept.";
        String title = "General Announcement";

        if (priority == null || priority.isBlank()
                || message == null || message.isBlank()
                || date == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please fill Priority, Message, and Date.");
            alert.show();
            return;
        }
        String dateStr = date.toString();

        Announcement announcement = new Announcement( title, message, priority, date, sendAll, sentBy);

        announcementTableView.getItems().add(announcement);

        messageTextArea.clear();
        announcementDateDatePicker.setValue(null);
        priorityComboBox.getSelectionModel().clearSelection();
        sendAllCustomersCheckBox.setSelected(false);

        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setHeaderText("Announcement Added");
        success.setContentText("Your announcement has been successfully added.");
        success.show();
    }
}