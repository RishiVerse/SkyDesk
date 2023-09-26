package com.example.JDesk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgramStart extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ProgramStart.class.getResource("LogoUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 900);
         stage.setTitle("JDesk");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
       // System.out.println("okay Boss");
    }
}

