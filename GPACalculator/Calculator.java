/*
 */

package gpacalculator;


import java.util.ArrayList;
import static java.lang.System.out;
import java.util.stream.Collectors;

/** IN PROGRESS.
 * Calculator class.
 * Acts like a real life calculator. Methods here
 * deal with actual grade values and hours. Calculations
 * based on the user's input are done with the method in 
 * this class.
 * @author Lou
 */
public class Calculator {
    
    /**
     * Calculates the amount of grade points for a specific course.
     * Grade points are calculated by multiplying the credit hours 
     * by the point value of the user's letter grade within that course.
     * 
     * For example, CSCI 4730 is 4 hours and a user received a B in the
     * course. Therefore the gradepoints alloted for that course would be
     * 4 * 3.0 = 12.0.
     *
     * @param grade
     * @param hours
     * @return points - calculated value of grade points
     */
    public double getGradePoints(String grade, int hours){
        double points = 0;
        switch (grade.toUpperCase()) {
            case "A":
                points = 4.0 * hours;
                break;
            case "A-":
                points = 3.7 * hours;
                break;
            case "B+":
                points = 3.3 * hours;
                break;
            case "B":
                points = 3.0 * hours;
                break;
            case "B-":
                points = 2.7 * hours;
                break;
            case "C+":
                points = 2.3 * hours;
                break;
            case "C":
                points = 2.0 * hours;
                break;
            case "C-":
                points = 1.7 * hours;
                break;
            case "D":
                points = 1.0 * hours;
                break;
            case "F":
                points = 0;
                break;
        }
        //out.println(grade + " " + hours + " " + points);
        return points;
    }
    
    /**
     * Calculates the user's weighted GPA.
     * Calculates the grade points for all courses and sums 
     * result. Result is then divided by the total amount of
     * hours the courses are worth. 
     * 
     * @param grades
     * @return result - user's weighted GPA
     */
    public double calculateGPA(ArrayList<Grade> grades){
        double result = 0;
        ArrayList<Double> pointList = new ArrayList<>();
        grades
                .stream()
                .forEach(t -> {
                   double gradePoints = getGradePoints(t.getCourseGrade(), t.getCreditHours());
                   pointList.add(gradePoints);
                });
        
        double totalPoints = pointList
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        
        int totalHours = grades
                .stream()
                .mapToInt(t -> t.getCreditHours())
                .sum();
        
        //out.println("Total points " + totalPoints + " total hours " + totalHours);
        result = totalPoints / totalHours;
        return result;
    }
    
    /**
     * Returns the sum of credit hours for all courses entered.
     * @param grades
     * @return totalHours integer value, sum of all credit hours 
     */
    public int calculateTotalHours(ArrayList<Grade> grades) {
        int totalHours = grades
                .stream()
                .mapToInt(t -> t.getCreditHours())
                .sum();
        return totalHours;
    }
}
