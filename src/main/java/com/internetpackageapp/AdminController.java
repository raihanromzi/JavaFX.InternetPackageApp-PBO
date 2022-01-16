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
import javafx.scene.input.MouseEvent;

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
    private JFXButton clearButton;

    @FXML
    private Label adminNameLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showUsers();

        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() == insertButton){
                    insertRecord();
                }
            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() == updateButton) {
                    updateRecord();
                }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() == deleteButton){
                    deleteRecord();
                }
            }
        });

        LogOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Database.changeScene(event, "Admin_Login.fxml", "Admin", null, null, null);
            }
        });

        userTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Users users = userTableView.getSelectionModel().getSelectedItem();
                idTextField.setText("" + users.getUser_id());
                fullNameTextField.setText("" + users.getFull_name());
                addressTextField.setText("" + users.getAddress());
                phoneNumberTextField.setText("" + users.getPhone_number());
                passwordTextField.setText("" + users.getPassword());
                kuotaTextField.setText("" + users.getKuota());
            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                idTextField.setText("");
                fullNameTextField.setText("");
                addressTextField.setText("");
                phoneNumberTextField.setText("");
                passwordTextField.setText("");
                kuotaTextField.setText("");

            }
        });
    }

    public Connection getConnection() {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/InternetPackageDB", "root", "");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Show data to table
    public ObservableList<Users> getUsersList() {
        ObservableList<Users> usersList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM users";

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            Users users;

            while (resultSet.next()) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    // Insert new data to database
    private void insertRecord() {
        String query = "INSERT INTO users VALUES (" + idTextField.getText() + ",'" + fullNameTextField.getText() + "','" + addressTextField.getText() + "'," +
                                                    phoneNumberTextField.getText() + "," + passwordTextField.getText() + "," + kuotaTextField.getText() + ")";
        executeQuery(query);
        showUsers();
    }

    private void updateRecord() {
        String query = "UPDATE users SET full_name = '" + fullNameTextField.getText() + "', address = '" + addressTextField.getText() + "', phone_number = '" + phoneNumberTextField.getText()
                + "', password = '" + passwordTextField.getText() + "', kuota = '" + kuotaTextField.getText() + "' WHERE user_id = " + idTextField.getText() + "";
        executeQuery(query);
        showUsers();
    }

    private void deleteRecord() {
        String query = "DELETE FROM users WHERE user_id = " + idTextField.getText() + "";
        executeQuery(query);
        showUsers();
    }

    private void executeQuery(String query) {
        Connection connection = getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showUsers() {
        ObservableList<Users> list = getUsersList();

        idCol.setCellValueFactory(new PropertyValueFactory<Users, Integer>("user_id"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Users, String>("address"));
        fullNameCol.setCellValueFactory(new PropertyValueFactory<Users, String>("full_name"));
        kuotaCol.setCellValueFactory(new PropertyValueFactory<Users, Integer>("kuota"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Users, String>("phone_number"));

        userTableView.setItems(list);
    }

    public void setAdminInformation(String username) {
        adminNameLabel.setText(username);
    }
}
