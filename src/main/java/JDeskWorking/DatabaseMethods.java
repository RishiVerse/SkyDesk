package JDeskWorking;

import java.sql.*;

public class DatabaseMethods {



    public boolean searchCredentials()
    {
        String user= RegisterForm.userData.get(0);
        String mail= RegisterForm.userData.get(1);
        String pwd= RegisterForm.userData.get(2);
        boolean flag=false;
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            Statement s = conn.createStatement();
//            s.execute("create table if not exists " +
//                    " userDetail(name text,email text,password text)");
//            s.execute("insert  into  userDetail(name,email,password)"+
//                    " values(,'hello@.com',2334)");

            s.execute("select * from userDetail");
            ResultSet r=s.getResultSet();
            while(r.next())
                    {
                        if(r.getString("user").equals(user)  && r.getString("password").equals(pwd))
                        {
                            flag=true;

                        }

                    }
            s.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
       return flag;
    }


}
