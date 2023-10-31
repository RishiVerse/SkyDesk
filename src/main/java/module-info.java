module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.web;
    requires org.apache.pdfbox;
    requires java.desktop;


    opens com.example.JDeskUI to javafx.fxml;
    exports com.example.JDeskUI;
    opens JDeskWorking to javafx.base;


}