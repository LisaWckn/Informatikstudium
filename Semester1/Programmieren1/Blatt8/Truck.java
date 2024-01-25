/**
 * Program for task sheet 8
 * 
 * Exercise 8a - Reflection
 * 
 * This is the Truck class a subclass of the Transport class. The test class could be find in ReflectionTest.java.
 * Further classes for this task can be found in the files Transport.java and Ship.java.
 * 
 * @author Lisa Weickenmeier
 */

/**
 * This class is only for the reflection test. The methods don't have much functions.
 * Most are simple getter and setter methods.
 */

public class Truck extends Transport{
    private String name;

    public Truck(String name){
        super("Truck");
        this.name = name;
    }

    public int getCosts(){
        return super.getCosts();
    }

    public String getName(){
        return name;
    }

    public void setCosts(int costs){
        super.setCosts(costs);
    }

    public void deliver(){}
}
