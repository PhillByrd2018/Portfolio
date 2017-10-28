import java.util.*;
/**
 * A FILO stack of ints.
 * -- "implements" IntStackInterface
 * -- stack implemented using an ArrayList
 * -- for efficiency purposes, the top of the stack
 * -- is the largest index in use.
 * 
 * @author McCauley
 */
public class Stack implements IntStackInterface
{
    // the stack is implemented using an ArrayList
    private ArrayList<Integer> stk;

    /**
     * Constructor for objects of class Stack
     */
    public Stack()
    {
        // initialise instance variables
        stk = new ArrayList<Integer>();
    }

    /**
     * item is added to the top of the stack
     */
    public void push(int item){
        stk.add(item); // top of stack is at largest index
    }
    
    /**
     * item at top of stack is removed
     * Precondition: stack is not empty.
     * **** User should verify that stack is not empty, 
     * **** before calling this method.
     */
    public void pop(){
        
        stk.remove(stk.size()-1);      
    }
    
    /**
     * returns a reference item at top of stack is returned
     */
    public int top(){
        
        return stk.get(stk.size()-1);
    }
    
    /**
     * Number of items on stack
     */
    public int size(){
        return stk.size();
    }
    
    /**
     * true when stack contains no items, false otherwise
     */
    public boolean isEmpty(){
        return stk.size() == 0;
    }
}
