

/**
 * Inheritance.java.
 * A short program to understand and practice with 
 * Inheritance, overloading, and polymorphism.
 * 
 * @author Lou Man Chu
 * @since 09/21/2014
 */
public class Inheritance {

    /**
     * Main.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Car car1 = new Car();
        car1.setMake("Nissan");
        car1.setModel("Altima");
        car1.setYear(2014);
        car1.setNumDoors(4);
        car1.printInfo();
        
        Car car2 = new Car("Nissan", "Maxima", 2014, 4);
        car2.printInfo();
        
        Truck truck1 = new Truck();
        truck1.setMake("Nissan");
        truck1.setModel("Frontier.");
        truck1.setYear(2014);
        truck1.setNumDoors(4);
        truck1.setCabType("Crew cab.");
        truck1.setCityMPG(19);
        truck1.setHighwayMPG(23);
        truck1.setEngine("V6");
        truck1.setPrice(23440);
        truck1.setTowingCapacity(3500);
        truck1.setHorsepower(460);
        truck1.printInfo();
        
    }//main
    
}//class
