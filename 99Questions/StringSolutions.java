
package pkg99problems;

import static java.lang.System.out;

/** INCOMPLETE
 * Solutions to String problems found at:
 * http://tonyballantyne.com/tech/4-strings/
 * @author Lou
 */
public class StringSolutions {
    
    /**
     * Problem 4.1.
     * Count number of words in a string.
     * @param s String to be checked
     */
    public void countWords(String s){
           out.println("#1 countWords(s)");
           out.println("*** Output ***");
           int count = 0;
           for(int i = 0; i < s.length(); i++){
               if(s.charAt(i) == ' '){
                   count++;
               }
           }
           out.println(count + 1);
           out.println("4.1 Complete.\n");
    }//countWords()
    
    /**
     * Problem 4.2.
     * Counts number of occurrences of a character in a string.
     * @param c character to be checked for
     * @param s string to search character for
     */
    public void countLetter(char c, String s){
        out.println("#2 countLetter(c, s)");
        out.println("*** Output ***");
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }
        }
        out.println(count);
        out.println("4.2 Complete.\n");
    }//countLetter()
    
    /**
     * Problem 4.3.
     * Counts number of letters and numbers in a string.
     * @param s string to be searched through
     */
    public void countAlphanumerics(String s){
        out.println("#3 countAlphanumerics(s)");
        out.println("*** Output ***");
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 48 && s.charAt(i) <= 57) ||
                    (s.charAt(i) >= 65 && s.charAt(i) <= 90) ||
                    (s.charAt(i) >= 97 && s.charAt(i) <= 122)){
                count++;
            }
        }
        out.println(count);
        out.println("4.3 Complete.\n");
    }//countAlphanumerics
    
    /**
     * Problem 4.4.
     * Reverses selected input string.
     * @param s string to be reversed for
     */
    public void reverse(String s){
        out.println("#4 reverse(s)");
        out.println("*** Output ***");
        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i > 0; i--){
            sb.append(s.charAt(i-1));
        }
        out.println(sb.toString());
        out.println("4.4 Complete.\n");
    }//reverse
    
    /**
     * Problem 4.5.
     * Checks if String s is a palindrome.
     * e.g. baab
     * @param s input String
     */
    public void isPalindrome(String s){
        out.println("#5 isPalindrome(s)");
        out.println("*** Output ***");
        boolean isPal = false;
        int j = s.length();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(j-1)){
                if(i == j){
                    isPal = true;
                    break;
                }
                j--;
            }else{
                break;
            }
            isPal = true;
        }
        out.println(isPal);
        out.println("4.5 Complete.\n");
    }//isPalindrome
    
    /**
     * Problem 4.6.
     * Checks if String s is a palindrome.
     * Any non-letter characters are ignored.
     * e.g. Rise to vote, Sir! is a palindrome
     * @param s input string
     */
    public void isPalindromeV2(String s){
        out.println("#6 isPalindromeV2(s)");
        out.println("*** Output ***");
        boolean isPal = false;
        int i = 0;
        String temp = s.replaceAll("\\W", "");
        String stripped = temp.toLowerCase();
        int j = stripped.length() - 1;
        while(!isPal){
            if(stripped.charAt(i) == stripped.charAt(j)){
                if(i == j){
                    isPal = true;
                    break;
                }
            }else{
                break;
            }
            i++;
            j--;
        }
        out.println(isPal);
        out.println("4.6 Complete.\n");
    }//isPalindromeV2
    
    /**
     * Problem 4.7.
     * Replaces vowels in String s with asterisks.
     * @param s input String 
     */
    public void removeVowels(String s){
        out.println("#7 removeVowels(s)");
        out.println("*** Output ***");
        String temp = s.replaceAll("[aeiouAEIOU]", "*");
        out.println(temp);
        out.println("4.7 Complete.\n");
    }//removeVowels()
    
}//class
