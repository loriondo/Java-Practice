
package enumpractice;

import static java.lang.System.out;

/**
* EnumPractice.java.
* Basic enumeration was only touched for a few minutes in one course at least
* 2 or 3 semesters ago. After doing research, enumerations would have been a 
* great piece of knowledge to have while doing various projects for other
* computer science courses. Inspired  by enum work done in Swift.
* 
* More practice to follow.
 * @author Lou
 */
public class EnumPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("Printing car type descriptions.\n");
        
        for(CarType car: CarType.values()){
            out.println(car.basicDescription());
        }
        
        out.println("Terminating program.");
    }//main
    
}//class
