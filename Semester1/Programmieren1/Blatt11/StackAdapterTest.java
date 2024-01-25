/**
 * Program for task sheet 11
 * 
 * Exercise 11b - Stack
 * 
 * This is the test class.
 * Further classes/interfaces for this exercise can be found in the files StackAdapter.java and Stack.java.
 * 
 * @author Lisa Weickenmeier
 */

public class StackAdapterTest {
    public static void main(String[] args) {
        StackAdapter stack = new StackAdapter();
        System.out.println(stack.empty());
        stack.push("abc");
        stack.push(1);
        System.out.println(stack.peek().toString());
        System.out.println(stack.pop().toString());
        System.out.println(stack.empty());
        System.out.println(stack.pop().toString());
        stack.pop();
    }
}
