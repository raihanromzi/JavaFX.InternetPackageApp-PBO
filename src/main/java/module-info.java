module com.example.internetpackageapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.internetpackageapp to javafx.fxml;
    exports com.internetpackageapp;
}