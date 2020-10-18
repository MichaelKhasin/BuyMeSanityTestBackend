import org.openqa.selenium.WebDriver;

import java.sql.*;

public class DBActions {
    private static Connection con;

    public DBActions() throws Exception {
        this.con = DBSingleton.getDBConnectionInstance();
    }


    public static String selectBrowser() throws SQLException {
        String statementToExecute = "SELECT data FROM " + Constants.DATABASE_NAME + ".`config` WHERE `name`='BROWSER';";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        ResultSet rs = stmt.executeQuery(statementToExecute);
        String browserName = null;
        while(rs.next()) {
            browserName = rs.getString("data");
        }
        rs.close();
        con.close();
        return browserName;

    }
}
