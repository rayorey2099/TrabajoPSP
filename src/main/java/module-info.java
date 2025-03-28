module com.example.trabajopsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;


    opens com.example.trabajopsp to javafx.fxml;
    exports com.example.trabajopsp;
}