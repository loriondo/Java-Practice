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
        
        Matrix origin = trans.coordinates(2, 2);
        Matrix mat1 = trans.basicTranslate(5, 5);
        Matrix mat2 = trans.basicScale(5, 5);
        Matrix mat3 = trans.basicRotate(45);
        
        origin.displayMatrix();
        mat1.displayMatrix();
        //mat2.displayMatrix();
        Matrix result = trans.concatenate(mat1, mat2);
        Matrix fin = trans.concatenate(origin, mat1);
        fin.displayMatrix();
    }
    
}
