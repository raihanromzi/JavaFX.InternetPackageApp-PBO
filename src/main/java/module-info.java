module com.example.internetpackageapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.internetpackageapp to javafx.fxml;
    exports com.example.internetpackageapp;
}