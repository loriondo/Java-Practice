
package graphicsproj3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * TO BE COMMENTED.
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
     * Concatenates two different matrices. 
     * Assumes the two matrices are able to be multiplied.
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
     * Applies a transformation to a list of lines.
     * @param transMatrix
     * @param datalines
     * @return 
     */
    public ArrayList<DataLine> applyTransformation(Matrix transMatrix, ArrayList<DataLine> datalines){
        ArrayList<DataLine> result = new ArrayList<>();
        Transformation trans = new Transformation();
        for(int i = 0; i < datalines.size(); i++){
            Matrix c1 = trans.coordinates(datalines.get(i).getX1(), datalines.get(i).getY1());
            Matrix c2 = trans.coordinates(datalines.get(i).getX2(), datalines.get(i).getY2());
            Matrix t1 = trans.concatenate(c1, transMatrix);
            Matrix t2 = trans.concatenate(c2, transMatrix);
            t1.setType("coordinates");
            t2.setType("coordinates");
            DataLine c = new DataLine(t1.getXFromMatrix(), t1.getXFromMatrix(), t2.getXFromMatrix(), t2.getYFromMatrix());
            result.add(c);
        }
        return result;
    }
    
    /**
     * Reads a file and saves sets of coordinates.
     * These coordinates are two points of a line.
     * @return 
     */
    public ArrayList<DataLine> inputLines(){
        ArrayList<DataLine> lines = new ArrayList<>();
        File datalines; 
        try{
            datalines = new File("/Users/Lou Man Chu/Downloads/datalines.txt");
            BufferedReader br = new BufferedReader(new FileReader(datalines));
            String input;
            String[] xy;
            while((input = br.readLine()) != null){
                //System.out.println(input);
                xy = input.split(" ");
                DataLine temp = new DataLine(Double.valueOf(xy[0]), Double.valueOf(xy[1]), 
                        Double.valueOf(xy[2]), Double.valueOf(xy[3]));
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