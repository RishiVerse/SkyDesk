package com.example.JDeskUI;

import JDeskWorking.DatabaseMethods;
import JDeskWorking.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LibraryViewController implements Initializable {

    @FXML
    private TableView<User> TableScene;
    @FXML
    private TableColumn<User, String> TitleColumn;
    @FXML
    private TableColumn<User, String> AuthorColumn;
    @FXML
    private TableColumn<User, String> RecentColumn;
    @FXML
    private WebView webview;

    ObservableList<User> lst = FXCollections.observableArrayList(new User("rich dad poor dad", "robert", "today")
            , new User("rich dad poor dad", "robert", "today"));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            ResultSet r = DatabaseMethods.openDB("select * from pdf_documents", "open");

            while (r.next()) {
                String name1 = r.getString("filename");
                String name2 = r.getString("filename");
                String password = r.getString("description");
                User newUser = new User(name1, name2, password);
                lst.add(newUser);


                System.out.println(name1 + "  " + name2 + "  " + password);

            }
            DatabaseMethods.openDB(null, "close");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        TitleColumn.setCellValueFactory(new PropertyValueFactory<User, String>("title"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<User, String>("author"));
        RecentColumn.setCellValueFactory(new PropertyValueFactory<User, String>("recent"));
        TableScene.setItems(lst);


    }

    @FXML
    public void LibraryClicked(ActionEvent event) throws IOException, InterruptedException {

        Stage stage = new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
        WebView webview = new WebView();
        BorderPane.setMargin(webview, new Insets(10));
        root.setCenter(webview);
        WebEngine webengine = webview.getEngine();
        webengine.load("https://www.google.com");
        User u = TableScene.getSelectionModel().getSelectedItem();
        System.out.println(u.getTitle() + " " + u.getAuthor());
    }

}
