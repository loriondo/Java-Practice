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
        
        LoopSolutions loops = new LoopSolutions();
        ArraySolutions arrays = new ArraySolutions();
        
        out.println("Basic Java 99 Problems.\n");
        
        /* Loop Solutions */
        /*loops.oneToTen();
        loops.oddNumbers();
        loops.squares();
        loops.random4();
        loops.even(20);
        loops.powers(8);
        loops.areWeThereYet();
        loops.triangle();
        loops.tableSquares();
        loops.tableSquares(6);*/
        
        /* Array Solutions */
        String[] breakfast = {"Sausage", "Eggs", "Beans", "Bacon", "Tomatoes"};
        arrays.printArray(breakfast);
        arrays.lastElement(breakfast);
        arrays.lastButN(breakfast, 1);
        arrays.reverse(breakfast);
        String[] palindrome = {"Fee", "Fi", "Fo", "Fi", "Fee"};
        /* Problem 3.5 */
        out.println(arrays.isPalindrome(breakfast));
        out.println(arrays.isPalindrome(palindrome));
        out.println("3.5 Complete.\n");
        out.println(arrays.isPalindromeRecursion(breakfast, 0, breakfast.length-1));
        out.println(arrays.isPalindromeRecursion(palindrome, 0, breakfast.length-1));
        /* Complete 3.5 */
        
        
        out.println("Terminating program.");
    }    
}//class
