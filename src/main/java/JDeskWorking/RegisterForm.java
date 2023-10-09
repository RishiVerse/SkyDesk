package JDeskWorking;
import java.util.ArrayList;

public class RegisterForm {

    public static ArrayList  <String> userData=new ArrayList<>();


    public void data(String name,String mail,String password)  {

        userData.add(name);
        userData.add(mail);
        userData.add(password);

    }


}
