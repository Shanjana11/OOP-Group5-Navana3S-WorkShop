package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.CampaignReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class campaignSummaryReportController
{
    @javafx.fxml.FXML
    private TableColumn<CampaignReport, Integer> customerCountColumn;
    @javafx.fxml.FXML
    private ComboBox<String> capaignListComboBox;
    @javafx.fxml.FXML
    private TextField selectCampaignTextField;
    @javafx.fxml.FXML
    private TableColumn<CampaignReport,Integer> clicksColumn;
    @javafx.fxml.FXML
    private DatePicker fromDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CampaignReport, Integer> reachColumn;
    @javafx.fxml.FXML
    private TableColumn<CampaignReport, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<CampaignReport> campaignSummaryTableView;
    @javafx.fxml.FXML
    private TableColumn<CampaignReport, Integer> conversionsColumn;
    @javafx.fxml.FXML
    private DatePicker toDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<CampaignReport, String> campaignNameColumn;

    private final ObservableList<CampaignReport> masterList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        capaignListComboBox.getItems().addAll("New Year Blast", "Facebook Lead Gen", "Email Retargeting", "Service Reminder SMS");

        campaignNameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        customerCountColumn.setCellValueFactory(new PropertyValueFactory<>("customerCount"));
        reachColumn.setCellValueFactory(new PropertyValueFactory<>("reach"));
        clicksColumn.setCellValueFactory(new PropertyValueFactory<>("clicks"));
        conversionsColumn.setCellValueFactory(new PropertyValueFactory<>("conversions"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));


        masterList.add(new CampaignReport("New Year Blast", 120, 5000, 800, 60, "Active"));
        masterList.add(new CampaignReport("Facebook Lead Gen", 80, 3000, 500, 40, "Completed"));
        masterList.add(new CampaignReport("Email Retargeting", 50, 1500, 200, 25, "Paused"));
        masterList.add(new CampaignReport("Service Reminder SMS", 200, 7000, 900, 100, "Active"));

        campaignSummaryTableView.setItems(masterList);
        campaignSummaryTableView.setPlaceholder(new Label("No content in table"));
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("com/group5/navana3s_workshop/Tanaka/marketingAndPromotionsDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Button backButton = (Button) actionEvent.getSource();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @javafx.fxml.FXML
    public void exportOnActionButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Export");
        alert.setContentText("Campaign summary exported successfully (demo).");
        alert.show();
    }

    @javafx.fxml.FXML
    public void generateReportOnActionButton(ActionEvent actionEvent) {
        String typedName = selectCampaignTextField.getText();
        if (typedName == null) typedName = "";
        typedName = typedName.trim().toLowerCase();

        String selectedFromList = capaignListComboBox.getValue();
        LocalDate fromDate = fromDateDatePicker.getValue();
        LocalDate toDate = toDateDatePicker.getValue();

        ObservableList<CampaignReport> filtered = FXCollections.observableArrayList();

        for (CampaignReport r : masterList) {

            boolean ok = true;
            if (!typedName.isEmpty()
                    && !r.getCampaignName().toLowerCase().contains(typedName)) {
                ok = false;
            }

            if (selectedFromList != null
                    && !selectedFromList.isBlank()
                    && !r.getCampaignName().equals(selectedFromList)) {
                ok = false;
            }

            if (ok) {
                filtered.add(r);
            }
        }
        if (typedName.isEmpty()
                && (selectedFromList == null || selectedFromList.isBlank())
                && fromDate == null && toDate == null) {
            campaignSummaryTableView.setItems(masterList);
        } else {
            campaignSummaryTableView.setItems(filtered);
        }
    }
}