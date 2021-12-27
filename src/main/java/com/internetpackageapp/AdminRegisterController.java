package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminRegisterController implements Initializable {

    @FXML
    private JFXButton backOnRegisterButton;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private JFXButton registerButton;

    @FXML
    private TextField usernameTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backOnRegisterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Admin_Login.fxml", "Admin", null, null, null);
            }
        });

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!usernameTextField.getText().trim().isEmpty() && !passwordTextField.getText().trim().isEmpty()
                        && !fullNameTextField.getText().trim().isEmpty()){
                    Database.RegisterAdmin(event, fullNameTextField.getText(), usernameTextField.getText(), passwordTextField.getText());
                } else {
                    System.out.println("Please fill All information!");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill All information!");
                    alert.show();
                }
            }
        });
    }
}