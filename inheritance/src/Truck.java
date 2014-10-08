


import static java.lang.System.out;

/**
 * Truck.java.
 * Extends Car class to describe specific type of vehicle: Trucks.
 * Includes detailed information about a truck including engine type, 
 * horsepower, estimated MPG, cab type, price, etc.
 * 
 * @author Lou Man Chu
 * @see Car.java
 * @since 09/21/2014
 */
public class Truck extends Car{
    
    public int highwayMPG, cityMPG;
    public int horsepower;
    public String engine;
    public String cabType;
    public int price;
    public int towingCapacity;
    
    /**
     * Constructor.
     */
    public Truck(){
        super(); //calls constructor of superclass, Car.java
    }//truck
    
    /**
     * Constructor.
     * @param make
     * @param model
     * @param year
     * @param numDoors 
     */
    public Truck(String make, String model, int year, int numDoors){
        super(make, model, year, numDoors); //calls constructor of superclass, Car.java)
    }//Truck()
    
    /**
     * Constructor.
     * Long version used to create new Truck. Too lengthy to be used, will
     * simply use setter methods instead.
     * @param make
     * @param model
     * @param year
     * @param numDoors
     * @param horsepower
     * @param highwayMPG
     * @param cityMPG
     * @param engine
     * @param cabType
     * @param price
     * @param towingCapacity 
     */
    public Truck(String make, String model, int year, int numDoors, int horsepower, 
            int highwayMPG, int cityMPG, String engine, String cabType, int price, int towingCapacity){
        super(make, model, year, numDoors); //calls constructor of superclass
        this.highwayMPG = highwayMPG;
        this.cityMPG = cityMPG;
        this.engine = engine;
        this.cabType = cabType;
        this.price = price;
        this.towingCapacity = towingCapacity;
    }//Truck()
    
    /**
     * Setter.
     * Sets EPA estimated highway miles per gallon of the truck.
     * @param mpg Integer estimated miles per gallon
     */
    public void setHighwayMPG(int mpg){
        this.highwayMPG = mpg;
    }//setHighwayMPG
    
    /**
     * Setter.
     * Sets EPA estimated city miles per gallon of the truck
     * @param mpg Integer miles per gallon
     */
    public void setCityMPG(int mpg){
        this.cityMPG = mpg;
    }//setCityMPG
    
    /**
     * Setter.
     * Sets the engine type of the truck, i.e. V6, V8
     * @param engine string representation of engine type
     */
    public void setEngine(String engine){
        this.engine = engine;
    }//setEngine
    
    /**
     * Setter.
     * Sets the cab type of the truck, i.e. crew cab
     * @param type string representation of cab type
     */
    public void setCabType(String type){
        this.cabType = type;
    }//setCabType
    
    /**
     * Setter.
     * Sets the estimated price of the truck (MSRP).
     * @param price integer representation of MSRP
     */
    public void setPrice(int price){
        this.price = price;
    }//setPrice
    
    /**
     * Setter.
     * Sets towing capacity of the truck, in pounds.
     * @param capacity integer value of trucks maximum pounds able to tow
     */
    public void setTowingCapacity(int capacity){
        this.towingCapacity = capacity;
    }//setTowingCapacity
    
    /**
     * Setter.
     * Sets maximum horsepower of the truck.
     * @param hp 
     */
    public void setHorsepower(int hp){
        this.horsepower = hp;
    }//setHorsepower
    
    /**
     * Getter.
     * Gets both highway and city MPG of truck.
     * @return integer array, first index is highway mpg, second is city mpg
     */
    public int[] getMPG(){
        int[] mpg = new int[2];
        mpg[0] = this.highwayMPG;
        mpg[1] = this.cityMPG;
        return mpg;
    }//getMPG
    
    /**
     * Getter.
     * @return integer value, number of horses truck has under engine
     */
    public int getHorsepower(){
        return this.horsepower;
    }//getHorsepower
    
    /**
     * Getter.
     * @return string representation of engine type
     */
    public String getEngine(){
        return this.engine;
    }//getEngine
    
    /**
     * Getter.
     * @return string representation of truck cab type
     */
    public String getCabType(){
        return this.cabType;
    }//getCabType
    
    /**
     * Getter.
     * @return integer value of MSRP for truck
     */
    public int getPrice(){
        return this.price;
    }//getPrice
    
    /**
     * Getter.
     * @return integer value of trucks towing capacity
     */
    public int getTowingCapacity(){
        return this.towingCapacity;
    }//getTowingCapacity
    
    /**
     * printInfo().
     * Overrides printInfo method in superclass. Displays same information as
     * method in superclass, but also extends description to include the 
     * additional descriptions added in this class.
     */
    @Override
    public void printInfo(){
        super.printInfo();
        out.println("Displaying additional Truck information.");
        out.println("Estimated MPG:\t\t" + this.cityMPG + "/" + this.highwayMPG);
        out.println("Horsepower:\t\t" + this.horsepower);
        out.println("Engine:\t\t\t" + this.engine);
        out.println("Cab type:\t\t" + this.cabType);
        out.println("Towing Capacity:\t" + this.towingCapacity + " lbs.");
        out.println("MSRP:\t\t\t" + "$" + this.price);
        out.println("*- - - - - - - - - - - - - - -*");
    }//printInfo
    
}//class
