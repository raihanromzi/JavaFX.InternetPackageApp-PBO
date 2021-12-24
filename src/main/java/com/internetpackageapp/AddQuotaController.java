package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddQuotaController implements Initializable {

    @FXML
    private JFXButton backOnAddQuotaButton;

    @FXML
    private JFXButton buy10GBButton;

    @FXML
    private JFXButton buy1GBButton;

    @FXML
    private JFXButton buy20GBButton;

    @FXML
    private JFXButton buy5GBButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backOnAddQuotaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Home.fxml", "Home",null,null,null);
            }
        });

        buy1GBButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Payment1GB.fxml", "Payment 1 GB", null, null, null);
            }
        });

        buy5GBButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Payment5GB.fxml", "Payment 5 GB", null, null, null);
            }
        });

        buy10GBButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Payment10GB.fxml", "Payment 10 GB", null, null, null);
            }
        });

        buy20GBButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Payment20GB.fxml", "Payment 20 GB", null, null, null);
            }
        });
    }
}
