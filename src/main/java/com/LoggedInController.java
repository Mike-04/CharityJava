package com;

import com.domain.CazCaritabil;
import com.domain.Donator;
import com.domain.User;
import com.service.Service;
import com.service.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.util.Builder;
import javafx.util.converter.DoubleStringConverter;

import java.util.List;

public class LoggedInController {
    private Service service;
    private User user;

    @FXML
    TableView<CazCaritabil> cazTable;
    @FXML
    TableColumn<CazCaritabil, String> cazName;
    @FXML
    TableColumn<CazCaritabil, Double> cazSum;
    @FXML
    Label userLabel;

    @FXML
    TableView<Donator> donatorTable;
    @FXML
    TableColumn<Donator, String> donatorName;
    @FXML
    TableColumn<Donator, String> donatorAddress;
    @FXML
    TableColumn<Donator, String> donatorPhone;
    @FXML
    TextField searchBar;

    @FXML
    TextField newCazName;
    @FXML
    Button addCase;
    @FXML
    TextField newDonorName;
    @FXML
    TextField newDonorAddress;
    @FXML
    TextField newDonorPhone;
    @FXML
    Button addDonor;

    @FXML
    TextField amount;





    public LoggedInController() {

    }

    public void setStuff(Service service, User user) {
        this.service = service;
        this.user = user;
        populateCazTable();
        populateDonatorTable();
        userLabel.setText("Logged in as: " + user.getUsername());
    }

    public void populateCazTable() {
    List<CazCaritabil> cazuri = service.getAllCazuriCaritabile();
    ObservableList<CazCaritabil> cazList = FXCollections.observableArrayList(cazuri);

    cazName.setCellValueFactory(new PropertyValueFactory<>("nume"));
    cazSum.setCellValueFactory(new PropertyValueFactory<>("sumaAdunata"));

    cazTable.getItems().clear();
    cazTable.setItems(cazList);

    cazTable.setEditable(true);
    cazName.setCellFactory(TextFieldTableCell.forTableColumn());
    cazName.setOnEditCommit(e -> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNume(e.getNewValue());
        CazCaritabil caz = e.getTableView().getItems().get(e.getTablePosition().getRow());
        caz.setNume(e.getNewValue());
        service.updateCazCaritabil(caz.getId(), caz.getNume(), caz.getSumaAdunata());
    });
    cazSum.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    cazSum.setOnEditCommit(e -> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setSumaAdunata(e.getNewValue());
        CazCaritabil caz = e.getTableView().getItems().get(e.getTablePosition().getRow());
        caz.setSumaAdunata(e.getNewValue());
        service.updateCazCaritabil(caz.getId(), caz.getNume(), caz.getSumaAdunata());
    });
}

public void populateDonatorTable() {
    String search = searchBar.getText();
    List<Donator> donatori;

    if (search.isEmpty()) {
        donatori = service.getAllDonatori();
    } else {
        donatori = service.findByName(search);
    }

    ObservableList<Donator> donatorList = FXCollections.observableArrayList(donatori);
    donatorName.setCellValueFactory(new PropertyValueFactory<>("nume"));
    donatorAddress.setCellValueFactory(new PropertyValueFactory<>("adresa"));
    donatorPhone.setCellValueFactory(new PropertyValueFactory<>("numarTelefon"));

    donatorTable.getItems().clear();
    donatorTable.setItems(donatorList);

    donatorTable.setEditable(true);
    donatorName.setCellFactory(TextFieldTableCell.forTableColumn());
    donatorName.setOnEditCommit(e -> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNume(e.getNewValue());
        Donator donator = e.getTableView().getItems().get(e.getTablePosition().getRow());
        donator.setNume(e.getNewValue());
        service.updateDonator(donator.getId(), donator.getNume(), donator.getAdresa(), donator.getNumarTelefon());
    });

    donatorAddress.setCellFactory(TextFieldTableCell.forTableColumn());
    donatorAddress.setOnEditCommit(e -> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdresa(e.getNewValue());
        Donator donator = e.getTableView().getItems().get(e.getTablePosition().getRow());
        donator.setAdresa(e.getNewValue());
        service.updateDonator(donator.getId(), donator.getNume(), donator.getAdresa(), donator.getNumarTelefon());
    });

    donatorPhone.setCellFactory(TextFieldTableCell.forTableColumn());
    donatorPhone.setOnEditCommit(e -> {
        e.getTableView().getItems().get(e.getTablePosition().getRow()).setNumarTelefon(e.getNewValue());
        Donator donator = e.getTableView().getItems().get(e.getTablePosition().getRow());
        donator.setNumarTelefon(e.getNewValue());
        service.updateDonator(donator.getId(), donator.getNume(), donator.getAdresa(), donator.getNumarTelefon());
    });
}
    public void addCase() {
        //check if the field is not empty
        if(newCazName.getText().isEmpty()) {
            return;
        }
        service.addCazCaritabil(newCazName.getText(), 0);
        newCazName.clear();
        populateCazTable();
    }

    public void addDonor() {
        //check if the fields are not empty
        if(newDonorName.getText().isEmpty() || newDonorAddress.getText().isEmpty() || newDonorPhone.getText().isEmpty()) {
            return;
        }
        service.addDonator(newDonorName.getText(), newDonorAddress.getText(), newDonorPhone.getText());
        newDonorName.clear();
        newDonorAddress.clear();
        newDonorPhone.clear();
        populateDonatorTable();
    }

    public void donate()
    {
        // Get the selected donor and the selected case
        Donator selectedDonor = donatorTable.getSelectionModel().getSelectedItem();
        CazCaritabil selectedCase = cazTable.getSelectionModel().getSelectedItem();
        if(selectedDonor == null || selectedCase == null) {
            return;
        }
        // Get the value of the donation
        double v = Double.parseDouble(amount.getText());
        // Add the donation to the selected case
        service.donate(selectedDonor, selectedCase, v);
        // Update the tables
        populateCazTable();
        populateDonatorTable();

    }
}
