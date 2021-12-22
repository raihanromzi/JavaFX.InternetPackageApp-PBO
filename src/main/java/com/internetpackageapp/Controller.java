package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Controller {

    @FXML
    private JFXButton signInButton, registerButton, addQuotaButton, buy10GBHomeButton, buy20GBHomeButton, refreshQuotaButton,
            backOnAddQuotaButton, buy10GBButton, buy1GBButton, buy20GBButton, buy5GBButton, backPaymentButton, confirmPayment1GBButton,
            confirmPayment5GBButton, confirmPayment10GBButton, confirmPayment20GBButton, backToHomeButton, registerOnLoginButton,
            backOnRegisterButton;

    @FXML
    private PasswordField passwordTextField, passwordRegisterTextField;

    @FXML
    private TextField phoneNumberTextField, fullNameTextField, addressTextField, phoneNumberRegisterTextField;

    @FXML
    private Label registerLabel, jumlahKuotaLabel, masaAktifLabel, smsLabel, teleponLabel, loginStatusLabel, PhoneNumberLabel;

    @FXML
    private JFXRadioButton linkajaRadioButton, gopayRadioButton, danaRadioButton, ovoRadioButton;

    public void LoginButtonOnAction(ActionEvent event) throws IOException {
//        loginStatusLabel.setText("Please Enter Correctly");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage window = (Stage) signInButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void LoginToRegister() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));
        Stage window = (Stage) registerOnLoginButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void RegisterToHome() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void RegisterToLogin() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
        Stage window = (Stage) backOnRegisterButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void HomeToAddQuota() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddQuota.fxml")));
        Stage window = (Stage) addQuotaButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void HomePromo10GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment10GB.fxml")));
        Stage window = (Stage) buy10GBHomeButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void HomePromo20GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment20GB.fxml")));
        Stage window = (Stage) buy20GBHomeButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void AddQuotaToHome() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage window = (Stage) backOnAddQuotaButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void AddQuota1GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment1GB.fxml")));
        Stage window = (Stage) buy1GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void AddQuota5GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment5GB.fxml")));
        Stage window = (Stage) buy5GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void AddQuota10GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment10GB.fxml")));
        Stage window = (Stage) buy10GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void AddQuota20GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Payment20GB.fxml")));
        Stage window = (Stage) buy20GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void PaymentToAddQuota() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddQuota.fxml")));
        Stage window = (Stage) backPaymentButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void ConfirmPayment1GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ThankYou.fxml")));
        Stage window = (Stage) confirmPayment1GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void ConfirmPayment5GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ThankYou.fxml")));
        Stage window = (Stage) confirmPayment5GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void ConfirmPayment10GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ThankYou.fxml")));
        Stage window = (Stage) confirmPayment10GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void ConfirmPayment20GB() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ThankYou.fxml")));
        Stage window = (Stage) confirmPayment20GBButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }

    public void ThankYouToHome() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        Stage window = (Stage) backToHomeButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 500));
    }


}
