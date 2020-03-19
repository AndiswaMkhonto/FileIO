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
    private String full_name;
    private int age;
    private String comments;
    private String name_of_the_person_who_assisted_the_visitor;
    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());


    public Visitor() {
    }

    public String getFull_name() {
        return full_name;
    }

    public int getAge() {
        return age;
    }

    public String getComments() {
        return comments;
    }

    public String getName_of_the_person_who_assisted_the_visitor() {
        return name_of_the_person_who_assisted_the_visitor;
    }
    public void save() {
        try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please enter your name:");
                full_name= sc.next().replace(" ","_");
                System.out.println("Please enter your age:");
                age = sc.nextInt();
                System.out.println("Please enter the name of the person who assisted you:");
                name_of_the_person_who_assisted_the_visitor = sc.next();
                System.out.println("Please enter any comments if you have:");
                comments = sc.next();
                File myObj = new File("visitor_" + getFull_name().toLowerCase() + ".txt");
                FileWriter myWriter = new FileWriter("visitor_" + getFull_name().toLowerCase() + ".txt");
                myWriter.write("Visitor's name is :" + getFull_name() + "\n " + "The age is :" + getAge() + "\n " + "The date of the visit is:" + LocalDate.now() + "\n " + "The time of visit is:" + LocalTime.now() + "\n " + "The name of the perso" +
                        "n who assisted the visitor is " + getName_of_the_person_who_assisted_the_visitor() + "\n " + "Comments:" + getComments());
                myWriter.close();

                logger.debug("Successfully wrote to the file.");

                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    logger.error("File already exists.");
                }


        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public void load(String name){
        try {

            File myObj = new File("visitor_" +name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
               logger.info(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
           logger.error("An error occurred.");
            e.printStackTrace();
        }
    }

}
