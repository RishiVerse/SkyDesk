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


    public void data(String names,String mails,String passwords)  {

        userData.add(names);
        userData.add(mails);
        userData.add(passwords);

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            Statement s = conn.createStatement();
            s.execute("create table if not exists " +
                    " userDetail(name text,email text,password text)");
            s.execute("insert  into  userDetail(name,email,password)"+
                    "VALUES('"+names+ "', " + mails + ", '" + passwords + "')");
            s.close();
            conn.close();
            System.out.println("success");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }




    }


}
