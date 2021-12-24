package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private JFXButton registerOnLoginButton;

    @FXML
    private JFXButton signInButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!phoneNumberTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty()){
                    Database.logInUser(event, phoneNumberTextField.getText(), passwordTextField.getText());
                } else {
                    System.out.println("Please fill Phone Number & Password!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill Phone Number & Password!");
                    alert.show();
                }
            }
        });

        registerOnLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Register.fxml", "Register!", null,null,null);
            }
        });

    }
}
