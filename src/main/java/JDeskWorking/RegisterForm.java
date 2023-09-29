package JDeskWorking;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RegisterForm {

    public static ArrayList  <String> userData=new ArrayList<>();


    public void data(String name,String mail,String password)  {



        userData.add(name);
        userData.add(mail);
        userData.add(password);
    }


}
