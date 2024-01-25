/**
 * Program for task sheet 11
 * 
 * Exercise 11b - Stack
 * 
 * This is the StackAdapter class.
 * Further classes/interfaces for this exercise can be found in the files StackAdapterTest.java and Stack.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.util.ArrayList;

public class StackAdapter implements Stack<Object>{
    private ArrayList<Object> _stack = new ArrayList<Object>();

    @Override
    public boolean empty(){
        return _stack.isEmpty();
    }

    @Override
    public Object push(Object item) {
        _stack.add(0, item);
        return item;
    }

    @Override
    public Object pop(){
        try{
            Object top = _stack.get(0);
            _stack.remove(0);
            return top;
        }catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Object peek() {
        try{
            return _stack.get(0);
        }catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }

}