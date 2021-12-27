package com.internetpackageapp;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField kuotaTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TableView<Users> userTableView;

    @FXML
    private TableColumn<Users, String> addressCol;

    @FXML
    private TableColumn<Users, Integer> idCol;

    @FXML
    private TableColumn<Users, String> fullNameCol;

    @FXML
    private TableColumn<Users, Integer> kuotaCol;

    @FXML
    private TableColumn<Users, String> passwordCol;

    @FXML
    private TableColumn<Users, String> phoneNumberCol;

    @FXML
    private JFXButton LogOutButton;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton insertButton;

    @FXML
    private JFXButton updateButton;

    @FXML
    private Label adminNameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showUsers();

        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        LogOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Admin_Login.fxml", "Admin", null, null, null);
            }
        });
    }

    public Connection getConnection() {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quotaApp", "root", "Rr290903123@");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Users> getUsersList(){
        ObservableList<Users> usersList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM users";

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Users users;

            while (resultSet.next()){
                users = new Users(
                        resultSet.getInt("user_id"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("password"),
                        resultSet.getInt("kuota"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address")
                );

                usersList.add(users);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return usersList;
    }

    public void showUsers(){
        ObservableList<Users> list = getUsersList();

        idCol.setCellValueFactory(new PropertyValueFactory<Users, Integer>("user_id"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Users, String>("address"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<Users, String>("full_name"));
        kuotaCol.setCellValueFactory(new PropertyValueFactory<Users, Integer>("kuota"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Users, String>("phone_number"));

        userTableView.setItems(list);
    }

    public void setAdminInformation(String username){
        adminNameLabel.setText(username);
    }
}
