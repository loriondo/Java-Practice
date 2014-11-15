
package pkg99problems;

import static java.lang.System.out;
import java.util.HashMap;

/** INCOMPLETE.
 * Solutions to problems found here:
 * http://tonyballantyne.com/tech/6-strings-arrays-and-collections/
 * @author Lou
 */
public class SACSolutions {
    
    /**
     * Problem 6.1.
     * Print any size 2D array.
     * @param numRows the number of rows 
     * @param numCols the number of columns
     */
    public void print2DArray(int numRows, int numCols){
        out.println("#1 print2DArray()");
        out.println("*** Output ***");
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                out.print("| X ");
            }
            out.println("|");
        }
        out.println("6.1 Complete.\n");
    }//print2DArray
    
    /** 
     * Problem 6.2.
     * The same as print2DArray, but now alternating X's.
     * @param numRows
     * @param numCols 
     */
    public void chessBoard(int numRows, int numCols){
        out.println("#2 chessBoard()");
        out.println("*** Output ***");
        boolean alternate = false;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(!alternate){
                    out.print("| X ");
                    alternate = true;
                }else{
                    out.print("| O ");
                    alternate = false;
                }
            }   
            if(i % 2 == 0){
                alternate = true;
            }else{
                alternate = false;
            }
            out.println("|");
        }
        out.println("6.2 Complete.\n");
    }//chessBoard
    
    /**
     * Problem 6.3.
     * Convert numerical representation of a word into it's word form.
     * i.e. 2 = two
     * There are more efficient ways of doing things, but I did it this way
     * because it was more fun.
     * @param digits string input to be converted into words
     */
    public void digitsToWords(String digits){
        out.println("#3 digitsToWords()");
        out.println("*** Output ***");
        HashMap map = new HashMap();
        for(int i = 0; i < 10; i++){
            map.put(i, digitWord.convert(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length(); i++){
            String word = (String)map.get(digits.charAt(i) - 48);
            sb.append(word).append(" ");
        }
        out.println(sb.toString());
        out.println("6.3 Complete.\n");
    }//digitsToWords
    
    /**
     * Enum used for Problem 6.3.
     * Could have used an ArrayList to store words in, or just do word
     * conversion manually. Using an enum was more interesting.
     */
    public enum digitWord {
        Zero("zero"),
        One("one"),
        Two("two"),
        Three("three"),
        Four("four"),
        Five("five"),
        Six("six"),
        Seven("seven"),
        Eight("eight"),
        Nine("nine");
        
        private String word;
        
        digitWord(String word){
            this.word = word;
        }
        
        public static String convert(int digit){
            String word;
            switch (digit){
                case 0:
                    word = Zero.word;
                    break;
                case 1:
                    word = One.word;
                    break;
                case 2:
                    word = Two.word;
                    break;
                case 3:
                    word = Three.word;
                    break;
                case 4:
                    word = Four.word;
                    break;
                case 5:
                    word = Five.word;
                    break;
                case 6:
                    word = Six.word;
                    break;
                case 7:
                    word = Seven.word;
                    break;
                case 8:
                    word = Eight.word;
                    break;
                case 9: 
                    word = Nine.word;
                    break;
                default:
                    word = "Error.";    
            }
            return word;
        }
    }//enum digitWord
    
}//class
