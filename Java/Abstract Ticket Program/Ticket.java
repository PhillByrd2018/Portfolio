
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * This class is where me create the basic model for the TICKET classes to follow
 * We only set the number from here and have a toString method to print the contents of the object
 */
public abstract class Ticket
{
    private int ticketNum;
    
    public Ticket(int number){
        this.ticketNum = number;
    }
    // this method is abstract so we can let subclass define the price
    public abstract double getPrice();
    // Here we are going to return only the name and the price of each ticket
    public String toString(){
        return "Ticket Number: " + this.ticketNum + "\n" + "Ticket Price: " + "$" + this.getPrice();
    }
}
