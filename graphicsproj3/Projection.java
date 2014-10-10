
package graphicsproj3;

import java.util.ArrayList;

/**
 * Perspective Projection.
 * Class simply extends Drawer class created in first project 
 * and adds Cohen-Sutherland line clipping to the Bresenham
 * line drawing function.
 * @author Lou
 */
public class Projection extends Drawer{
    
    private int vx0, vx1, vy0, vy1;
    private final int inside = 0; //0000
    private final int left = 1;   //0001
    private final int right = 2;  //0010
    private final int bottom = 4; //0100
    private final int top = 8;    //1000
    
    /**
     * Constructor.
     */
    public Projection(){
        super();
    }
    
    /**
     * Overrides display function.
     * Creates a display for an instance of the Projection class.
     */
    @Override
    public void display(){
        super.display();
    }
    
    /**
     * Draws lines given a list of coordinates.
     * @param lines 
     */
    public void draw(ArrayList<DataLine> lines){
        lines
                .stream()
                .forEach(t -> {
                   bresenham((int)t.getX1(), (int)t.getY1(), (int)t.getX2(), (int)t.getY2(), 0); 
                });
        
        //bresenham((int)lines.get(0).getX1(), (int)lines.get(0).getY1(), (int)lines.get(0).getX2(), (int)lines.get(0).getY2(), 0);
        System.out.println("Line drawn.");
    }
    
    /**
     * Creates a representation of user-defined viewport.
     * @param vx0
     * @param vy0
     * @param vx1
     * @param vy1 
     */
    public void setViewport(int vx0, int vy0, int vx1, int vy1){
        this.vx0 = vx0;
        this.vy0 = vy0;
        this.vx1 = vx1;
        this.vy1 = vy1;
        
        bresenham(vx0, vy0, vx0, vy1, 0);
        bresenham(vx0, vy1, vx1, vy1, 0);
        bresenham(vx1, vy0, vx1, vy1, 0);
        bresenham(vx0, vy0, vx1, vy0, 0);
    }//setViewport()
    
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public int code(double x, double y){
        int result = inside;
        if(x < vx0){
            result = left;
        }else if(x > vx1){
            result = right;
        }
        if(y < vy0){
            result = bottom;
        }else if(y > vy1){
            result = top;
        }
        return result;
    }
    
    /**
     * 
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     * @return 
     */
    public boolean appplyClipping(double x0, double y0, double x1, double y1){
        //do actual drawing in here, turn into void function?
        boolean visible = false;
        
        return visible;
    }
}
