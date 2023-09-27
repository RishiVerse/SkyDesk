package JDeskWorking;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class RegisterForm {

    public static ArrayList  <String> userData=new ArrayList<>();
    public void Register(String name,String mail,String password)
    {
       // System.out.println(name+" "+mail+"  "+password);
        data(name,mail,password);


    }

    public void data(String name,String mail,String password)
    {

        userData.add(name);
        userData.add(mail);
        userData.add(password);
    }


}
