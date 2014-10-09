package graphicsproj3;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Lou
 */
public class GraphicsProj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Transformation trans = new Transformation();
        
        Matrix mat1 = trans.basicTranslate(5, 5);
        Matrix mat2 = trans.basicScale(5, 5);
        Matrix mat3 = trans.basicRotate(45);
        
        Matrix mat4 = trans.concatenate(mat1, mat2);
        mat4.displayMatrix();
        //mat3.displayMatrix();
        Matrix transMatrix = trans.concatenate(mat4, mat3);
        
        //transMatrix.displayMatrix();
        
        trans.inputLines()
                .stream()
                .forEach(t -> {
                    out.println(t.getX1() + ", " + t.getY1());
                    out.println(t.getX2() + ", " + t.getY2());
                });
        
        out.println("Apply transformation.");
        
        trans.applyTransformation(mat4, trans.inputLines())
                .stream()
                .forEach(t-> {
                    out.println(t.getX1() + ", " + t.getY1());
                    out.println(t.getX2() + ", " + t.getY2());
                });
        
        
    }
    
}