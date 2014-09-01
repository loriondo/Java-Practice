package pkg99problems;

import static java.lang.System.out;

/** INCOMPLETE
 * Java 99 Problems.
 * Basic java problems found at:
 * http://www.tonyballantyne.com/tech/java/99-java-problems/
 * Problems are very basic and act more as a "speed round"
 * practice. More difficult problems will be attempted once 
 * all 99 problems in this set have been solved.
 * @author Lou
 */
public class NinetyNineProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Solutions solution = new Solutions();
        
        out.println("Basic Java 99 Problems.\n");
        
        solution.oneToTen();
        solution.oddNumbers();
        solution.squares();
        solution.random4();
        solution.even(20);
        solution.powers(8);
        solution.areWeThereYet();
        solution.triangle();
        solution.tableSquares();
        solution.tableSquares(6);
        
        out.println("Terminating program.");
    }//main
    
}//class
