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

import java.io.ByteArrayInputStream;
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
    private ImageView pdffile;

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

       
        WebEngine webengine = webview.getEngine();
        webengine.load("https://www.google.com");

    }


    @FXML
    public void OpenDocument(ActionEvent event) throws SQLException, IOException {
        User u = TableScene.getSelectionModel().getSelectedItem();

        // Establish a database connection
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
        Statement s = conn.createStatement();

        // Execute the SQL query to retrieve the image data
        ResultSet resultSet = s.executeQuery("SELECT pdf_data FROM pdf_documents WHERE filename = '" + u.getTitle() + "'");

        if (resultSet.next()) {
            // Get the image data from the result set
            byte[] imageData = resultSet.getBytes("pdf_data");
            InputStream imageStream = new ByteArrayInputStream(imageData);

            // Create an Image object from the image data
            Image image = new Image(imageStream);

            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryViewUI.fxml"));
            Parent root = loader.load();

            // Access the ImageView in the new scene and set the image
            //ImageView pdffiles = (ImageView) root.lookup("pdffile"); // Replace with the correct ID
            pdffile.setImage(image);

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            // Show the new stage
            stage.show();
        }

        // Close resources

        s.close();
        conn.close();
    }

}