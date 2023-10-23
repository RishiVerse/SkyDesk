package com.example.JDeskUI;

import JDeskWorking.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LibraryViewController implements Initializable{

    @FXML
    private TableView<User> TableScene;
    @FXML
    private TableColumn<User,String> TitleColumn;
    @FXML
    private TableColumn<User,String> AuthorColumn;
    @FXML
    private TableColumn<User,String> RecentColumn;

    ObservableList<User> lst= FXCollections.observableArrayList(new User("rich dad poor dad","robert","today")
    ,new User("rich dad poor dad","robert","today"));



@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TitleColumn.setCellValueFactory(new PropertyValueFactory<User,String>("title"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<User,String>("author"));
        RecentColumn.setCellValueFactory(new PropertyValueFactory<User,String>("recent"));
        TableScene.setItems(lst);

    }

    @FXML
    public void LibraryClicked(ActionEvent event)  throws IOException, InterruptedException {
        TitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        AuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        RecentColumn.setCellValueFactory(new PropertyValueFactory<>("recent"));
        TableScene.setItems(lst);

    }


}
