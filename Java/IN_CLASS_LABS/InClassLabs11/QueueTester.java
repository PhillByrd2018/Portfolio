
/**
 * Testing the Queue functionality.
 * 
 * @author (your name) 
 */
public class QueueTester
{
    
    public static void main (String [] args)
    {
        int item1 = 1, item2 = 0, item3 = 4;  
        
        Queue queue = new Queue();    
        queue.enqueue(item2); 
        queue.enqueue(item1); 
        queue.enqueue(item1 + item3);
        item2 = queue.dequeue();
        queue.enqueue(item3*item3); 
        queue.enqueue(item2); 
        queue.enqueue(3);
        item1 = queue.dequeue(); 
        System.out.println(item1 + " " + item2 + " " + item3);
        while (!queue.isEmpty()){
           item1 = queue.dequeue();
           System.out.println(item1);
        }

    }
}
