package com.internetpackageapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tugas Besar PBO IF-43-08");
            stage.setResizable(false);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}