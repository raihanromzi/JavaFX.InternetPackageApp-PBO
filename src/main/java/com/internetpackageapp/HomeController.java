package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private JFXButton LogOutButton;

    @FXML
    private Label PhoneNumberLabel;

    @FXML
    private JFXButton addQuotaButton;

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label QuotaLabel;

    @FXML
    private JFXButton refreshQuotaButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        LogOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Login.fxml", "Log in!", null, null, null);
            }
        });

        addQuotaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event,"AddQuota.fxml", "Add Quota!", null, null, null);
            }
        });
    }

    public void setUserInformation(String full_name, String phone_number, Integer kuota) {
        fullNameLabel.setText(full_name);
        PhoneNumberLabel.setText(phone_number);
        QuotaLabel.setText(kuota + "GB");
    }

}
