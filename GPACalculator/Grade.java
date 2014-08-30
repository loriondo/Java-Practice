/*
 */

package gpacalculator;

/** 
 * Grade class.
 * Grade object created from information entered
 * by the user. These values are then used to calculate
 * the user's weighted GPA.
 * @author Lou Oriondo
 */
public class Grade {
    
    private String courseName;
    private String courseGrade;
    private int creditHours;
    
    /**
     * Constructor
     * 
     * @param course
     * @param grade
     * @param hours 
     */
    public Grade(String course, String grade, int hours){
        this.courseName = course;
        this.courseGrade = grade;
        this.creditHours = hours;
    }// Grade
    
    /**
     * Getter method for a course name.
     * 
     * @return courseName
     */
    public String getCourseName(){
        return this.courseName;
    }// getCourseName
    
    /**
     * Getter method for user's grade within a course.
     * 
     * @return courseGrade
     */
    public String getCourseGrade(){
        return this.courseGrade;
    }// getCourseGrade
    
    /**
     * Getter method for amount of hours a course is worth.
     * 
     * @return creditHours
     */
    public int getCreditHours(){
        return this.creditHours;
    }// getCreditHours
    
    /**
     * Prints out details about a specific grade object 
     * the user entered.
     */
    public void printGrade(){
        System.out.println("-----------------");
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Course Grade: " + this.courseGrade);
        System.out.println("Course credit hours: " + this.creditHours);
        System.out.println("-----------------");
    }// printGrade

    
}
