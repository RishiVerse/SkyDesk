package com.example.JDeskUI;

import JDeskWorking.DatabaseMethods;
import JDeskWorking.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
    private TextArea textarea;

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


        User u = TableScene.getSelectionModel().getSelectedItem();

    }

    @FXML
    public void LibraryClicked(ActionEvent event) throws IOException, InterruptedException {

        webview.setVisible(true);
        textarea.setVisible(false);
        WebEngine webengine = webview.getEngine();
        webengine.load("https://www.google.com");

    }

    @FXML
    public void OpenDocument(ActionEvent event) throws SQLException, IOException {
        webview.setVisible(false);
        textarea.setVisible(true);


        User u = TableScene.getSelectionModel().getSelectedItem();

        // Establish a database connection and retrieve the PDF data
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
        Statement s = conn.createStatement();
        ResultSet resultSet = s.executeQuery("SELECT pdf_data FROM pdf_documents WHERE filename = '" + u.getTitle() + "'");

        if (resultSet.next()) {
            byte[] pdfData = resultSet.getBytes("pdf_data");

            // Extract text from the PDF data
            String text = extractTextFromPdf(pdfData);

            // Display the extracted text in the TextArea
            // copypdffile.setText(text);
            System.out.println(text);
            textarea.setText(text);


        } else {
            System.out.println("Error in input data");
        }
    }


    private String extractTextFromPdf(byte[] pdfData) throws IOException {
        try (PDDocument document = PDDocument.load(new ByteArrayInputStream(pdfData))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}
