package com.example.todolist;

import com.example.todolist.datamodel.toDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    private List<toDoItem> items;
    @FXML
    private TextArea list1;
    //  private ListView<TodoItem> todoListView;
    @FXML
    private TextField AddInput;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private TextArea DisplayToday;
    private String ch;
    @FXML
    private ListView<String> ItemList;
    @FXML
    private TextField AddInput1;
    @FXML
    private TextArea ReminderArea;
    @FXML
    private Button AddNow;
    @FXML
    private Button AddReminder;


    public void initialize() {
ReminderArea.setVisible(false);
        AddNow.setVisible(false);
        AddReminder.setVisible(false);
AddInput.setVisible(false);
AddInput1.setVisible(false);

    }


    @FXML
    public void ClickedToday()
    { AddNow.setVisible(true);
        AddInput.setVisible(true);
        list1.setText("First list");
    }
    @FXML
    public void ClickedNotes()
    {
        list1.setText("Second list");
    }

@FXML
    public void ClickedAddNow()
    {
        ch=AddInput.getCharacters().toString();

        ItemList.getItems().add(ch);
    }
@FXML
    public void ClickedAddReminder()

    {
        ch= AddInput1.getText();
        ReminderArea.setText(ch);

    }

    @FXML
    public void ClickedAddTask()
    {
        AddInput1.setVisible(true);
        AddReminder.setVisible(true);
        ReminderArea.setVisible(true);
    }

}