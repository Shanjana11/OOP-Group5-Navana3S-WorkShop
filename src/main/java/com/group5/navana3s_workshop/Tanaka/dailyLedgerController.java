package com.group5.navana3s_workshop.Tanaka;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class dailyLedgerController
{
    @javafx.fxml.FXML
    private DatePicker datePickerFrom;
    @javafx.fxml.FXML
    private DatePicker datePickerEntryDate;
    @javafx.fxml.FXML
    private TextField textFieldCredit;
    @javafx.fxml.FXML
    private TableColumn columnBalance;
    @javafx.fxml.FXML
    private DatePicker datePickerTo;
    @javafx.fxml.FXML
    private TableColumn columnCredit;
    @javafx.fxml.FXML
    private TextField textFieldDebit;
    @javafx.fxml.FXML
    private TableColumn columnDescription;
    @javafx.fxml.FXML
    private TextField textFieldDescription;
    @javafx.fxml.FXML
    private TableColumn columnDate;
    @javafx.fxml.FXML
    private TableColumn columnDebit;
    @javafx.fxml.FXML
    private TableView tableViewLedger;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void onActionExpportLedgerButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onActionAddEntryButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void onActionApplyFilterButton(ActionEvent actionEvent) {
    }
}