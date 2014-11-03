
package playground;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 * Playground.java.
 * Would be nice to make a playground for Java...?
 * Just some quick concepts I wanted to fiddle with, mainly Jsoup.
 * 
 * @author Lou
 */
public class Playground {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Practice solve = new Practice();
        
        /*for(int i = 0; i < 10; i++){
            out.println(solve.fibonacci(i));
        }
        
        out.println(solve.factorial(5));
        
        Practice solve2 = new Practice("Yes.");
        solve2.passBy(solve2);
        out.println(solve2.test);*/
        
        String testURL1 = "http://diablo.somepage.com/popular/crusader#builds";
        //Goal is to get all the information I need from the diablo game guide
        //and various class build sites to make my own 'database' of information.
        //Except it wouldnt be a database, the information would have to accessed
        //everytime the program runs
        
        /*ArrayList<String> text = solve.getTextFromURL(testURL1);
        text
                .stream()
                .forEach(t -> {
                    if(t.contains(".")){
                        out.print(".\n");
                    }
                    out.print(t + " "); //this is still pretty messy
                });
        */
        
        /*ArrayList<Element> e = new ArrayList(solve.getElementsFromURL(testURL1));
        out.println(e.size()); //this is way too big, I don't want all the elements
        */
        
        ArrayList<Element> content = new ArrayList(solve.getElementByTag(testURL1, "body"));
        out.println(content.size()); //only 1 element with this tag, good
        //out.println(content.get(0).toString()); //but how do we filter an element?
          
        Element body = content.get(0);  //break this down even further...
        //out.println(body.toString()); 
        
        ArrayList<TextNode> tn = new ArrayList(body.textNodes());
        out.println(tn.size());
        
        for(TextNode text: tn){
            out.println("/* --- Text Node --- */");
            out.println(text.isBlank()); //text nodes are blank, whhyyy
            out.println("/* --- Text Node --- */");
        }
        
    }//main
    
    public static class Practice {
        
        private String test;
        
        public Practice(){
            
        }

        public Practice(String test){
            this.test = test;
        }
        
        /**
         * Fibonacci sequence.
         * Fn = Fn-1 + Fn-2;
         * @param   n   integer to be calculated
         * @return      fibonacci sequence of 'n'
         */
        public int fibonacci(int n){
            if(n <= 1){
                return n;
            }else{
                return fibonacci(n-1) + fibonacci(n-2);
            }
        }//fibonacci
        
        /**
         * Factorial calculation.
         * @param   n   integer to be calculated
         * @return      factorial value of 'n'
         */
        public int factorial(int n){
            if(n <= 1){
                return 1;
            }else{
                //out.println(n);
                return n * factorial(n-1);
            }
        }//factorial
        
        /**
         * Java is pass by value.
         * Think of passing by value as passing a copy of the object. 
         * Destroying or replacing that object only alters the copy, 
         * the original is left untouched. Inside this function, we replace
         * the string with "No." We print out the copy and compare it to 
         * the original, which still says "Yes."
         * 
         * @param   object  Instance of 'Practice' class to test for p. by v.    
         */
        public void passBy(Practice object){
            object = new Practice("No.");
            out.println(object.test);
        }//passBy
        
        /**
         * Retrieves text from a URL and parses the text into an ArrayList.
         * Jsoup's .text() function is used, but returns a SINGLE String of ALL
         * the text from the URL. This can be very long and cannot be read. To 
         * aid in readability, this retrieves the text from the URL and splits
         * the text by spaces. 
         * @param   url URL of the web page text will be retrieved
         * @return      List all words separated by a space
         * @see         Jsoup
         */
        public ArrayList<String> getTextFromURL(String url){
            Document doc = null;
            try{
                out.println("Attempting to connect to " + url + ".");
                doc = Jsoup
                        .connect(url)
                        .get();
            }catch(IOException e){
                out.println("Error connecting to URL: " + e.getMessage());
            }finally{
                out.println("Attempt to connect to URL completed.");
            }
            //looking through documenation to see if there's a better way of
            //retrieving just the text
            String[] temp = doc.text().split(" "); 
            ArrayList<String> text = new ArrayList<>(Arrays.asList(temp));
            return text;
        }//getText
        
        /**
         * Retrieves all elements that make up the HTML document found in the
         * provided url. Elements start with a 'start' tag, end with an 'end' 
         * tag, and have content in between. The getAllElements will end up 
         * retrieving ALL of this, which doesn't seem to be of much help. 
         * End goal is to retrieve only the text content within a certain
         * element. 
         * @param   url URL of web page to be accessed 
         * @return      List of type Element, all elements in the HTML document 
         */
        public Elements getElementsFromURL(String url){
            Document doc = null;
            try {
                out.println("Attempting to connect to " + url + ".");
                doc = Jsoup
                        .connect(url)
                        .get();
            }catch(IOException e){
                out.println("Error connecting to URL: " + e.getMessage());
            }finally {
                out.println("Attempt to connect to URL completed.");
            }
            return doc.getAllElements();
        }//getElements
        
        /**
         * Retrieves all elements from the HTML document that have the 
         * specified tag. For example, the 'body' tag will hold content 
         * (that I want access to). As such, searching for this tag decreases
         * the number of elements that I have to filter through.
         * @param url   URL of web page to be accessed
         * @param tag   tag of specific element, i.e. body
         * @return      list of type Element that has elements with specified tag
         */
        public Elements getElementByTag(String url, String tag){
            Document doc = null;
            try {
                out.println("Attempting to connect to " + url + ".");
                doc = Jsoup
                        .connect(url)
                        .get();
            }catch(IOException e){
                out.println("Error connecting to URL: " + e.getMessage());
            }finally {
                out.println("Attempt to connect to URL completed.");
            }
            return doc.getElementsByTag(tag);
        }//getElementsByTag
        
        
        
    }//Practice class
}//Playground class




