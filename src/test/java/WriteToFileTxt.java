
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * This class writes to file results1.txt
 * It will write test ID number + date signature
 * This class used when the DB is unavailable
 */

    public class WriteToFileTxt {

        public static void writeToFile(){

            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// Datetime Mysql format
                Date date = new Date();


                File logFile=new File("C:\\Users\\Misha\\Downloads\\results1.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
                writer.newLine();
                //writer.write (TestManagerPom_Main.testID + ":  " + Instant.now().toString().replaceAll("[TZ]", " ") + "\n");
                writer.write (TestManagerPom_Main.testID + ":  " + dateFormat.format(date) + "\n");
                writer.newLine();
                writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


