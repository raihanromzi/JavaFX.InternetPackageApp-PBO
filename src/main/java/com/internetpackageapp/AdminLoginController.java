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

public class AdminLoginController implements Initializable {

    @FXML
    private JFXButton backOnLoginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private JFXButton registerOnLoginButton;

    @FXML
    private JFXButton signInButton;

    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        registerOnLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Admin_Register.fxml", "Admin", null, null, null);
            }
        });

        backOnLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Login.fxml", "Login!", null, null, null);
            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty()){
                    Database.LoginAdmin(event, usernameTextField.getText(), passwordTextField.getText());
                } else {
                    System.out.println("Please fill Phone Number & Password!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill Phone Number & Password!");
                    alert.show();
                }
            }
        });
    }
}
