module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.JDeskUI to javafx.fxml;
    exports com.example.JDeskUI;
}