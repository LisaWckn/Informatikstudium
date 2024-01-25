/**
 * Program for task sheet 8
 * 
 * Exercise 8a - Reflection
 * 
 * This is the Ship class a subclass of the Transport class. The test class could be find in ReflectionTest.java.
 * Further classes for this task can be found in the files Transport.java and Truck.java.
 * 
 * @author Lisa Weickenmeier
 */

/**
 * This class is only for the reflection test. The methods don't have much functions.
 * Most are simple getter and setter methods.
 */

public class Ship extends Transport {
    private String name;

    public Ship(String name){
        super("Ship");
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getCosts(){
        return super.getCosts();
    }

    public void setCosts(int costs){
        super.setCosts(costs);
    }

    public void deliver(){}
}
