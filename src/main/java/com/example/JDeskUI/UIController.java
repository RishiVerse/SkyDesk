package com.example.JDeskUI;

import JDeskWorking.RegisterForm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;


public class UIController {

    @FXML
    private TextField NameField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField EmailField;
    @FXML
    private Label NameLabel;
    @FXML
    private Label PasswordLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Button AlreadyClick;
    @FXML
    private Button RegisterClick;
    @FXML
    private Button SignButton;
    @FXML
    private Label Logo;
    @FXML
    private TextField LoginUsernameField;
    @FXML
    private TextField LoginPasswordField;
  //  private ListView<String> ObservableList;
    @FXML
    private ListView<String> RecentList;
    @FXML
    private ToggleButton libraryid;

   // ObservableList<String> list= FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");

    private ObservableList<String> items = FXCollections.observableArrayList("item1","item2");




    @FXML    // When user clicks on Sign Button
    public void SignClicked(ActionEvent event) throws Exception
    {
//    {  Stage stage=new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(ProgramStart.class.getResource("RegisterUI.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1500, 900);
//        stage.setTitle("JDesk");
//        stage.setScene(scene);
//        stage.show();

// The current scene becomes stage and other becomes scene
        Parent root = FXMLLoader.load (getClass().getResource("RegisterUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML  // When User wants to register it calls RegisterForm function
    public void RegisterButton(ActionEvent event) throws Exception
    {
        RegisterForm register= new RegisterForm();
       // register.Register(NameField.getText(),EmailField.getText(),PasswordField.getText());
        register.data(NameField.getText(),EmailField.getText(),PasswordField.getText());
       // Stage stage=new Stage();
        Parent root = FXMLLoader.load (getClass().getResource("SuccessMessageUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
       // FXMLLoader fxmlLoader = new FXMLLoader(ProgramStart.class.getResource("SuccessMessageUI.fxml"));
      //  Scene scene = new Scene(fxmlLoader.load(), 1500, 900);
        stage.setTitle("JDesk");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void ContinueButton(ActionEvent event) throws Exception
    {
        Parent root = FXMLLoader.load (getClass().getResource("LogoUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
@FXML
    public void LogInButtonClicked(ActionEvent event) throws IOException {
    System.out.println(LoginUsernameField.getText()+" "+RegisterForm.userData.get(0)+" "+LoginPasswordField.getText()+" "+RegisterForm.userData.get(2));
    if(Objects.equals(LoginUsernameField.getText(), RegisterForm.userData.get(0)) && Objects.equals(LoginPasswordField.getText(), RegisterForm.userData.get(2))) {
        System.out.println("Sign in successful");

        Parent root = FXMLLoader.load (getClass().getResource("LibraryViewUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();

    }else
        System.out.println("sign in failed");

}


    @FXML
    public void SignInButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load (getClass().getResource("LogInUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
      //  ListView<String> list = new ListView<String>();


    }

    @FXML
    public void LibraryClicked()
    {
        libraryid.setSelected(false);
        RecentList.getItems().addAll(items);


    }



}