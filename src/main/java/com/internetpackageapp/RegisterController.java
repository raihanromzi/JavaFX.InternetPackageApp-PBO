package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField addressTextField;

    @FXML
    private JFXButton backOnRegisterButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private PasswordField passwordRegisterTextField;

    @FXML
    private TextField phoneNumberRegisterTextField;

    @FXML
    private JFXButton registerButton;

    @FXML
    void RegisterToHome(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!addressTextField.getText().trim().isEmpty() && !fullNameTextField.getText().trim().isEmpty()
                        && !passwordRegisterTextField.getText().trim().isEmpty() && phoneNumberRegisterTextField.getText().trim().isEmpty()){
                    Database.RegisterUser(event, fullNameTextField.getText(), addressTextField.getText(), phoneNumberRegisterTextField.getText(), passwordRegisterTextField.getText(), 0);
                } else {
                    System.out.println("Please fill All the Information!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill All the Information!");
                    alert.show();
                }


            }
        });

        backOnRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event,"Login.fxml", "Log in!", null, null, null);
            }
        });
    }
}