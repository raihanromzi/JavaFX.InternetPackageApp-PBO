package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // Login
    @FXML
    private JFXButton signInButton;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private Label registerLabel;

    // Register
    @FXML
    private JFXButton registerButton;
    @FXML
    private PasswordField passwordRegisterTextField;
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumberRegisterTextField;

    // Home
    @FXML
    private JFXButton addQuotaButton;
    @FXML
    private JFXButton buy10GBHomeButton;
    @FXML
    private JFXButton buy20GBHomeButton;
    @FXML
    private JFXButton refreshQuotaButton;

    // AddQuota
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXButton buy10GBButton;
    @FXML
    private JFXButton buy1GBButton;
    @FXML
    private JFXButton buy20GBButton;
    @FXML
    private JFXButton buy5GBButton;

    // Payment
    @FXML
    private JFXButton backPaymentButton;
    @FXML
    private JFXButton confirmPaymentButton;
    @FXML
    private Label jumlahKuotaLabel;
    @FXML
    private Label masaAktifLabel;
    @FXML
    private ChoiceBox<?> metodePembayaranChoiceBox;
    @FXML
    private Label smsLabel;
    @FXML
    private Label teleponLabel;

    // ThankYou
    @FXML
    private JFXButton backToHomeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void switchToRegister(ActionEvent event) throws IOException {

    }
}
