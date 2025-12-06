package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.Tanaka.ModelClass.Campaign;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class seasonalCampaignController
{
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> endDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign, LocalDate> startDateColumn;
    @javafx.fxml.FXML
    private TableColumn<Campaign, String> statusColumn;
    @javafx.fxml.FXML
    private TableView<Campaign> seasonalCampaigntableView;
    @javafx.fxml.FXML
    private CheckBox ActiveTypeCheckbox;
    @javafx.fxml.FXML
    private TableColumn<Campaign, String> campaignNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> campaignTypeCombobox;


    private final ObservableList<Campaign> campaignList =
            FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        campaignTypeCombobox.getItems().addAll("Service Campaign", "Sales Campaign", "Holiday Offer", "Safety Checkup");

        campaignNameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));


        campaignList.add(new Campaign(
                "Summer AC Checkup",
                LocalDate.of(2025, 6, 1),
                LocalDate.of(2025, 6, 30),
                Arrays.asList("SMS", "Email"),
                "Active",
                "Service Campaign"
        ));

        campaignList.add(new Campaign(
                "Eid Service Discount",
                LocalDate.of(2025, 3, 10),
                LocalDate.of(2025, 4, 10),
                Arrays.asList("Facebook", "Email"),
                "Completed",
                "Service Campaign"
        ));

        campaignList.add(new Campaign(
                "Winter Battery Check",
                LocalDate.of(2025, 11, 1),
                LocalDate.of(2025, 11, 30),
                Arrays.asList("SMS"),
                "Planned",
                "Safety Checkup"
        ));

        seasonalCampaigntableView.setItems(campaignList);
        seasonalCampaigntableView.setPlaceholder(new Label("No seasonal campaigns available"));

        ActiveTypeCheckbox.selectedProperty().addListener((obs, oldVal, newVal) -> applyFilter());
        campaignTypeCombobox.valueProperty().addListener((obs, oldVal, newVal) -> applyFilter());
    }

    private void applyFilter() {

        ObservableList<Campaign> filtered = FXCollections.observableArrayList();

        String selectedType = campaignTypeCombobox.getValue();
        boolean activeOnly = ActiveTypeCheckbox.isSelected();

        for (Campaign c : campaignList) {

            boolean ok = true;

            if (selectedType != null && !selectedType.isBlank()
                    && !selectedType.equalsIgnoreCase(c.getDescription())) {
                ok = false;
            }

            if (activeOnly && !"Active".equalsIgnoreCase(c.getStatus())) {
                ok = false;
            }

            if (ok) {
                filtered.add(c);
            }
        }

        if ((selectedType == null || selectedType.isBlank()) && !activeOnly) {
            // no filter → show all
            seasonalCampaigntableView.setItems(campaignList);
        } else {
            seasonalCampaigntableView.setItems(filtered);
        }
    }
}