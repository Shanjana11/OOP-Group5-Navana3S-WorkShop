package com.group5.navana3s_workshop.Karima;


import com.group5.navana3s_workshop.HelloApplication;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import javafx.stage.FileChooser;




public class serviceReportController {
    @javafx.fxml.FXML
    private DatePicker endDate;
    @javafx.fxml.FXML
    private DatePicker startDate;
    @javafx.fxml.FXML
    private TextArea textArea;
    @javafx.fxml.FXML
    private ComboBox<String> typeCombobox;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private PieChart pieChart;

    @javafx.fxml.FXML
    public void initialize() {

        typeCombobox.getItems().addAll("Weekly", "Monthly");
    }

    @javafx.fxml.FXML
    public void reportButton(ActionEvent actionEvent) {

        String type = typeCombobox.getValue();
        LocalDate start = startDate.getValue();
        LocalDate end = endDate.getValue();


        if (type == null) {
            textArea.setText("Please select report type.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (start == null || end == null) {
            textArea.setText("Please select both start and end dates.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        if (end.isBefore(start)) {
            textArea.setText("End date must be after start date.");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            return;
        }

        int totalCustomers = 45;
        int totalSales = 650000;
        int pendingJobs = 7;
        int completedJobs = 30;
        int cancelledJobs = 1;

        textArea.setText(
                " SERVICE REPORT \n\n" +
                        "Report Type: " + type + "\n" +
                        "Date Range: " + start + " to " + end + "\n" +
                        "Total Customers Served: " + totalCustomers + "\n" +
                        "Completed Services: " + completedJobs + "\n" +
                        "Total Sales: " + totalSales + "\n" +
                        "Cancelled Services: " + cancelledJobs + "\n" +
                        "Pending Jobs: " + pendingJobs + "\n"

        );

        outputLabel.setText("Report Generated Successfully.");
        outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        pieChart.getData().clear();

        PieChart.Data completed = new PieChart.Data("Completed Jobs", completedJobs);
        PieChart.Data pending = new PieChart.Data("Pending Jobs", pendingJobs);
        PieChart.Data cancelled = new PieChart.Data("Cancelled Jobs", cancelledJobs);

        pieChart.getData().addAll(completed, pending, cancelled);
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button loginButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void generatePDF(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("PDF Document", "*.pdf")
        );


        File file = fc.showSaveDialog(outputLabel.getScene().getWindow());
        if (file == null) {
            return;
        }

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            document.add(new Paragraph("SERVICE REPORT"));
            document.add(new Paragraph("Generated on: " + LocalDate.now()));
            document.add(new Paragraph(" "));


            document.add(new Paragraph(textArea.getText()));

            outputLabel.setText("PDF generated successfully!");
            outputLabel.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            outputLabel.setText("Could not generate PDF!");
            outputLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }

        document.close();
    }


}