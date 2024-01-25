/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5a - Memory
 * 
 * This is the test class. The Memory class could be find in Memory.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class MemoryTest {
    public static void main(String[] args) {
        Memory memory = new Memory();
        System.out.println("First test with n=4:");
        int[][] memoryField = memory.generateField(4);
        memory.printField(memoryField);

        System.out.println("\nSecond test with n=6:");
        int[][] memoryField1 = memory.generateField(6);
        memory.printField(memoryField1);
    }
}
