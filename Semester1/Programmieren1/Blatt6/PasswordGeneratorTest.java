/**
 * Programm zum Aufgabenblatt 6
 * 
 * Aufgabe 6a - PasswordGenerator
 * 
 * This is the test class. The PasswordGenerator class could be find in PasswordGenerator.java.
 * 
 * @author Lisa Weickenmeier
 */

public class PasswordGeneratorTest {
    public static void main(String[] args) {
        PasswordGenerator pwGen = new PasswordGenerator();
        //first test
        String sentence1 = "1 java ist eine1 objekt-orientierte sprache!";
        System.out.println("First test: \nSentence: " + sentence1);
        pwGen.createPassword(sentence1);
        pwGen.printPassword();

        //second test
        pwGen = new PasswordGenerator();
        String sentence2 = "Java ist auch 2 eine Insel (von Christian Ullenboom)";
        System.out.println("Second test: \nSentence: " + sentence2);
        pwGen.createPassword(sentence2);
        pwGen.printPassword();

        //third test
        pwGen = new PasswordGenerator();
        String sentence3 = "  2  4  ";
        System.out.println("Third test: \nSentence: " + sentence3);
        pwGen.createPassword(sentence3);
        pwGen.printPassword();
    }
}
