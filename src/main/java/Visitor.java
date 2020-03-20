import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Visitor {
private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    //creating and writing inside the file
    public static String save(String fullName, int age, String dateOfVisit, String timeOfVisit, String comments, String nameOfAssistor) {
        try {
            String full_Name = fullName.replace(" ", "_");      //replacing spaces with underscore
            FileWriter fileWriter = new FileWriter("visitor_" + full_Name.toLowerCase() + ".txt");
            fileWriter.write(fullName + " \n" + age + " \n" + dateOfVisit + " \n" + timeOfVisit + " \n" + comments + " \n" + nameOfAssistor);
            fileWriter.close();
            logger.info("file created");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return "File created";
    }
   //constructor for my Visitor class


    public static void load(String name) {
        try {

            File myObj = new File("visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String andi = myReader.nextLine();
                logger.info(andi);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }
    }
}
