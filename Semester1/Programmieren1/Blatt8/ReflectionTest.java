/**
 * Program for task sheet 8
 * 
 * Exercise 8a - Reflection
 * 
 * This is the reflection test class.
 * Further classes for this task can be found in the files Transport.java, Truck.java and Ship.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void main(String[] args) {
        //First test to set the field name of a truck with reflection.
        Transport truck = new Truck("Optimus Prime");
        System.out.println("Old truck name: " + truck.getName());
        try{
            Class<?> c = Truck.class;
            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(truck, "Reflection");
            field.setAccessible(false);
            System.out.println("New truck name: " + truck.getName() + "\n");
        }catch(Exception e){
            e.printStackTrace();
        }

        //Second test to set the field name of a truck with reflection.
        Ship ship = new Ship("Black Pearl");
        System.out.println("Old ship name: " + ship.getName());
        try{
            Class<?> c = Ship.class;
            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(ship, "Reflection");
            field.setAccessible(false);
            System.out.println("New ship name: " + ship.getName() + "\n");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //Use the method printInfos to print all infos with reflection for the three classes.
        printInfos(Transport.class);
        printInfos(Truck.class);
        printInfos(Ship.class);

    }

    /**
     * This method prints the classname, the modifier, the superclass and all methods (name, modifier, returntype).
     * @param c Class to print the infos.
     */
    public static void printInfos(Class<?> c){
        String className = c.getName();
        System.out.println("Classname: " + className);
        System.out.println(className + " is " + Modifier.toString(c.getModifiers()) + ".");
        System.out.println("Superclass is " + c.getSuperclass());

        System.out.println("Methods:");
        Method[] cMethods = c.getMethods();
        for(int i=0;i<cMethods.length;i++){
            Method m = cMethods[i];
            System.out.println(m.getName() + " is " + Modifier.toString(m.getModifiers()) +" and returns " + m.getReturnType());
        }

        System.out.println("");
    }
}
