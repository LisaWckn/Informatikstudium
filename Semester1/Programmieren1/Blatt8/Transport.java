/**
 * Program for task sheet 8
 * 
 * Exercise 8a - Reflection
 * 
 * This is the Transport class. The test class could be find in ReflectionTest.java.
 * Further classes for this task can be found in the files Truck.java and Ship.java.
 * 
 * @author Lisa Weickenmeier
 */

/**
 * This class is only for the reflection test. The methods don't have much functions.
 * Most are simple getter and setter methods.
 */
public class Transport {
    private int costs;
    private String transportName;

    public Transport(String transportName){
        this.transportName = transportName;
    }

    public String getTransportName(){
        return transportName;
    }

    public int getCosts(){
        return costs;
    }

    public void setCosts(int costs){
        this.costs = costs;
    }

    public String getName(){
        return "";
    }

    public void deliver(){}
}
