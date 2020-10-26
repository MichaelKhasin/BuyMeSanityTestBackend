
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Instant;

    public class WriteToFile {

        public static void writeToFile(){

            try {
                File logFile=new File("C:\\Users\\Misha\\Downloads\\results1.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
                writer.newLine();
                writer.write (TestManagerPom_Main.testID + ":  " + Instant.now().toString() + "\n");
                writer.newLine();
                writer.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


