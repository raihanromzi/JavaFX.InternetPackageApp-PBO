package com.internetpackageapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class Database {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String full_name, String phone_number, Integer kuota) {

        Parent root = null;

        if (full_name != null && phone_number != null && kuota != null) {
            try {
                FXMLLoader loader = new FXMLLoader(Database.class.getResource(fxmlFile));
                root = loader.load();
                HomeController homeController = loader.getController();
                homeController.setUserInformation(full_name, phone_number, kuota);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(Database.class.getResource(fxmlFile)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        assert root != null;
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public static void RegisterUser(ActionEvent event, String full_name, String address, String phone_number, String password, Integer kuota) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/InternetPackageDB", "root", "");
            psCheckUserExist = connection.prepareStatement("SELECT * FROM users WHERE phone_number = ?");
            psCheckUserExist.setString(1, phone_number);
            resultSet = psCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("Phone Number Already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You Can't Use This Phone Number");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (full_name, address, phone_number, password, kuota) VALUES (?, ?, ?, ?, ?)");
                psInsert.setString(1, full_name);
                psInsert.setString(2, address);
                psInsert.setString(3, phone_number);
                psInsert.setString(4, password);
                psInsert.setInt(5, kuota);
                psInsert.executeUpdate();

                changeScene(event, "Home.fxml", "Welcome!", full_name, phone_number, kuota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psCheckUserExist != null) {

                try {
                    psCheckUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psInsert != null) {

                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String phone_number, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/InternetPackageDB", "root", "");
            preparedStatement = connection.prepareStatement("SELECT full_name, phone_number, password, kuota FROM users WHERE phone_number = ?");
            preparedStatement.setString(1, phone_number);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Phone Number not found!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Phone Number!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedFullName = resultSet.getString("full_name");
                    int retrievedKuota = resultSet.getInt("kuota");

                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "Home.fxml", "Welcome!", retrievedFullName, phone_number, retrievedKuota);
                    } else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Incorrect Password!");
                        alert.show();
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void changeSceneAdmin(ActionEvent event, String fxmlFile, String title, String username) {

        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(Database.class.getResource(fxmlFile));
                root = loader.load();
                AdminController adminController = loader.getController();
                adminController.setAdminInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(Objects.requireNonNull(Database.class.getResource(fxmlFile)));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        assert root != null;
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public static void RegisterAdmin(ActionEvent event, String full_name, String username, String password) {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/InternetPackageDB", "root", "");
            psCheckUserExist = connection.prepareStatement("SELECT * FROM admin WHERE username = ?");
            psCheckUserExist.setString(1, username);
            resultSet = psCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("Username already Exist");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You Can't Use This username");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO admin (full_name, username, password) VALUES (?, ?, ?)");
                psInsert.setString(1, full_name);
                psInsert.setString(2, username);
                psInsert.setString(3, password);
                psInsert.executeUpdate();

                changeSceneAdmin(event, "Admin_Controller.fxml", "Admin Home!", username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psCheckUserExist != null) {

                try {
                    psCheckUserExist.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (psInsert != null) {

                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void LoginAdmin(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:33061/InternetPackageDB", "root", "");
            preparedStatement = connection.prepareStatement("SELECT full_name, username, password FROM admin WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Username not found!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect username!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");

                    if (retrievedPassword.equals(password)) {
                        changeSceneAdmin(event, "Admin_Controller.fxml", "Welcome!", username);
                    } else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Incorrect Password!");
                        alert.show();
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
