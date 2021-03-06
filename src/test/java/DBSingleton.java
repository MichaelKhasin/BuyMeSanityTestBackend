import org.openqa.selenium.WebDriver;

import java.sql.*;

/**
 * DB connection instance instantiated by Singleton design pattern.
 */

public class DBSingleton {
    public static Connection con;

    public static Connection getDBConnectionInstance()  {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + Constants.SERVER + ":" + Constants.PORT, Constants.USER_NAME, Constants.PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException e) {
                e.printStackTrace();
            }

        }
        return con;

    }
}