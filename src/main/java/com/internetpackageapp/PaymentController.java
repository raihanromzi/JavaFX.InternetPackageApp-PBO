package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML
    private JFXButton backPaymentButton;

    @FXML
    private JFXButton confirmPayment1GBButton;

    @FXML
    private JFXButton confirmPayment5GBButton;

    @FXML
    private JFXButton confirmPayment10GBButton;

    @FXML
    private JFXButton confirmPayment20GBButton;

    @FXML
    private JFXRadioButton danaRadioButton;

    @FXML
    private JFXRadioButton gopayRadioButton;

    @FXML
    private JFXRadioButton linkajaRadioButton;

    @FXML
    private ToggleGroup metode;

    @FXML
    private JFXRadioButton ovoRadioButton;
    private HomeController homeController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backPaymentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "AddQuota.fxml", "Add Quota!", null, null, null);
            }
        });

    }

}
