
package graphicsproj3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lou
 */
public class Transformation {
    
    public Matrix coordinates(double x, double y){
        Matrix matrix = new Matrix(1, 3);
        matrix.setType("coordinates", x , y);
        return matrix;
    }
    
    /**
     * Creates a basic translation matrix.
     * 
     * @param tx
     * @param ty
     * @return 
     */
    public Matrix basicTranslate(int tx, int ty){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("translation", tx, ty);
        //matrix.displayMatrix();
        return matrix;
    }//basicTranslate
    
    /**
     * Creates a basic scale matrix.
     * @param sx
     * @param sy
     * @return 
     */
    public Matrix basicScale(int sx, int sy){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("scale", sx, sy);
        //matrix.displayMatrix();
        return matrix;
    }//basicScale
    
    /**
     * Creates basic rotate matrix.
     * @param angle
     * @return 
     */
    public Matrix basicRotate(int angle){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("rotation", angle);
        //matrix.displayMatrix();
        return matrix;
    }//basicRotate
    
    /**
     * 
     * @param matrix1
     * @param matrix2
     * @return 
     */
    public Matrix concatenate(Matrix matrix1, Matrix matrix2){
        Matrix result = null;
        if(matrix1.getNumColumns() != matrix2.getNumRows()){
            System.out.println("Something went wrong. Matrices cannot be multiplied.");
        }else{
            result = matrix1.multiply(matrix2);   
            //result.displayMatrix();
        }
        return result;
    }//concatenate
    
    /**
     * 
     * @param transMatrix
     * @param datalines
     * @return 
     */
    public ArrayList<Coordinates> applyTransformation(Matrix transMatrix, ArrayList<Coordinates> datalines){
        ArrayList<Coordinates> result = new ArrayList<>();
        Transformation trans = new Transformation();
        for(int i = 0; i < datalines.size(); i++){
            Matrix point = trans.coordinates(datalines.get(i).x(), datalines.get(i).y());
            Matrix transformed = trans.concatenate(point, transMatrix);
            transformed.setType("coordinates");
            Coordinates c = new Coordinates(transformed.getXFromMatrix(), transformed.getYFromMatrix());
            result.add(c);
        }
        return result;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Coordinates> inputLines(){
        ArrayList<Coordinates> lines = new ArrayList<>();
        File datalines; 
        try{
            datalines = new File("/Users/Lou Man Chu/Downloads/datalines.txt");
            BufferedReader br = new BufferedReader(new FileReader(datalines));
            String input;
            String[] xy;
            while((input = br.readLine()) != null){
                //System.out.println(input);
                xy = input.split(" ");
                Coordinates temp = new Coordinates(Double.valueOf(xy[0]), Double.valueOf(xy[1]));
                lines.add(temp);
            }
        }catch(NullPointerException e){
            System.out.println("Error with inputLines(): " + e.getMessage());
        }catch(FileNotFoundException e){
            System.out.println("Error with inputLineS(): " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error with inputLines(): " + e.getMessage());
        }
        return lines;
    }
}