/*
 */

package gpacalculator;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Work in progress.
 * Keeping track of one's GPA is a rather important thing to do. 
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
          /* Begin option 1 */
          String input;
          boolean complete = false;
          
          out.println("-----------------------------");
          out.println("You have chosen to calculate GPA the quick way.");
          out.println("Enter your letter grade and course credit hours like this: ");
          out.println("'A- 4 OR a- 4'" + "\n--------------------------------");
          out.println("Your weighted GPA will be displayed as you enter grades.");
          out.println("Type 'delete' to remove the previous entry.");
          out.println("Type 'show' to display your grade entries.");
          out.println("Type 'exit' to terminate the program.");
          
          while(!complete){
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
              }else if(input.toLowerCase().equals("show")){
                  if(!courseGrades.isEmpty()){
                      courseGrades
                              .stream()
                              .forEach(t -> {
                                   t.printGrade();
                              });
                  }else{
                      out.println("No grades entered.");
                  }
              }else if(!input.isEmpty()){
                  String temp[] = input.split(" ", 2);
                  if(temp.length != 2){
                      out.println("Improper input. Format must be: grade hours");
                  }else if(temp.length == 2){
                      //try catch block, temp[1] not integer
                      int hours = Integer.valueOf(temp[1]);
                      Grade grades = new Grade(null, temp[0], hours);
                      courseGrades.add(grades);
                      
                      out.println("Weighted GPA so far.");
                      out.print(calc.calculateGPA(courseGrades) + "\n");
                      
                  }
              }
          }
          
          //Save copy to external document
          
          
       /* End option 1 */    
       }else if(options  == 2){
       /* Begin option 2 */
           out.println("Enter information manually.");
           String input;
           boolean complete = false;
           out.println("Enter your course name, followed by grade, followed by hours.");
           out.println("For example: CSCI4730 A- 4");
           out.println("Whenever you're done, just type 'calculate' and hit enter.");
           out.println("Type 'show' to display your current entries.");
           out.println("Type 'delete' to delete your last entry.");
           out.println("Type 'done' to exit the program.");

           //give option to save to file?
           while(!complete){
               input = scanner.nextLine();
               if(input.toLowerCase().equals("show")){
                   if(!courseGrades.isEmpty()){
                       courseGrades
                               .stream()
                               .forEach(t -> {
                                   t.printGrade();
                               });
                       out.println("Displayed grades.\n");
                   }else{
                       out.println("No entries to show.");
                   }
               }else if(input.toLowerCase().equals("calculate")){
                   out.println("Now calculating your weighted GPA.");
                   out.println("Weighted GPA: " + calc.calculateGPA(courseGrades));
               }else if(input.toLowerCase().equals("done")){
                   complete = true;
                   //out.println("Terminating program.");
                   //System.exit(0);
               }else if(!input.isEmpty()){
                   //try catch block, temp[1] and temp[2] not integers
                   String temp[] = input.split(" ", 3);
                   if(temp.length != 3){
                       out.println("Improper format. Try again.");
                   }else{
                       out.println("Grade information entered.");
                       int hours = Integer.valueOf(temp[2]);
                       Grade grade = new Grade(temp[0], temp[1], hours);
                       courseGrades.add(grade);
                   }
               }
           }
           
           //Save copy of information to external document
           out.println("Woud you like to save this information to a text file?");
           out.println("Type yes (y) or no (n)");
           String input2 = scanner.nextLine();
           if(input2.toLowerCase().equals("yes") || input2.toLowerCase().equals("y")){
               out.println("Saving grade information to weightedgpa.txt");
               
               /* WORK IN PROGRESS */
               //Create another class to do this. Below code used for testing only.
               //Once functionally working, will be revised for cleanliness.
               File saveFile = new File("/users/Lou/Desktop/weightedgpa.txt");
               if(!saveFile.exists()){
                   try{
                       saveFile.createNewFile();
                   }catch(IOException e){
                       out.println("Issue creating save file: " + e.getMessage());
                   }
                }
                
               FileWriter fw = null;
                try{
                    fw = new FileWriter(saveFile.getAbsoluteFile());
                }catch(SecurityException | IOException e){
                    out.println("Issue creating writer for save file: " + e.getMessage());
                }
                BufferedWriter bw = new BufferedWriter(fw);
                
                String header = "Weighted GPA Calculator - Course and Grades.";
                
                try{
                    bw.write(header);
                }catch(IOException e){
                    out.println("Error writing to file: " + e.getMessage());
                }finally{
                    
                    try{
                        bw.close();
                    }catch(IOException e){
                        out.println("Error closing bufferedwriter: " + e.getMessage());
                    }
                }
                
           }else{
               out.println("Opted out of saving grade information.");
           }
           
           /* WORK IN PROGRESS */
           
        /* End option 2 */
        }else{
           out.println("Exiting program.");
           System.exit(0); 
       }
    }
    
}
