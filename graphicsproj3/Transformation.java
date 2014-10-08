
package graphicsproj3;

/**
 *
 * @author Lou
 */
public class Transformation {
    
    public Matrix coordinates(int x, int y){
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
}
