/**
 * Program for task sheet 11
 * 
 * Exercise 11b - Stack
 * 
 * This is the Stack interface.
 * Further classes for this exercise can be found in the files StackAdapterTest.java and StackAdapter.java.
 * 
 * @author Lisa Weickenmeier
 */

public interface Stack<T> {
    /**
     * Method to check if the stack is empty.
     * @return true if the stack is empty, else return false.
     */
    public boolean empty();

    /**
     * Method to add an objekt at the top of the ArrayList _stack.
     * @param item Item to push to the stack.
     * @return Returnes the objekt which is pushed.
     */
    public T push(T item);

    /**
     * Method to get and remove the top element of the stack.
     * @return element at the top. 
     */
    public T pop();

    /**
     * Method to get the top element of the stack without deleting it.
     * @return element at the top.
     */
    public T peek();
}
