
package gpacalculator;

import static java.lang.System.out;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Text writer class.
 * Uses FileWriter and BufferedWriter to write the results of 
 * the GPA Calculator to a plain text file. Each entry the user
 * enters is included in this report. 
 * @author Lou Oriondo
 */
public class TextWriter {
    
    private final String header1 = "\n*------------------------------------------*\n";
    private final String header2 = "Weighted GPA Calculator - Course and Grades.";
    private final String header3 = "\nFormat: (Course name) (Letter Grade) (Hours)";
    
    private File saveFile;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    ArrayList<Grade> grades;
    
    /**
     * Constructor.
     * The save file will be saved to desktop/documents folder.
     * (Location of the actual save file will be changed.)
     */
    public TextWriter(){
        try{
            String homeFolder = System.getProperty("user.home");
            saveFile = new File(homeFolder, "gpa.txt");
            fw = new FileWriter(saveFile.getAbsoluteFile());
            bw = new BufferedWriter(fw);
        }catch(IOException | SecurityException e){
            out.println("Error initializing TextWriter: " + e.getMessage());
        }
    }// TextWriter()
    
    /** 
     * Writes user grade information to plain text file.
     * Uses FileWriter and BufferedWriter to write user's 
     * course list, hours, and weighted GPA to a document.
     * 
     * @param grades - ArrayList<Grade> populated with user's input
     * @param hours - The sum of all credit hours the user has attempted
     * @param gpa - The weighted GPA calculated from the user's letter grades
     */
    public void writeResults(ArrayList<Grade> grades, int hours, double gpa){
        this.grades = grades;
        
        try{
            bw.write(header1 + header2 + header3 + header1);
            grades
                    .stream()
                    .forEach(g -> {
                        String cn = g.getCourseName();
                        String cg = String.valueOf(g.getCourseGrade());
                        String ch = String.valueOf(g.getCreditHours());
                        try{
                            bw.write("\n" + cn.toUpperCase() + " " + cg.toUpperCase() + " " + ch);

                        }catch(IOException e){
                            out.println("Error writing course info to file: " + e.getMessage());
                        }
                    });
            String gpaVal = "\nWeighted GPA: " + gpa;
            String thours = "\nTotal attempted credit hours: " + hours;
            bw.write("\n" + header1 + "All courses listed." + gpaVal + thours + header1);
                    
            
        }catch(IOException e){
            out.println("Error writing results to file: " + e.getMessage());
        }finally{
            try{
                bw.close();
            }catch(IOException e){
                out.println("Error closing bufferedwriter: " + e.getMessage());
            }
        }  
    }// writeResults()
    
}
