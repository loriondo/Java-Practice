
package pkg99problems;

import static java.lang.System.out;
import java.util.ArrayList;

/** IN PROGRESS.
 * ArithmeticSolutions.java
 * Problems found at:
 * http://tonyballantyne.com/tech/5-arithmetic/
 * @author Lou
 * @since 10/24/14
 */
public class ArithmeticSolutions {
    
    /**
     * Problem 5.1.
     * @param n 
     */
    public void isPrime(int n){
        out.println("#1 isPrime(int n)");
        out.println("*** Output ***");
        
        int numDivisors = 0;
        for(int i = 1; i <=n; i++){
            if(n % i == 0){
                numDivisors++;
            }
        }
        if(numDivisors == 2){
            out.println("true");
        }else{
            out.println("false");
        }
        out.println("5.1 Complete.\n");
    }//isPrime
    
    /**
     * Non-void version of 5.1.
     * @param n
     * @return 
     */
    public boolean isPrime2(int n){
        int numDivisors = 0;
        for(int i = 1; i <=n; i++){
            if(n % i == 0){
                numDivisors++;
            }
        }
        return numDivisors == 2;
    }//non-void isPrime
    
    /**
     * Problem 5.2.
     * Euclid's Algorithm, but done with systematic subtraction - not division
     * @param n1
     * @param n2 
     */
    public void gcd(int n1, int n2){
        out.println("#2 gcd(int n, int m");
        out.println("*** Output ***");
        while(n1 != n2){
            if(n1 > n2){
                n1 = n1 - n2;
            }else{
                n2 = n2 - n1;
            }
        }
        out.println(n1);
        out.println("5.2 Complete.\n");
    }//gcd
    
    /**
     * Non void gcd calculation.
     * Helper method, used solely in other methods.
     * @param n1
     * @param n2
     * @return 
     */
    public int gcd2(int n1, int n2){
        while(n1 != n2){
            if(n1 > n2){
                n1 = n1 - n2;
            }else{
                n2 = n2 - n1;
            }
        }
        return n1;
    }//non void gcd
    
    /**
     * Problem 5.3.
     * Two integers are coprime if their GCD is 1.
     * @param n1
     * @param n2 
     */
    public void isCoprime(int n1, int n2){
        out.println("#3 isCoprime(int n, int m");
        out.println("*** Output ***");
        int n3 = gcd2(n1, n2);
        if(n3 == 1){
            out.println("true");
        }else{
            out.println("false");
        }
        out.println("5.3 Complete.\n");
    }//isCoprime
    
    /**
     * Problem 5.4.
     * Totient Function.
     * A count of all the positive integers less than or greater than n that are
     * coprime to n.
     * @param n 
     */
    public void phi(int n){
        out.println("#4 phi(int n)");
        out.println("*** Output ***");
        int numCoprimes = 0;
        for(int i = 1; i <= n; i++){
            int divisor = gcd2(n, i);
            if(divisor == 1){
                numCoprimes++;
            }
        }
        out.println(numCoprimes);
        out.println("5.4 Complete.\n");
    }//phi
    
    /**
     * Problem 5.5.
     * List the prime factors of n.
     * @param n 
     */
    public void primeFactors(int n){
        out.println("#5 primeFactors(int n)");
        out.println("*** Outut ***");
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                primes.add(i);
            }
        }
        primes
                .stream()
                .filter(t -> isPrime2(t) == true)
                .forEach(t -> {
                    out.print(t + " ");
                });
        out.println("\n5.5 Complete.\n");
    }//primeFactors
    
    /**
     * Problem 5.6.
     * Print primes between min and max.
     * @param min
     * @param max 
     */
    public void primesInRange(int min, int max){
        out.println("#6 primesInRange(min, max)");
        out.println("*** Output ***");
        for(int i = min; i <= max; i++){
            if(isPrime2(i) == true){
                out.print(i + " ");
            }
        }
        out.println("\n5.6 Complete.\n");
    }//primesInRange
    
    /**
     * Problem 5.7.
     * Print the pair of prime numbers that sum up to the input.
     * See Goldbach's Conjecture.
     * @param n - int input
     */
    public void goldbachPair(int n){
        out.println("#7 goldbachPair(n)");
        if(n <= 2){
            out.println("Number is not greater than 2.");
        }else{
            boolean complete = false;
            int i = 1;
            int p = n;
            while(!complete){
                n = n - 1;
                boolean x = isPrime2(i);
                boolean y = isPrime2(n);
                if(x && y){
                    out.println (i + " + " + n  + " = " + p);
                    complete = true;
                }else{
                    i++;
                }
            }
        }
        out.println("5.7 Complete.\n");
    }//goldbachPair()
    
    /**
     * Non-void version of 5.7.
     * @param n
     * @return int array containing goldbach pair
     */
    public int[] goldbachPair2(int n){
        if(n <= 2){
            out.println("Number is not greater than 2.");
            return null;
        }else{
            boolean complete = false;
            int i = 1;
            int p = n;
            while(!complete){
                n = n - 1;
                boolean x = isPrime2(i);
                boolean y = isPrime2(n);
                if(x && y){
                    complete = true;
                }else{
                    i++;
                }
            }
            int[] result = {i, n};
            return result;
        }
    }//goldbachPair2
    
    /**
     * Problem 5.8.
     * See goldbachPair, problem 5.7. Prints the Goldbach pair for every 
     * even number between min and max.
     * @param min
     * @param max 
     * @see goldbachPair
     */
    public void goldbachList(int min, int max){
        out.println("#8 goldbachList(min, max)");
        out.println("*** Output ***");
        for(int i = min; i <= max; i++){
            if(i % 2 == 0){
                int[] pair = goldbachPair2(i);
                out.println(pair[0] + " + " + pair[1] + " = " + i);
            }
        }
        out.println("5.8 Complete.\n");
    }//goldbachList
    
}//class
