package com.group5.navana3s_workshop.Tanaka;

import com.group5.navana3s_workshop.HelloApplication;
import com.group5.navana3s_workshop.Tanaka.ModelClass.PettyCash;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;

public class pettyCashController
{
    @javafx.fxml.FXML
    private TableView<PettyCash> pettyCashTableView;
    @javafx.fxml.FXML
    private TextField entryAmountTextField;
    @javafx.fxml.FXML
    private TableColumn<PettyCash, Integer> amountColumn;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn<PettyCash, LocalDate> dateColumn;
    @javafx.fxml.FXML
    private TableColumn<PettyCash, String> typeColumn;
    @javafx.fxml.FXML
    private TableColumn<PettyCash, String> descriptionColumn;

    private final ObservableList<PettyCash> pettyCashList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        pettyCashTableView.setItems(pettyCashList);
        pettyCashTableView.setPlaceholder(new Label("No petty cash entries"));
    }

    @javafx.fxml.FXML
    public void backOnActionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tanaka/accountHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        }

    @javafx.fxml.FXML
    public void addNewOnActionButton(ActionEvent actionEvent) {
        String amountText = entryAmountTextField.getText();
        String description = descriptionTextArea.getText();

        if (amountText.isBlank() || description.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Incomplete Entry");
            alert.setContentText("Please enter both Amount and Description.");
            alert.show();
            return;
        }

        int amount;
        try {
            amount = Integer.parseInt(amountText.trim());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Amount");
            alert.setContentText("Amount must be a valid integer (ex: 1500)");
            alert.show();
            return;
        }

        if (amount <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Amount");
            alert.setContentText("Amount must be greater than 0.");
            alert.show();
            return;
        }

        String type = "Expense";
        LocalDate date = LocalDate.now();

        PettyCash entry = new PettyCash(amount, date, type, description);

        pettyCashList.add(entry);
        pettyCashTableView.refresh();

        entryAmountTextField.clear();
        descriptionTextArea.clear();

        Alert ok = new Alert(Alert.AlertType.INFORMATION);
        ok.setHeaderText("Entry Added");
        ok.setContentText("New petty cash entry added successfully.");
        ok.show();
    }
}