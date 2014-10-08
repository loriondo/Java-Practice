
package graphicsproj3;

import static java.lang.System.out;
/**
 *
 * @author Lou
 */
public class Matrix {
    
    public double[][] matrix;
    public String type;
    int rows, columns;
    public int angle;
    
    /**
     * Constructor.
     * @param rows
     * @param columns
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
     * @param input
     * @return 
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
     * 
     * @return 
     */
    public int getNumRows(){
        return this.rows;
    }//getNumRows
    
    /**
     * 
     * @return 
     */
    public int getNumColumns(){
        return this.columns;
    }//getNumColumns
    
    /**
     * getRow
     * @param index
     * @return 
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
     * 
     * @param index
     * @return 
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
     * 
     * @param type 
     * @param x 
     * @param y 
     */
    public void setType(String type, int x, int y){
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
     * 
     * @param type
     * @param angle 
     */
    public void setType(String type, int angle){
        this.type = type;
        matrix[0][0] = Math.cos(Math.toRadians(angle));
        matrix[0][1] = -1 * Math.sin(Math.toRadians(angle));
        matrix[1][0] = Math.sin(Math.toRadians(angle));
        matrix[1][1] = Math.cos(Math.toRadians(angle));
    }//setType
    
    /**
     * 
     * @param row
     * @param col
     * @param val 
     */
    public void setValue(int row, int col, double val){
        matrix[row][col] = val;
    }//setValue
    
    /**
     * multiply().
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
     * 
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
    
}
