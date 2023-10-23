package com.example.JDeskUI;

import JDeskWorking.DatabaseMethods;
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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;


public class UIController  {

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
    @FXML
    private WebView webViewScene;

   // ObservableList<String> list= FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");

    private ObservableList<String> items = FXCollections.observableArrayList("item1","item2");


//    public void initialize(URL location, ResourceBundle resources) {
//        WebEngine webEngine = webViewScene.getEngine();
//
//        // Load a PDF file using WebView
//        webEngine.load(getClass().getResource("src/main/java/com/example/JDeskUI/leph1an.pdf").toExternalForm());
//    }

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

    if(!DatabaseMethods.searchCredentials(RegisterForm.userData.get(0),RegisterForm.userData.get(1)) && NameField.getText().length()>=4 && PasswordField.getText().length()>=8) {
    if (DatabaseMethods.insertCredentials()) {
        System.out.println("inserted data in table");
        // Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SuccessMessageUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        // FXMLLoader fxmlLoader = new FXMLLoader(ProgramStart.class.getResource("SuccessMessageUI.fxml"));
        //  Scene scene = new Scene(fxmlLoader.load(), 1500, 900);
        stage.setTitle("JDesk");
        stage.setScene(scene);
        stage.show();

    }
}else
            {
                System.out.println("credentials already there");
                NameField.clear();
                PasswordField.clear();
                EmailField.clear();
        }}




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
//    System.out.println(LoginUsernameField.getText()+" "+RegisterForm.userData.get(0)+" "+LoginPasswordField.getText()+" "+RegisterForm.userData.get(2));
//    if(Objects.equals(LoginUsernameField.getText(), RegisterForm.userData.get(0)) && Objects.equals(LoginPasswordField.getText(), RegisterForm.userData.get(2))) {

try {

    if (DatabaseMethods.searchCredentials(LoginUsernameField.getText(), LoginPasswordField.getText())) {
        System.out.println(LoginPasswordField+"  "+LoginUsernameField);
        System.out.println("sign in successful");
        Parent root = FXMLLoader.load(getClass().getResource("LibraryViewUI.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }


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
    public void TestClicked()
    {


       // WebView webView = new WebView();
        WebEngine webEngine = webViewScene.getEngine();
        String pdfUrl = ":/Users/rishabhmaurya/Documents/SkyDesk/src/main/resources/testfile.pdf";
        System.out.println("PDF URL: " + pdfUrl);
        webEngine.load(pdfUrl);
    }

    }



