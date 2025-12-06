package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class trackCustomerResponsesController
{
    @javafx.fxml.FXML
    private ComboBox<String> priorityComboBox;
    @javafx.fxml.FXML
    private DatePicker dateDatePicker;
    @javafx.fxml.FXML
    private TextArea inputTextArea;
    @javafx.fxml.FXML
    private TextField messageTextField;
    @javafx.fxml.FXML
    private Label statusLabel;

    private final List<String> responseLog = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        priorityComboBox.getItems().addAll("High", "Medium", "Low");
        statusLabel.setText("");
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
    public void sendAnnouncementOnActionButton(ActionEvent actionEvent) {
        String priority = priorityComboBox.getValue();
        LocalDate date  = dateDatePicker.getValue();
        String message  = messageTextField.getText();
        String notes    = inputTextArea.getText();

        // validation
        StringBuilder errors = new StringBuilder();

        if (priority == null || priority.isBlank()) {
            errors.append("• Select a priority.\n");
        }
        if (date == null) {
            errors.append("• Select a date.\n");
        }
        if (message == null || message.isBlank()) {
            errors.append("• Enter a message.\n");
        }

        if (errors.length() > 0) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText(errors.toString());
            return;
        }

        // build a simple log entry
        String entry =
                "Date: " + date + "\n" +
                        "Priority: " + priority + "\n" +
                        "Message: " + message + "\n" +
                        "Notes/Responses: " + (notes == null || notes.isBlank() ? "-" : notes) + "\n";

        responseLog.add(entry);

        // also append to the big TextArea so user can see the history
        String existing = inputTextArea.getText();
        if (existing == null || existing.isBlank()) {
            inputTextArea.setText(entry);
        } else {
            inputTextArea.setText(existing + "\n---\n" + entry);
        }

        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText("✔ Announcement logged. Total entries: " + responseLog.size());

        // clear only the message field & priority/date if you want
        messageTextField.clear();
        priorityComboBox.getSelectionModel().clearSelection();
        dateDatePicker.setValue(null);
    }
}