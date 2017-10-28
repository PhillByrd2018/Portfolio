
/**
 * QueueInterface provides the required methods for any queue
 * 
 * @author McCauley
 */
public interface IntQueueInterface
{
    // enqueue; add element to the back of a Queue
    public void enqueue(int element );  
    
    // dequeue; remove and return element at front of Queue
    public int dequeue (  ); 
    
    // return true if Queue contains no elements, false otherwise
    public boolean isEmpty ( ); 
    
    // return the number of elements in the stack
    public int size( );  

}
