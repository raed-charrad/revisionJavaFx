package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable {

    @FXML
    private ComboBox typePizza;
    @FXML
    private CheckBox Fromage;
    @FXML
    private CheckBox Jambon;
    @FXML
    private CheckBox Saumon;
    @FXML
    private TextField Coupon;
    @FXML
    private TextField prix;
    ObservableList<String> l = FXCollections.observableArrayList("Margarita(8 DT)", "Neptune(10 Dt)",
            "4 Fromages (12 Dt)");

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        typePizza.setItems(l);
    }

    private int coup = 0;

    @FXML
    public void calculer() throws IOException {
        float total = 0;

        if (typePizza.getSelectionModel().getSelectedItem().equals("Margarita(8 DT)")) {
            total += 8;
        }
        if (typePizza.getSelectionModel().getSelectedItem().equals("Neptune(10 Dt)")) {
            total += 10;
        }
        if (typePizza.getSelectionModel().getSelectedItem().equals("4 Fromages (12 Dt)")) {
            total += 12;
        }
        if (Fromage.isSelected()) {
            total += 5;
        }
        if (Jambon.isSelected()) {
            total += 3;
        }
        if (Saumon.isSelected()) {
            total += 8;
        }
        if (Coupon.getText() != "") {
            try {
                this.coup = Integer.parseInt(Coupon.getText());
                if (total > coup) {
                    total = total - coup;
                }
            } catch (Exception e) {
                Alert AlertBox = new Alert(Alert.AlertType.ERROR);
                AlertBox.setTitle("Erreur de coupon");
                AlertBox.setContentText("saisir un nbr");
                AlertBox.show();
            }
        }

        prix.setText("" + total);
    }

}