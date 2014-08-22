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
       out.println("Press 1 if you only care about numbers.");
       out.println("Press 2 for to include your courses and save the results.");
       out.println("Press any other key to exit the program.");
       options = scanner.nextInt();
       if(options == 1){
          String input;
          boolean complete = false;
          
          out.println("-----------------------------");
          out.println("You have chosen to calculate GPA the quick way.");
          out.println("Enter your letter grade and course credit hours like this: ");
          out.println("'A- 4 OR a- 4'" + "\n--------------------------------");
          out.println("Your weighted GPA will be displayed as you enter grades.");
          out.println("Type delete to remove the previous entry.");
          out.println("Type exit to terminate the program.");
          
          while(!complete){
              out.print(">> ");
              input = scanner.nextLine();
              if(input.toLowerCase().equals("exit")){
                  out.println("Terminating program.");
                  complete = true;
              }else if(input.toLowerCase().equals("delete")){
                  if(!courseGrades.isEmpty()){
                    out.println("Removing previous grade entry.");
                    courseGrades.remove(courseGrades.size()-1);
                  }else{
                      out.println("Can't delete from an empty list.");
                  }
              }else if(!input.isEmpty()){
                  String temp[] = input.split(" ", 2);
                  if(temp.length != 2){
                      out.println("Improper input. Format must be: grade hours");
                  }else if(temp.length == 2){
                      int hours = Integer.valueOf(temp[1]);
                      Grade grades = new Grade(null, temp[0], hours);
                      courseGrades.add(grades);
                      
                      //calculate gpa every entry?
                      //give option to save to document when exiting?
                  }
              }
          }
           
       }else if(options  == 2){
           out.println("Enter information manually.");
           String input;
           boolean complete = false;
           out.println("Just follow the instructions to input your grades.");
           out.println("Whenever you're done, just type 'calculate' and hit enter.");

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

        }else{
           out.println("Exiting program.");
           System.exit(0); 
       }
    }
    
}
