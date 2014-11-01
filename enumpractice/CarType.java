
package enumpractice;

/**
 * CarType.java.
 * Basic enumeration was only touched for a few minutes in one course at least
 * 2 or 3 semesters ago. After doing research, enumerations would have been a 
 * great piece of knowledge to have while doing various projects for other
 * computer science courses.
 * 
 * More practice to follow.
 * @author Lou
 * @see Enum Types
 */

//enums are good for representing a fixed set of constants
//can include methods and even define the members of the enum
//creating constructor and methods almost like creating a class - 
//enums are an enum class
public enum CarType {
    Truck (4, "truck"),
    Sedan (4, "sedan"),
    Hatchback (5, "hatchback"),
    SUV (4, "SUV"), 
    Coupe (2, "coupe"), 
    Convertible (2, "convetible"),
    Igloo (0, "igloo");
    
    private final int numDoors;
    private final String type;
    
    /**
     * 
     * @param numDoors
     * @param type 
     */
    CarType(int numDoors, String type){
        this.numDoors = numDoors;
        this.type = type;
    }//constructor for enum class
    
    /**
     * Returns number of doors.
     * @return int, door amount
     */
    public int doors() {
        return this.numDoors;
    }//doors
    
    /**
     * Returns car type.
     * @return String, car type - string representation of enum member
     */
    public String carType(){
        return this.type;
    }//carType
    
    /**
     * Returns a basic description of the car.
     * @return String, includes car type and the number of doors
     */
    public String basicDescription(){
        if(this.type.startsWith("i")){ 
            return "This vehicle is an " + this.type + " and has " 
                    + this.numDoors + ".";
        }else{
             return "This vehicle is a " + this.type + " and has " 
                    + this.numDoors + ".";
        }
    }//basicDescription
  
}//class
