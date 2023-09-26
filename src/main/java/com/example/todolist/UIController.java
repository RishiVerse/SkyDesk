package com.example.todolist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

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



public void initialize()
{
//    NameField.setVisible(false);
//    PasswordField.setVisible(false);
//    EmailField.setVisible(false);
//    EmailLabel.setVisible(false);
//    PasswordLabel.setVisible(false);
//    NameLabel.setVisible(false);
//    AlreadyClick.setVisible(false);
//    RegisterClick.setVisible(false);

}

@FXML
public void SignClicked()
{
    Logo.setVisible(false);
    SignButton.setVisible(false);
    NameField.setVisible(true);
    PasswordField.setVisible(true);
    EmailField.setVisible(true);
    EmailLabel.setVisible(true);
    PasswordLabel.setVisible(true);
    NameLabel.setVisible(true);
    AlreadyClick.setVisible(true);
    RegisterClick.setVisible(true);



}



}