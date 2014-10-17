package graphicsproj3;

import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * GraphicsProj3.java.
 * Main method. Provides text interface for user to 
 * manipulate an image defined by data lines. These data lines
 * are defined in a text document that can be defined by
 * the user (in this implementation, simply hard coded to 
 * find datalines.txt on my Desktop).
 * @author Lou Oriondo
 * @since 10/14/2014
 */
public class GraphicsProj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Transformation trans = new Transformation();
        Scanner sc = new Scanner(System.in);
        Projection proj = new Projection();
        
        out.println("*** \tCSCI 4810 - Graphics Project 3\t ***");
        out.println("*** \tLou Oriondo Fall 2014\t ***\n");
        out.println(": Press '1' to Translate data lines.");
        out.println(": Press '2' to Scale data lines.");
        out.println(": Press '3' to Rotate data lines.");
        out.println(": Press '4' to set a viewport.");
        out.println("  Note: A default viewport is set at (10,10) and (500,500).");
        out.println(": Press '5' to apply the transformation and display.");
        out.println(": Press '6' to save currently drawn lines to file.");
        out.println(": Press '0' to exit.");
        
        boolean complete = false;
        boolean exit = false;
        //ArrayList<Matrix> transformations = new ArrayList<>();
        out.println("\n: Beginning program.");
        //proj.display();
        while(!exit){
            ArrayList<Matrix> transformations = new ArrayList<>();
            proj.display();
            boolean isViewportSet = false;
            while(!complete){
                out.println(": Please enter an operation, between 1 thru 5.");
                out.print(": >> ");
                int option = sc.nextInt();
                if(option >= 1 && option <= 5){
                    if(option == 1){
                        out.print(": Translate x by >> ");
                        int tx = sc.nextInt();
                        out.print(": Translate y by >> ");
                        int ty = sc.nextInt();
                        Matrix translate = trans.basicTranslate(tx, ty);
                        transformations.add(translate);
                    }else if(option == 2){
                        out.print(": Scale x by >> ");
                        int sx = sc.nextInt();
                        out.print(": Scale y by >> ");
                        int sy = sc.nextInt();
                        Matrix scale = trans.basicScale(sx, sy);
                        transformations.add(scale);
                    }else if(option == 3){
                        out.print(": Degrees (not radians) to rotate datalines >> ");
                        int rot = sc.nextInt();
                        Matrix rotate = trans.basicRotate(rot);
                        transformations.add(rotate);
                    }else if(option == 4){
                        out.println(": Enter coordinates for viewport.");
                        out.print(": xmin-coordinate >> ");
                        int vx0 = sc.nextInt();
                        out.print(": ymin-coordinate >> ");
                        int vy0 = sc.nextInt();
                        out.print(": xmax-coordinate >> ");
                        int vx1 = sc.nextInt();
                        out.print(": ymax-coordinate >> ");
                        int vy1 = sc.nextInt();
                        proj.setViewport(vx0, vy0, vx1, vy1);
                        isViewportSet = true;
                    }else if(option == 5){
                        if(transformations.isEmpty()){
                            out.println("You have not selected any transformations.");
                            out.println("Drawing lines.");
                            if(isViewportSet == false){
                                out.println("Setting default viewport.");
                                proj.setViewport(10, 10, 500, 500);
                            }
                            proj.draw(trans.inputLines());
                            complete = true;
                        }else{
                            out.println("Applying " + transformations.size() + " transformations.");
                            Matrix res = trans.concatenate(transformations);
                            ArrayList<DataLine> output = trans.applyTransformation(res, trans.inputLines());
                            //proj.draw(trans.applyTransformation(res, trans.inputLines()));
                            if(isViewportSet == false){
                                out.println("Setting default viewport.");
                                proj.setViewport(10, 10, 500, 500);
                            }
                            proj.draw(output);
                            complete = true;
                            boolean done = false;
                            while(!done){
                                out.println(": Save transformed lines to file? Press 1 for yes.");
                                int c = sc.nextInt();
                                if(c == 1){
                                    trans.outputLines(output);
                                    out.println(": Lines saved to outputLines.txt.");
                                    done = true;
                                }else{
                                   out.println(": Not saving to file.");
                                }
                            }
                        }
                    }else if(option == 0){
                        out.println("Exiting program.");
                        System.exit(0);
                    }
                }else if(option == 0){
                    out.println("Exiting program.");
                    System.exit(0);
                }else{
                    out.println(": You entered " + option + ", which is not between 1 and 5.");
                    out.println(": Please try again.");
                }
            }
            out.println(": Draw again? Press 0 to close.");
            int ex = sc.nextInt();
            if(ex == 0){
                exit = true;
            }
            complete = false; 
        }
        out.println("Drawing and line clipping complete.");
        out.println("Exiting program.");
        System.exit(0);
    }//main
    
}//class