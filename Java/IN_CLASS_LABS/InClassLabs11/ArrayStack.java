
/**
 * Write a description of class ArrayStack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrayStack implements IntStackInterface
{
    final int CAP = 100;
    
    // a stack of values stored in an array, starting at index 0 and 
    // growing toward higher index values. If the stack contains four
    // values, they are at indices 0-3, with the last in element at index 3
    private int [] stk;
    private int top; // keep track of the next available spot
                     // if there are 4 elements on stack, top is 4, but
                     // last in element is at index 3
    
    /**
     * Constructor for objects of class ArrayStack
     */
    public ArrayStack()
    {
        // initialise instance variables
        stk = new int [CAP];
        top = 0; // Nothing on stack yet, index of next location to store into
    }

    /**
     * item is added to the top of the stack
     */
    public void push(int item){
        stk[top]= item;
        top++;
    }
    
    /**
     * item at top "removed" by changing index value 
     * Precondition: stack is not empty.
     * **** User should verify that stack is not empty, 
     * **** before calling this method.
     */
    public void pop(){
        top--;
    }
    
    /**
     * returns the value/item at top of stack
     */
    public int top(){
       return stk[top-1];
    }
    
    /**
     * Number of items on stack
     */
    public int size(){
        
        return top; 
    }
    
    /**
     * true when stack contains no items, false otherwise
     */
    public boolean isEmpty(){
        
        return top == 0;
    }
}