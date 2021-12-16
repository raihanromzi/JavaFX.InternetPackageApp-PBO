module com.example.internetpackageapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.internetpackageapp to javafx.fxml;
    exports com.internetpackageapp;
}