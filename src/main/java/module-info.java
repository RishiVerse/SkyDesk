module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;


    opens com.example.JDeskUI to javafx.fxml;
    exports com.example.JDeskUI;

}