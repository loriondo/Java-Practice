
package pkg99problems;

import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

/** COMPLETE
 LoopSolutions to the 99 problems posed at:
 http://www.tonyballantyne.com/tech/java/99-java-problems/
 * @author Lou
 */
public class LoopSolutions {
    
    private static Random rn;
    private static Scanner sc;
    
    /**
     * Constructor.
     */
    public LoopSolutions(){
        rn = new Random();
        sc = new Scanner(System.in);
    }
    
    /**
     * Problem 2.1.
     * Print 1 - 10
     */
    public void oneToTen(){
        out.println("#1 oneToTen()" + "\n*** Output ***");
        for(int i = 0; i < 11; i++){
            out.println(i);
        }
        out.println("2.1 Complete\n");
    }//oneToTen
    
    /**
     * Problem 2.2.
     * Print positive odd numbers less than 20;
     */
    public void oddNumbers(){
        out.println("#2 oddNumbers()" + "\n*** Output ***");
        for(int i = 0; i < 20; i++){
            if((i % 2) != 0){
                out.println(i);
            }
        }
        out.println("2.2 Complete.\n");
    }//oddNumbers
    
    /**
     * Problem 2.3.
     * Print square numbers up to 100;
     */
    public void squares(){
        out.println("#3 squares()" + "\n*** Output ***");
        for(int i = 1; i <= 10; i++){
            out.println(i * i);
        }
        out.println("2.3 Complete.\n");
    }//squares
    
    /**
     * Problem 2.4.
     * Print 4 random integers between 1 and 10.
     */
    public void random4(){
        out.println("#4 random4()" + "\n*** Output ***");
        for(int i = 0; i < 4; i++){
            int t = rn.nextInt(10 - 1 + 1) + 1;
            out.println(t);
        }
        out.println("2.4 Complete.\n");
    }//random4
    
    /**
     * Problem 2.5.
     * Print out positive even numbers less than 'n'.
     * @param n - upper bound of even numbers to print, user entered
     */
    public void even(int n){
        out.println("#5 even(" + n + ")." + "\n*** Output ***");
        for(int i = 1; i < n; i++){
            if((i % 2) == 0){
                out.println(i);
            }
        }
        out.println("2.5 Complete.\n");
    }//even(n)
    
    /**
     * Problem 2.6.
     * Print out powers of 2 from 2^1 to 2^n.
     * @param n - upper bound for the number of powers of 2, user entered
     */
    public void powers(int n){
        out.println("#6 powers(" + n + ")." + "\n*** Output ***");
        for(int i = 1; i <= n; i++){
            out.println((int)Math.pow(2, i));
        }
        out.println("2.6 Complete.\n");
    }//powers(n)
    
    /**
     * Problem 2.7.
     * Write a program that outputs “Are we there yet?” and then waits for input. 
     * If the input is “Yes” the program outputs “Good!” and exits, 
     * otherwise the program loops.
     */
    public void areWeThereYet(){
        out.println("#7 areWeThereYet()" + "\n*** Begin ***");
        boolean arrived = false;
        while(!arrived){
            out.println("Are we there yet?");
            String answer = sc.nextLine();
            if(answer.toLowerCase().equals("yes")){
                out.println("Good!");
                arrived = true;
            }
        }//while
        out.println("2.7 Complete.\n");
    }//areWeThereYet()
    
    /**
     * Problem 2.8.
     * Write a method that uses nested loops to produce a half-triangle pattern.
     */
    public void triangle(){
        out.println("#8 triangle()" + "\n*** Output ***");
        for(int i = 1; i < 6; i++){
            for(int j = 0; j < i; j++){
                out.print("*");
            }
            out.println("");
        }
        out.println("2.8 Complete.\n");
    }//triangle()
    
    /**
     * Problem 2.9.
     * Write a method that prints out a 4x4 table.
     */
    public void tableSquares(){
        out.println("#9 tableSquares()" + "\n*** Output ***");
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                out.print("| " + (j*i));
            }
            out.println(" |");
        }
        out.println("2.9 Complete.\n");
    }//tableSquares()
    
    /**
     * Problem 2.10.
     * Write a method that prints out an nxn table.
     * @param n - upperbound of the number of columns in the table.
     */
    public void tableSquares(int n){
        out.println("#10 tableSquareS(n)" + "\n*** Output ***");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                out.print("| " + (j*i));
            }
            out.println(" |");
        }
        out.println("2.10 Complete.\n");
    }//tableSquares(n)
    
}//class

