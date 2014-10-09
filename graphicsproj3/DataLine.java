
package graphicsproj3;

/**
 *
 * @author Lou
 */
public class DataLine {
    
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    
    public DataLine(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public double getX1(){
        return this.x1;
    }
    
    public double getY1(){
        return this.y1;
    }
    
    public double getX2(){
        return this.x2;
    }
    
    public double getY2(){
        return this.y2;
    }
}
