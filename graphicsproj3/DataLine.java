
package graphicsproj3;

/**
 * DataLine.java.
 * A DataLine object consists of two coordinates, one for each end of a line.
 * @author Lou
 * @since 10/14/2014
 */
public class DataLine {
    
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    
    /**
     * Constructor.
     * A line is defined by coordinates (x1, y1) and (x2, y2).
     * @param x1    double, value of x1 coordinate    
     * @param y1    double, value of y1 coordinate
     * @param x2    double, value of x2 coordinate
     * @param y2    double, value of y2 coordinate
     */
    public DataLine(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }//constructor
    
    /**
     * Getter method, retrieves x1 coordinate.
     * @return x1 coordinate
     */
    public double getX1(){
        return this.x1;
    }//getX1
    
    /**
     * Getter method, retrieves y1 coordinate.
     * @return  y1 coordinate
     */
    public double getY1(){
        return this.y1;
    }//getY1
    
    /**
     * Getter method, retrieves x2 coordinate.
     * @return x2 coordinate
     */
    public double getX2(){
        return this.x2;
    }//getX2
    
    /**
     * Getter method, retrieves y2 coordinate.
     * @return y2 coordinate
     */
    public double getY2(){
        return this.y2;
    }//getY2
    
}//class
