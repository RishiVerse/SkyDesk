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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
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
    @FXML
    private ImageView mypane;

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


                //    System.out.println(name1 + "  " + name2 + "  " + password);

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

    }

    @FXML
    public void OpenDocument(ActionEvent event) throws SQLException, IOException {
        User u = TableScene.getSelectionModel().getSelectedItem();
        ResultSet r = DatabaseMethods.openDB("select * from pdf_documents where filename='" + u.getTitle() + "'", "open");
        String s = r.getString("filename");
        System.out.println(s);
//        String fxml = "ImageView.fxml";
//        FXMLLoader loader = FXMLLoader.load(getClass().getResource(fxml));
//        Parent root = loader.load(); // Load the FXML file and obtain the root node.
//
//// Create a new scene using the root node.
//        Scene scene = new Scene(root);
//
//// Get the primary stage and set the scene to display it.
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();


//        Blob b = r.getBlob("pdf_data");
//        InputStream is = b.getBinaryStream();
//        Image image = new Image(is);
//        mypane.setImage(image);
//        DatabaseMethods.openDB(null, "close");
    }
}