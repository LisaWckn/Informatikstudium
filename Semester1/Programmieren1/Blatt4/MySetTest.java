/**
 * Programm zum Aufgabenblatt 4
 * 
 * Aufgabe 4 - MySet
 * 
 * This is the test class. The MySet class could be find in MySet.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class MySetTest {
    public static void main(String[] args) {
        //test task 4a 
        System.out.println("Test 4a: ");
        int[] set = {3,4,6,1,2,5};
        MySet mySet = new MySet(set);
        System.out.print("Set at the beginning: ");
        mySet.printSet();

        System.out.println("Sets after adding something: ");
        mySet.addToSet(10);
        mySet.printSet();
        
        int[] setToAdd = {3,7,2,5,3,17};
        MySet mySetToAdd = new MySet(setToAdd);
        mySet.addToSet(mySetToAdd);
        mySet.printSet();

        //test task 4b
        System.out.println("\nTest 4b:\nSets after removing: ");
        mySet.removeFromSet(3);
        mySet.printSet();
        int[] setToRemove = {11,6,15};
        MySet mySetToRemove = new MySet(setToRemove);
        mySet.removeFromSet(mySetToRemove);
        mySet.printSet();

        //test task 4c
        System.out.println("\nTest 4c:\nSet after sorting: ");
        int[] sortedSet = mySet.sort();
        MySet mySortedSet = new MySet(sortedSet);
        mySortedSet.printSet();

    }
}
