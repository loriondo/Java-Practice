/*
 */

package gpacalculator;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Work in progress.
 * Keeping track of one's GPA is a rather important thing to do.
 * Reminds you of where you are as far as grades go and it keeps 
 * my sanity in check sometimes. 
 * 
 * The old gpa calculator I used on the the university Oasis website
 * no longer works, and rather than searching through Google to find
 * one that is accurate, why not create one of my own?
 * 
 * It's fairly simple, but it gives me the chance to fool around with
 * some Java 8 while also making something that not only I can use, but
 * to pass along to some friends not in the CSCI program who miss the old
 * GPA calculator.
 * 
 * @author Lou
 */
public class GPACalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Calculator calc = new Calculator();
       ArrayList<Grade> courseGrades = new ArrayList<Grade>();
       Scanner scanner = new Scanner(System.in);
       
       int options;
       out.println("Press 1 to read in a file with your grades.");
       out.println("Otherwise, press 2 to input information manually.");
       if((options = scanner.nextInt()) == 1){
           out.println("Please select your file.");
           out.println("Not yet implemented. Goodbye.");
           System.exit(0);
       }else{
           out.println("Enter information manually.");
           String input;
           boolean complete = false;
           out.println("Just follow the instructions to input your grades.");
           out.println("Whenever you're done, just type in 'calculate'.");

           while(!complete){
               out.println("First, type in the course name. Then hit enter.");
               String courseName = scanner.next();

               out.println("Next, type in the letter grade you got. Then hit enter.");
               String grade = scanner.next();

               out.println("Lastly, type in the number of credit hours the class was worth. Then hit enter.");
               int hours = scanner.nextInt();

               Grade temp = new Grade(courseName.toUpperCase(), grade.toUpperCase(), hours);
               courseGrades.add(temp);
               out.println("Course added. Enter 'y' to calculate. Enter 'n' to continue.");
               input = scanner.next();
               if(input.equals("y")){
                   complete = true;
               }else if(input.equals("n")){
                   complete = false;
               }
           }

           out.println("You entered the following courses.");
           courseGrades
                   .stream()
                   .forEach(t -> {
                       t.printGrade();
                   });

           out.println("Now calculating your weighted GPA.");
           out.println("Weighted GPA: " + calc.calculateGPA(courseGrades));

        }
    }
    
}
