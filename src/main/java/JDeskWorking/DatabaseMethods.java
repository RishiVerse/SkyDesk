package JDeskWorking;

import java.sql.*;
import java.util.Objects;

public class DatabaseMethods {

    public static Connection conn;
    public static Statement s;

    public static ResultSet openDB(String query, String flag) throws SQLException {
        if (Objects.equals(flag, "open")) {
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            s = conn.createStatement();
            s.execute(query);
            return s.getResultSet();
        } else {
            s.close();
            conn.close();
            return null;
        }
    }


    public static boolean searchCredentials(String u) {

        boolean flag = false;

        try {
            ResultSet r = openDB("select * from userDetail", "open");

            while (true) {
                assert r != null;
                if (!r.next()) break;
                String name = r.getString("name");
                //String password = r.getString("password");
                // System.out.println(name + "  " + password);
                if (name != null && name.equals(u)) {
                    flag = true;
                    break; // No need to continue searching, we found a match
                }
            }

            openDB(null, "close");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return flag;
    }


    public static boolean insertCredentials(String NameField, String EmailField, String PasswordField) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/rishabhmaurya/Documents/SkyDesk/src/main/java/com/example/JDeskUI/userDetail.db");
            PreparedStatement preparedStatement = conn.prepareStatement("insert  into  userDetail(name,email,password)" +
                    " values(?,?,?)");

            preparedStatement.setString(1, NameField); // Replace with the actual name
            preparedStatement.setString(2, EmailField); // Replace with the actual email
            preparedStatement.setString(3, PasswordField); // Replace with the actual password
            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
