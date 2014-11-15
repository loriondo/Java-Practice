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
        StringSolutions strings = new StringSolutions();
        ArithmeticSolutions math = new ArithmeticSolutions();
        SACSolutions sac = new SACSolutions();
        
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
        /* End loop solutions */
        
        /*for(int i = 0; i < 8; i++){
            out.println(": " + loops.fibonacci(i));
        }*/
        
        /* Array Solutions */
        /*String[] breakfast = {"Sausage", "Eggs", "Beans", "Bacon", "Tomatoes"};
        arrays.printArray(breakfast);
        arrays.lastElement(breakfast);
        arrays.lastButN(breakfast, 1);
        arrays.reverse(breakfast);
        String[] palindrome = {"Fee", "Fi", "Fo", "Fi", "Fee"};
        out.println(arrays.isPalindrome(breakfast));
        out.println(arrays.isPalindrome(palindrome));
        out.println("3.5 Complete.\n");
        out.println(arrays.isPalindromeRecursion(breakfast, 0, breakfast.length-1));
        out.println(arrays.isPalindromeRecursion(palindrome, 0, breakfast.length-1));
        int[] nums = {1,1,3,3,3,2,2,2,1,1,1,1,4,4,4,4};
        arrays.compress(nums);
        char[] letters = {'a','a','a','a','b','c','c','a','a','d','e','e','e','e'};
        arrays.pack(letters);*/
        /* End Array Solutions */
        
        /* String Solutions */
        /*strings.countWords("I never saw a purple cow. Ever. Ever.");
        strings.countLetter('a', "I do what I want.");
        strings.countAlphanumerics("1984 by George Orwell.");
        strings.reverse("I never saw a purple cow.");
        strings.isPalindrome("tattarrattat");
        strings.isPalindromeV2("Rise to vote, Sir!");
        strings.removeVowels("I never saw a purple cow.");
        strings.spellOut("I never saw a purple cow");
        out.println(strings.encode("Hello World"));
        out.println(strings.decode(strings.encode("Hello World")));*/
        /* End String Solutions */
        
        /* Arithmetic Solutions */
        /*math.isPrime(6);
        math.gcd(1071, 462);
        math.isCoprime(35, 64);
        math.phi(10);
        math.primeFactors(98);
        math.primesInRange(10, 20);
        math.goldbachPair(1856);
        math.goldbachList(9, 20);*/
        /* End Arithmetic Solutions */
        
        /* Strings, Arrays, and Collections */
        sac.print2DArray(10,9);
        sac.chessBoard(8, 8);
        sac.digitsToWords("1000123");
        /* End S.A.C. Solutions */
        
        out.println("Terminating program");

    }//main    
}//class
