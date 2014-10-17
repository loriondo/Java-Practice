
package graphicsproj3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Transformation.java.
 * Class that defines different kinds of transformations. Transformations
 * are represented by Matrix objects. Class also provides method to 
 * concatenate transformations and apply to a list of data lines.
 * @author Lou Oriondo
 * @since 10/14/2014
 */
public class Transformation {
    
    FileWriter fw;
    BufferedWriter bw;
    File outputFile;
    
    /**
     * Creates coordinate matrix with dimensions 1x3.
     * @param x     double value, x-coordinate of a point
     * @param y     double value, y-coordinate if a point
     * @return      Matrix representation of coordinate '(x,y)'
     */
    public Matrix coordinates(double x, double y){
        Matrix matrix = new Matrix(1, 3);
        matrix.setType("coordinates", x , y);
        return matrix;
    }//coordinates()
    
    /**
     * Creates a basic translation matrix with dimensions 3x3.
     * @param tx    integer amount to translate x-coordinate
     * @param ty    integer amount to translate y-coordinate
     * @return      Matrix representation of basic translation by '(tx, ty)'
     */
    public Matrix basicTranslate(int tx, int ty){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("translation", tx, ty);
        //matrix.displayMatrix();
        return matrix;
    }//basicTranslate
    
    /**
     * Creates a basic scale matrix.
     * @param sx    integer amount to scale x-coordinate
     * @param sy    integer amount to scale y-coordinate
     * @return      Matrix representation of basic scaling by '(sx, sy)'
     */
    public Matrix basicScale(int sx, int sy){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("scale", sx, sy);
        //matrix.displayMatrix();
        return matrix;
    }//basicScale
    
    /**
     * Creates basic rotate matrix.
     * @param angle integer value of angle to rotate by, in degrees
     * @return      Matrix representation of basic rotation by 'angle' degrees
     */
    public Matrix basicRotate(int angle){
        Matrix matrix = new Matrix(3,3);
        matrix.setType("rotation", angle);
        //matrix.displayMatrix();
        return matrix;
    }//basicRotate
    
    /**
     * Concatenates two different matrices. 
     * @param matrix1   Matrix concatenated BY matrix2
     * @param matrix2   Matrix concatenated WITH matrix1
     * @return          Matrix representation of matrix1 concatenated with matrix2
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
     * Concatenates a list of matrices.
     * @param t     List of matrices to be concatenated
     * @return      Single Matrix representing all matrices concatenated
     */
    public Matrix concatenate(ArrayList<Matrix> t){
        Matrix result = null;
        if(t.size() > 1){
            for(int i = 1; i < t.size(); i++){
                if(result == null){
                    result = t.get(i-1).multiply(t.get(i));
                }else{
                    result = result.multiply(t.get(i));
                }
            }
        }else if(t.size() == 1){
            result = t.get(0);
        }else{
            System.out.println("No transformations have been selected.");
        }
        return result;
    }//concatenate()
    
    /**
     * Applies a transformation to a list of lines.
     * @param transMatrix   Matrix representation of transformation(s) to be applied
     * @param datalines     List of data lines to apply transformation
     * @return              List of resulting data lines after transformations applied
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
    }//applyTransformation()
    
    /**
     * Reads a file and saves sets of coordinates.
     * These coordinates are two points of a line.
     * @return  ArrayList of objects with type DataLine
     */
    public ArrayList<DataLine> inputLines(){
        ArrayList<DataLine> lines = new ArrayList<>();
        File datalines; 
        try{
            //datalines = new File("/Users/Lou Man Chu/Downloads/datalines.txt");
            datalines = new File("/Users/Lou/Desktop/datalines.txt");
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
    }//inputLines()
    
    /**
     * Writes coordinates of DataLine objects to a text file.
     * @param outLines
     */
    public void outputLines(ArrayList<DataLine> outLines){
        
        try{
            String homeFolder = System.getProperty("user.home");
            outputFile = new File(homeFolder, "outputLines.txt");
            fw = new FileWriter(outputFile.getAbsoluteFile());
            bw = new BufferedWriter(fw);
        }catch(IOException e){
            System.out.println("Error in outputLines in Transformation.java: " + e.getMessage());
        }
        for(DataLine line : outLines){
            try{
                String yo = line.getX1() + " " + line.getY1() + " " + line.getX2() + " " + line.getY2();
                //System.out.println(yo);
                bw.write(yo);
                bw.newLine();
            }catch(IOException e){
                System.out.println("Error in outputLines - writing to file: " + e.getMessage());
            }
        }
        
        try{
            bw.close();
        }catch(IOException e){
            System.out.println("Error closing bufferedwriter: " + e.getMessage());
        }
    }//outputLines
    
}//class