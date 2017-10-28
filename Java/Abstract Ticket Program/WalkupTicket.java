
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * This is my walkup ticket. Only one price option available. 
 */
public class WalkupTicket extends Ticket
{
    private final double WALKUP = 50.00;
    //Call in the super and passing the ticket Number
    public WalkupTicket(int number){
        super(number);

    }
    //only one option so just return the WALKUP pricing.
    public double getPrice(){
        
        return WALKUP;
    }
    //Call the super toString to print the contents of this walkup ticket object		
    public String toString(){
        return super.toString() + "\n";
        
    }
}
