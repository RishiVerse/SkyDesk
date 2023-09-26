module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.JDesk to javafx.fxml;
    exports com.example.JDesk;
}