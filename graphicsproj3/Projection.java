
package graphicsproj3;

import java.util.ArrayList;

/**
 * Perspective Projection.
 * Class simply extends Drawer class created in first project 
 * and adds Cohen-Sutherland line clipping to the Bresenham
 * line drawing function.
 * @author Lou
 * @since 10/14/2014
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
    }//constructor
    
    /**
     * Overrides display function.
     * Creates a JFrame for this instance of the Projection class.
     */
    @Override
    public void display(){
        super.display();
    }//display()
    
    /**
     * Draws lines given a list of DataLine coordinates.
     * @param lines list of DataLine objects to be drawn and clipped
     */
    public void draw(ArrayList<DataLine> lines){
        lines
                .stream()
                .forEach(t -> { 
                    applyClipping(t.getX1(), t.getY1(), t.getX2(), t.getY2());
                });

        //bresenham((int)lines.get(0).getX1(), (int)lines.get(0).getY1(), (int)lines.get(0).getX2(), (int)lines.get(0).getY2(), 0);
        System.out.println("Line drawn.");
    }//draw()
    
    /**
     * Creates a representation of user-defined viewport.
     * Note: If the user does not define a viewport, a default viewport is set to:
     * vx0 = 10, vy0 = 10
     * vx1 = 500, vy1 = 500
     * @param vx0   integer, minimum x value of viewport
     * @param vy0   integer, minimum y value of viewport
     * @param vx1   integer, maximum x value of viewport
     * @param vy1   integer, maximum y value of viewport
     */
    public void setViewport(int vx0, int vy0, int vx1, int vy1){
        this.vx0 = vx0;
        this.vy0 = vy0;
        this.vx1 = vx1;
        this.vy1 = vy1;
        //Draw the borders of the viewport to give user a visual of
        //the viewport they defined.
        bresenham(vx0, vy0, vx0, vy1, 0);
        bresenham(vx0, vy1, vx1, vy1, 0);
        bresenham(vx1, vy0, vx1, vy1, 0);
        bresenham(vx0, vy0, vx1, vy0, 0);
    }//setViewport()
    
    /**
     * Getter method to retrieve maximum x value of viewport.
     * @return  integer value of the maximum x value of the viewport
     */
    public int getxMax(){
        return this.vx1;
    }//getxMax()
    
    /**
     * Getter method to retrieve minimum x value of viewport.
     * @return  integer value of the minimum x value of the viewport
     */
    public int getxMin(){
        return this.vx0;
    }//getxMin()
    
    /**
     * Getter method to retrieve maximum y value of viewport.
     * @return  integer value of the maximum y value of the viewport
     */
    public int getyMax(){
        return this.vy1;
    }//getyMax()
    
    /**
     * Getter method to retrieve minimum y value of viewport.
     * @return  integer value of the minimum y value of the viewport
     */
    public int getyMin(){
        return this.vy0;
    }//getyMin()
    
    /**
     * Determines which region coordinate is in according to Cohen-Sutherland
     * line clipping algorithm.
     * @param x     double value, x-coordinate
     * @param y     double value, y-coordinate
     * @return      integer value, represents which region coordinate is in
     */
    public int code(double x, double y){
        int result = inside;
        if(x < vx0){
            result += left;
        }else if(x > vx1){
            result += right;
        }
        if(y < vy0){
            result += bottom;
        }else if(y > vy1){
            result += top;
        }
        return result;
    }//code()
    
    /**
     * Applies Cohen-Sutherland Line Clipping Algorithm to line coordinates.
     * This C++ implementation can be found in the following Wikipedia page:
     * http://en.wikipedia.org/wiki/Cohen%E2%80%93Sutherland_algorithm
     * After determining which region the coordinate lies in using the above
     * code() method, we can determine if the coordinate are complete visible, 
     * completely invisible, or partially visible. If partially visible, the
     * slope formula is used to determine the intersection point of the line
     * with a border of the viewport. The algorithm is re-applied to the
     * lines separated by the intersection point.
     * @param x0    double, x-coordinate of one end of a line
     * @param y0    double, y-coordinate of one end of a line
     * @param x1    double, x-coordinate of other end of a line
     * @param y1    double, y-coordinate of other end of a line
     */
    public void applyClipping(double x0, double y0, double x1, double y1){
        boolean visible = false;
        int code0 = code(x0, y0);
        int code1 = code(x1, y1);
        while(true){
            if((code0 | code1) == 0){
                System.out.println("Completely visible.");
                visible = true;
                break;
            }else if((code0 & code1) != 0){
                System.out.println("Complete invisible");
                break;
            }else{
                double x = 0;
                double y = 0;
                int codeOut = (code0 != 0) ? code0: code1;
                if((codeOut & top) != 0){
                    x = x0 + (x1 - x0) * (vy1 - y0) / (y1 - y0);
                    y = vy1;
                    System.out.println("Above clip rectangle. " + x + ", " + y);
                }else if((codeOut & bottom) != 0){
                    x = x0 + (x1 - x0) * (vy0 - y0) / (y1- y0);
                    y = vy0;
                    System.out.println("Below clip rectangle.");
                }else if((codeOut & right) != 0){
                    y = y0 + (y1 - y0) * (vx1 - x0) / (x1 - x0);
                    x = vx1;
                    System.out.println("Right of clip rectangle");
                }else if((codeOut & left) != 0){
                    y = y0 + (y1  - y0) * (vx0 - x0) / (x1 - x0);
                    x = vx0;
                    System.out.println("Left of clip rectangle.");
                }
                if(codeOut == code0){
                    x0 = x;
                    y0 = y;
                    code0 = code(x0, y0);
                }else{
                    x1 = x;
                    y1 = y;
                    code1 = code(x1, y1);
                }
            }
        }
        if(visible){
            bresenham((int)x0, (int)y0, (int)x1, (int)y1, 0);
        }
    }//applyClipping()
    
}//class
