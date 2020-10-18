import org.openqa.selenium.WebDriver;

import java.sql.*;

/**
 * DB connection instance instantiated by Singleton design pattern.
 */

public class DBSingleton {
    private static Connection con;

    public static Connection getDBConnectionInstance() throws Exception {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + Constants.SERVER + ":" + Constants.PORT, Constants.USER_NAME, Constants.PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return con;

    }
}