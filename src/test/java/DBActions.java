import org.openqa.selenium.WebDriver;

import java.sql.*;
import java.time.Instant;

public class DBActions {
    private static Connection con;

    public DBActions() throws Exception {
        //this.con = DBSingleton.getDBConnectionInstance();
    }


    public static String selectBrowser() throws Exception {
        con = DBSingleton.getDBConnectionInstance();
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
        //con.close();
        return browserName;
    }

    public static void writeTestRunResultsToDB(int testID) throws Exception {
        con = DBSingleton.getDBConnectionInstance();
        String statementToExecute;
        statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results` SET `test_id`='"+testID+"' WHERE `test_id`='1';";
        con.createStatement().executeUpdate(statementToExecute);
        statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results` SET `test_date`='"+Instant.now().toString()+"' WHERE `test_id`='"+testID+"';";
        con.createStatement().executeUpdate(statementToExecute);


//        String statementToExecute = "SELECT data FROM " + Constants.DATABASE_NAME + ".`config` WHERE `name`='BROWSER';";
//        Statement stmt = null;
//        try {
//            stmt = con.createStatement();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        ResultSet rs = stmt.executeQuery(statementToExecute);
//        String browserName = null;
//        while(rs.next()) {
//            browserName = rs.getString("data");
//        }
        //con.close();

    }

}
