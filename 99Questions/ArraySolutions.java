
package pkg99problems;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/** 
 * Solutions to Array problems found at:
 * http://www.tonyballantyne.com/tech/java/99-java-problems/
 * @author Lou
 */
public class ArraySolutions {
    
    private static Scanner sc;
    
    /**
     * Constructor.
     */
    public ArraySolutions(){
        sc = new Scanner(System.in);
    }
    
    /**
     * Problem 3.1.
     * Method that prints elements of an array.
     * @param input String array to be printed
     */
    public void printArray(String[] input){
        out.println("#1 printArray()");
        out.println("*** Output ***");
        //Note that array was converted into list for use of Java 8 streams
        ArrayList inputAsList = new ArrayList<>(Arrays.asList(input));
        inputAsList
                .stream()
                .forEach(s -> {
                    out.println(s);
                });
        out.println("3.1 Complete.\n");
    }// printArray()
    
    /**
     * Problem 3.2.
     * Method that prints last element of an array.
     * @param input String array to be printed
     */
    public void lastElement(String[] input){
        out.println("#2 lastElement()");
        out.println("*** Output ***");
        out.println(input[input.length - 1]);
        out.println("3.2 Complete.\n");
    }// lastElement()
    
    /**
     * Problem 3.3.
     * Method that prints the element at n indices before the last element.
     * Note that this is an extended version of the desired problem found 
     * on the problem list.
     * @param input String array to be printed
     * @param n Integer offset from last element in array
     */
    public void lastButN(String[] input, int n){
        out.println("#3 lastButN(" + n + ")");
        out.println("*** Output ***");
        if(n > input.length - 1){
            out.println("Offset greater than the length of an array.");
            out.println("Unable to print desired element, index out of bounds.");
        }else{
            out.println(input[input.length - (n + 1)]);
        }
        out.println("3.3 Complete.\n");
    }// lastButN
    
    /**
     * Problem 3.4.
     * Method that reverses the elements of an array and prints the elements.
     * @param input String array to be reversed and printed.
     */
    public void reverse(String[] input){
        out.println("#4 reverse()");
        out.println("*** Output ***");
        int j = input.length - 1;
        String[] reversedInput = new String[input.length];
        for(int i = 0; i < input.length; i++){
            reversedInput[i] = input[j];
            j--;
        }
        ArrayList<String> reversed = new ArrayList<>(Arrays.asList(reversedInput));
        reversed
                .stream()
                .forEach(s -> {
                    out.println(s);
                });
        out.println("3.4 Complete.\n");
    }// reverse()
    
    /**
     * Problem 3.5.
     * Method that checks if an array is palindromic, i.e. if the array 
     * is reversed, is it the same array.
     * @param input String array to be checked
     * @return boolean result after checking if array is a palindrome
     */
    public boolean isPalindrome(String[] input){
       out.println("#5 isPalindrome()");
       out.println("*** Output ***");
       boolean isPalindrome = true;
       int j = input.length - 1;
       for(String element : input){
           if(!element.equals(input[j])){
               isPalindrome = false;
               break;
           }else{
               isPalindrome = true;
           }
           j--;
       }
       return isPalindrome;
    }// isPalindrome()
    
    /** IN PROGRESS
     * Recursive version of problem 3.5.
     * Same purpose as 3.5, but solution is found recursively.
     * @param input String array to be checked 
     * @param i starts at first index of the array and increments
     * @param j starts at last index of the array and decrements
     * @return boolean result returning true if array is a palindrome
     */
    public boolean isPalindromeRecursion(String[] input, int i, int j){
        if(j == 0){
            return true;
        }else if(input[i].equals(input[j])){
            isPalindromeRecursion(input, i++, j--);
        }
        return false;
    }// isPalindromeRecursion()
    
    /**
     * Problem 3.6.
     * Print out an int array with consecutive duplicates eliminated
     * @param input int array to be checked for duplicates
     */
    public void compress(int[] input){
        out.println("#6 compress(nums)");
        out.println("*** Output ***");
        int temp = -1;
        for(int i = 0; i < input.length; i++){
            if(temp != input[i]){
                out.println(": " + input[i]);
                temp = input[i];
            }
        }
        out.println("3.6 Complete.\n");
    }//compress
    
    /**
     * Problem 3.7.
     * Pack consecutive duplicates of char array into Strings.
     * @param input char array to be checked for consecutive duplicates
     */
    public void pack(char[] input){
        out.println("#7 pack(letters)");
        out.println("*** Output ***");
        String s = Character.toString(input[0]);
        out.print(": ");
        for(int i = 1; i < input.length; i++){
            if(input[i-1] != input[i]){
                out.print(s + ", ");
                s = Character.toString(input[i]); //replaces printed string with input[i]
            }else{
                s = s + input[i];
            }
        }
        out.println(s);
        out.println("3.7 Complete.\n");
    }//pack
    
}// class
