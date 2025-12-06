package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class financialReportController
{
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> reportTypeComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        reportTypeComboBox.getItems().addAll(
                "Income Statement",
                "Expense Report",
                "Profit & Loss",
                "Cash Flow",
                "Vendor Payments",
                "Customer Receivables");
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountsOfficerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void generateReportOnActionButton(ActionEvent actionEvent) {
        String reportType = reportTypeComboBox.getValue();
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();

        if (reportType == null || reportType.isBlank()
                || from == null || to == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Filters");
            alert.setContentText("Please select report type and both From/To dates.");
            alert.show();
            return;
        }
        if (to.isBefore(from)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Date Range");
            alert.setContentText("To Date cannot be before From Date.");
            alert.show();
            return;
        }

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Report Generated");
        ok.setContentText(
                "Report Type: " + reportType + "\n" +
                        "From: " + from + "\n" +
                        "To: " + to + "\n\n" +
                        "(Demo: here you would show/download the real financial report.)"
        );
        ok.show();
    }
}