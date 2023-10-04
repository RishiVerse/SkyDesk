package JDeskWorking;

import java.sql.*;

public class DatabaseMethods {

    public static boolean searchCredentials() {
        String users = RegisterForm.userData.get(0);
        String pwds = RegisterForm.userData.get(2); // Assuming the password is in the third column
        boolean flag = false;

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            Statement s = conn.createStatement();
            s.execute("select * from userDetail");
            ResultSet r = s.getResultSet();

            while (r.next()) {
                String name = r.getString("name");
                String password = r.getString("password");
                System.out.println(name+"  "+password);
                if (name != null && password != null && name.equals(users) && password.equals(pwds)) {
                    flag = true;
                    break; // No need to continue searching, we found a match
                }
            }

            s.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flag;
    }


    public static boolean insertCredentials()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            PreparedStatement preparedStatement= conn.prepareStatement("insert  into  userDetail(name,email,password)"+
                    " values(?,?,?)");

            preparedStatement.setString(1, RegisterForm.userData.get(0)); // Replace with the actual name
            preparedStatement.setString(2, RegisterForm.userData.get(1)); // Replace with the actual email
            preparedStatement.setString(3, RegisterForm.userData.get(2)); // Replace with the actual password
            preparedStatement.execute();
            preparedStatement.close();
            conn.close();

            System.out.println("insertion successful"+RegisterForm.userData.get(0)+" "+RegisterForm.userData.get(1)+" "+RegisterForm.userData.get(2));
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }




}
