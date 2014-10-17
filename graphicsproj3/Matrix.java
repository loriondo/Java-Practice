
package graphicsproj3;

import static java.lang.System.out;
/**
 * Matrix.java.
 * Class used to represent the mathematical representation
 * of a Matrix.
 * @author Lou
 * @since 10/14/2014
 */
public class Matrix {
    
    public double[][] matrix;
    public String type;
    int rows, columns;
    public int angle;
    
    /**
     * Constructor.
     * Creates an identity matrix.
     * @param rows      integer number of rows in the matrix
     * @param columns   integer number of columns in the matrix
     */
    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        matrix = new double[this.rows][this.columns];
        type = "result";
        
        //create identity matrix
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                matrix[i][j] = (i == j) ? 1 : 0;
                //if i is equal to j set value to 1 
                //otherwise set value to 0
            }
        }
    }//constructor
    
    /**
     * createMatrix().
     * Creates a matrix object from a 2D array.
     * @param input 2D array of doubles
     * @return      Matrix object that is contains values from 2D array
     */
    public Matrix createMatrix(double[][] input){
        int row = input.length;
        int col = input[0].length;
        Matrix result = new Matrix(row, col);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result.setValue(row, col, input[i][j]);
            }
        }
        
        return result;
    }//createMatrix
    
    /**
     * getXFromMatrix().
     * Retrieves x-coordinate from a coordinate matrix,
     * represented by 1x3 2D Array.
     * @return      x-coordinate represented as a double
     */ 
    public double getXFromMatrix(){
        double x = 0;
        if(this.type.equals("coordinates")){
            x = matrix[0][0];
        }
        return x;
    }//getXFromMatrix()
    
    /**
     * getYFromMatrix().
     * Retrieves y-coordinate from a coordinate matrix.
     * @return      y-coordinate represented as a double
     */
    public double getYFromMatrix(){
        double y = 0;
        if(this.type.equals("coordinates")){
            y = matrix[0][1];
        }
        return y;
    }
    /**
     * getNumRows().
     * Retrieves the number of rows this matrix object has.
     * @return      integer amount of rows in the matrix
     */
    public int getNumRows(){
        return this.rows;
    }//getNumRows
    
    /**
     * getNumColumns().
     * Retrieves the number of columns this matrix object has.
     * @return      integer amount of columns in the matrix
     */
    public int getNumColumns(){
        return this.columns;
    }//getNumColumns
    
    /**
     * getRow().
     * Retrieves the row at 'index' located in the matrix object.
     * @param index location of the row desired in the matrix object
     * @return      array of double values in desired row
     */
    public double[] getRow(int index){
        double[] temp = new double[rows];
        for(int i = 0; i < columns; i++){
            temp[i] = matrix[index][i];
            //out.println(temp[i]);
        }
        return temp;
    }//getRow
    
    /**
     * getColumn().
     * Retrieves the column at 'index' located in matrix object.
     * @param index location of column desired in the matrix object
     * @return      array of double values in desired column
     */
    public double[] getColumn(int index){
        double[] temp = new double[columns];
        for(int i = 0; i < rows; i++){
            temp[i] = matrix[i][index];
            //out.println(temp[i]);  
        }
        return temp;
    }//getColumn
    
    /**
     * setType().
     * Sets the transformation type of the matrix, either 'translation', 'scale', 
     * or 'coordinates'. Also sets the values transformation values within the matrix.
     * i.e. Sets tx and ty of translation transformation.
     * @param type  string representation of transformation type 
     * @param x     double value of x-coordinate/x transformation
     * @param y     double value of y-coordinate/y transformation
     */
    public void setType(String type, double x, double y){
        this.type = type;
        if(type.equals("translation")){
            matrix[2][0] = x;
            matrix[2][1] = y;
        }else if (type.equals("scale")){
            matrix[0][0] = x;
            matrix[1][1] = y;
        }else if(type.equals("coordinates")){
            matrix[0][0] = x;
            matrix[0][1] = y;
            matrix[0][2] = 1;
        }
    }//setType
    
    /**
     * setType().
     * Sets the transformation type of the matrix.
     * @param type      string representation of transformation type
     */
    public void setType(String type){
        this.type = type;
    }//setType()
    
    /**
     * setType().
     * Sets transformation type of matrix to 'rotation'. Also sets the angle
     * of which to rotate data lines. 
     * @param type      string with value 'rotation'
     * @param angle     integer value for angle, in degrees
     */
    public void setType(String type, int angle){
        this.type = type;
        matrix[0][0] = Math.cos(Math.toRadians(angle));
        matrix[0][1] = -1 * Math.sin(Math.toRadians(angle));
        matrix[1][0] = Math.sin(Math.toRadians(angle));
        matrix[1][1] = Math.cos(Math.toRadians(angle));
    }//setType
    
    /**
     * setValue().
     * Sets values inside a matrix at location (row, col) to a double.
     * @param row integer index within a row inside a Matrix
     * @param col integer index within a column inside a Matrix
     * @param val 
     */
    public void setValue(int row, int col, double val){
        matrix[row][col] = val;
    }//setValue
    
    /**
     * multiply().
     * Multiplies two matrices.
     * @param mat   matrix to be multiplied by.
     * @return      "result" matrix created from two multiplied matrices.
     * @see         http://stackoverflow.com/questions/4111393/get-the-size-of-a-2d-array
     */
    public Matrix multiply(Matrix mat){
        Matrix result = new Matrix(this.rows, mat.columns);
        double[][] temp = new double[this.rows][mat.columns];
        //multiplies matrices using algorithm found above
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < mat.columns; j++){
                for(int k = 0; k < this.columns; k++){
                   temp[i][j] += this.matrix[i][k] * mat.matrix[k][j];
                   //System.out.println(temp[i][j] + " = " + this.matrix[i][k] + " * " + mat.matrix[k][j]);
                }
            }
        }
        //then converts 2d array into matrix object
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < mat.columns; j++){
                result.setValue(i, j, temp[i][j]);
            }
        }
        return result;
    }//multiply
    
    /**
     * displayMatrix().
     * Displays string representation of a Matrix. Used for debugging purposes.
     * If wanting to display a Matrix, see draw() method in Projection.java.
     * @see Projection.java
     */
    public void displayMatrix(){
        out.println(type + " matrix.");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                out.print(" | " + matrix[i][j]);
            }
            out.println(" |");
        }
    }//displayMatrix
    
}//Matrix.java