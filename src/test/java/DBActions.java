import com.mysql.cj.exceptions.UnableToConnectException;
import com.mysql.cj.exceptions.WrongArgumentException;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DB actions class
 * Actions like select, update
 */

public class DBActions {
    private static Connection con;

    public DBActions() throws Exception {
        //this.con = DBSingleton.getDBConnectionInstance();
    }


    // Function for browser selection from DB "config" table
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

    // Function writing the test results to DB "results" table. Date is varchar
    // In case DB is unavailable, write testing results to file results.txt
    public static void writeTestResultsToDB_Results_table(int testID) throws Exception {
        con = DBSingleton.getDBConnectionInstance();
        String statementToExecute;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Datetime Mysql format
            java.util.Date date = new Date();

            // Update results table
            statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results` SET `test_id`='"+testID+"' WHERE `test_id`='"+testID+"';";
            con.createStatement().executeUpdate(statementToExecute);
            statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results` SET `test_date`='"+dateFormat.format(date)+"' WHERE `test_id`='"+testID+"';";
            con.createStatement().executeUpdate(statementToExecute);

        } catch (SQLException | NumberFormatException | WrongArgumentException | UnableToConnectException e) { // Catch exceptions in case DB is unavailable
            e.printStackTrace();
            WriteToFileTxt.writeToFile(); // In case DB is unavailable, write to file results.txt
        }
        catch (NullPointerException e) { // Catch exceptions in case DB is unavailable
            e.printStackTrace();
            WriteToFileTxt.writeToFile(); // In case DB is unavailable, write to file results.txt
        }
    }

    // Function writing the test results to DB "results_datetime" table. Date is datetime format.
    // In case DB is unavailable, write testing results to file results.csv
    public static void writeTestResultsToDB_Results_Datetime_table(int testID) throws Exception {
        con = DBSingleton.getDBConnectionInstance();
        String statementToExecute;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // Datetime Mysql format
            java.util.Date date = new Date();

            // Update results_datetime table
            statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results_datetime` SET `test_id`='"+testID+"' WHERE `test_id`='"+testID+"';";
            con.createStatement().executeUpdate(statementToExecute);
            statementToExecute = "UPDATE `" + Constants.DATABASE_NAME + "`.`results_datetime` SET `test_date_datetime`='"+dateFormat.format(date)+"' WHERE `test_id`='"+testID+"';";
            con.createStatement().executeUpdate(statementToExecute);

        } catch (SQLException | NumberFormatException | WrongArgumentException | UnableToConnectException e) { // Catch exceptions in case DB is unavailable
            e.printStackTrace();
            WriteToFileCsv.writeToFile(); // In case DB is unavailable, write to file results.txt
        }
        catch (NullPointerException e) { // Catch exceptions in case DB is unavailable
            e.printStackTrace();
            WriteToFileCsv.writeToFile(); // In case DB is unavailable, write to file results.txt
        }
    }


}
