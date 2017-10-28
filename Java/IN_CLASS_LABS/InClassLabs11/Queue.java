import java.util.*;
/**
 * A LILO queue of objects.
 * -- "implements" QueueInterface
 * -- implemented using an ArrayList
 * -- the front of the queue is at index 0
 * -- the back of the queue is at largest index used
 * 
 * @author McCauley
 */
public class Queue implements IntQueueInterface
{
    // the stack is implemented using an ArrayList
    private ArrayList<Integer> q;

    /**
     * Constructor for objects of class Stack
     */
    public Queue()
    {
        // initialise instance variables
        q = new ArrayList<Integer>();
    }

    /**
     * item is added to the back of the queue
     */
    public void enqueue(int item){
       q.add(0,item);
        
    }
    
    /**
     * item at front of queue is removed and returned
     * Precondition: stack is not empty.
     * **** User should verify that stack is not empty, 
     * **** before calling this method.
     */
    public int dequeue(){
        
        int takeOut = q.get(q.size()-1);
        q.remove(q.size()-1);
        
       return takeOut;
        
    }
    
    /**
     * Number of items in queue 
     */
    public int size(){
        return q.size();
    }
    
    /**
     * true when stack contains no items, false otherwise
     */
    public boolean isEmpty(){
        return q.size() == 0;
    }
}
