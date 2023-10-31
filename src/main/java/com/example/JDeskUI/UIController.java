package com.example.JDeskUI;

import JDeskWorking.DatabaseMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


import java.io.IOException;


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
    @FXML
    private WebView webViewScene;

    private ObservableList<String> items = FXCollections.observableArrayList("item1", "item2");


    @FXML    // When user clicks on Sign Button
    public void SignClicked(ActionEvent event) throws Exception {
        String fxml = "RegisterUI.fxml";
        sceneSetting(event, fxml);
    }


    @FXML  // When User wants to register it calls RegisterForm function
    public void RegisterButton(ActionEvent event) throws Exception {

        // RegisterForm register = new RegisterForm();
        // register.Register(NameField.getText(),EmailField.getText(),PasswordField.getText());
        //  register.data(NameField.getText(), EmailField.getText(), PasswordField.getText());

        if (!DatabaseMethods.searchCredentials(NameField.getText()) && NameField.getText().length() >= 4 && PasswordField.getText().length() >= 8) {
            if (DatabaseMethods.insertCredentials(NameField.getText(), EmailField.getText(), PasswordField.getText())) {
                System.out.println("inserted data in table");
                String fxml = "SuccessMessageUI.fxml";
                sceneSetting(event, fxml);
            }
        } else {
            System.out.println("credentials already there");
            NameField.clear();
            PasswordField.clear();
            EmailField.clear();
        }
    }


    @FXML
    public void ContinueButton(ActionEvent event) throws Exception {
        String fxml = "LogoUI.fxml";
        sceneSetting(event, fxml);
    }

    @FXML
    public void LogInButtonClicked(ActionEvent event) throws IOException {

        try {

            if (DatabaseMethods.searchCredentials(LoginUsernameField.getText())) {
                System.out.println("sign in successful");
                String fxml = "LibraryViewUI.fxml";
                sceneSetting(event, fxml);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    public void SignInButton(ActionEvent event) throws IOException {
        String fxml = "LogInUI.fxml";
        sceneSetting(event, fxml);
    }

    public void sceneSetting(ActionEvent event, String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}



