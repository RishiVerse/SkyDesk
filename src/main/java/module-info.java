module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.JDeskUI to javafx.fxml;
    exports com.example.JDeskUI;
}