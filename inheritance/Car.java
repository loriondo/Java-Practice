
package inheritance;

import static java.lang.System.out;

/**
 * Car.java.
 * Class used to describe basic information about a car. 
 * Basic inheritance practice.
 * 
 * @author Lou Man Chu
 * @since 09/21/2014
 */
public class Car {
    
    public String make;
    public String model;
    public int year;
    public int numDoors;
    
    /**
     * Basic Constructor.
     */
    public Car(){
        
    }//Car
    
    /**
     * Constructor.
     * @param make String representation of car brand (i.e. Nissan)
     * @param model String representation of car model (i.e. Murano)
     * @param year Integer value of year car was produced
     * @param numDoors Integer amount of doors car has
     */
    public Car(String make, String model, int year, int numDoors){
        this.make = make;
        this.model = model;
        this.year = year;
        this.numDoors = numDoors;
    }//Car()
    
    /**
     * Setter.
     * Sets the make(brand)of the car.
     * @param make String, car brand
     */
    public void setMake(String make){
        this.make = make;
    }//setMake
    
    /**
     * Setter.
     * Sets the model of the car.
     * @param model String, car model
     */
    public void setModel(String model){
        this.model = model;
    }//setModel
    
    /**
     * Setter.
     * Sets the year the car is produced.
     * @param year Integer, year produced
     */
    public void setYear(int year){
        this.year = year;
    }//setYear
    
    /**
     * Setter.
     * Sets the number of doors a car has.
     * Note that a car can have more than four doors.
     * @param numDoors Integer, number of doors
     */
    public void setNumDoors(int numDoors){
        this.numDoors = numDoors;
    }//setNumDoors
    
    /**
     * Getter.
     * @return string representation of car make (brand).
     */
    public String getMake(){
        return this.make;
    }//getMake
    
    /**
     * Getter.
     * @return string representation of car model.
     */
    public String getModel(){
        return this.model;
    }//getModel
    
    /**
     * Getter.
     * @return integer representation of year car is produced.
     */
    public int getYear(){
        return this.year;
    }//getYear
    
    /**
     * Getter. 
     * @return integer value of number of doors a car has (i.e. 4 doors)
     */
    public int getNumDoors(){
        return this.numDoors;
    }//getNumDoors
    
    /**
     * printInfo().
     * Displays general car information.
     */
    public void printInfo(){
        out.println("*- - - - - - - - - - - - - - -*");
        out.println("Displaying general vehicle information.");
        out.println("Car Make:\t\t" + this.make);
        out.println("Car Model:\t\t" + this.model);
        out.println("Car Year:\t\t" + this.year);
        out.println("Number of Doors:\t" + this.numDoors);
        out.println("*- - - - - - - - - - - - - - -*");
    }//printInfo
    
}//class
