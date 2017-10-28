
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * This class is where me create the basic model for the TICKET classes to follow
 * We only set the number from here and have a toString method to print the contents of the object
 */
public abstract class Ticket implements Comparable
{
    private static int[] TickArray = {};
    private int ticketNum;
    
    // in this class we are checking for good ticket numbers and making sure they have not been used already

    public Ticket(int number) throws BadTicketNumberException{
        if(number <= 0){
            throw new BadTicketNumberException("Exception:  Cannot  sell    ticket  number"  + number+".    Invalid number  provided.");
        }

        int[] TickArraynew = new int[TickArray.length+1];

        for(int y = 0; y < TickArray.length;y++){
            if(TickArray[y] == number){
                throw new BadTicketNumberException("Exception:  Cannot  sell    ticket  number " + number +".   Ticket  number  already in  use.");
            }
            TickArraynew[y] = TickArray[y];
        }

        this.ticketNum = number;
        TickArraynew[TickArray.length] = ticketNum;
        TickArray = TickArraynew;

    }
    // this method will tell the difference in the ticket numbers of two objects of the ticket class
    public int compareTo(Object a){
        Ticket test = (Ticket) a;

        if(this.ticketNum == test.ticketNum){
            return this.ticketNum - test.ticketNum;
        }else if(this.ticketNum < test.ticketNum){
            return this.ticketNum - test.ticketNum;
        }
        else{
            return this.ticketNum - test.ticketNum;

        }

    }

    // this method is abstract so we can let subclass define the price
    public abstract double getPrice();
    // Here we are going to return only the name and the price of each ticket
    public String toString(){
        return "Ticket Number: " + this.ticketNum + "\n" + "Ticket Price: " + "$" + this.getPrice();
    }

}
