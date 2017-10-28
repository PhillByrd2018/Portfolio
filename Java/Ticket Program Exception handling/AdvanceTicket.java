
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * Here is the first class that we can make objects from and we have two seperate prices that we can offer 
 * depending on how far away the date of the event is
 */

public class AdvanceTicket extends Ticket 
{

    private int daysUntil;
    private double price;
    private double AdvancedEarly = 30.00;
    private double Advanced = 40.00;
    
    public AdvanceTicket(int num, int days) throws BadTicketNumberException, BadDaysRangeException{
        super(num);
        if(days <= 0){
            throw new BadDaysRangeException("Exception: "+ days +"Days in	advance	specified	must	be	positive.");
        }
        else if(days>180){
            throw new BadDaysRangeException("Exception:	Cannot	sell	a	ticket	with "+ days +"days	in	advance.");
        }

        this.daysUntil = days;

    }
    //     Here we are setting the price to 30 if the event is 10 days away or more, otherwise it's 40
    public double getPrice(){

        if(this.daysUntil>=10){
            this.price = AdvancedEarly;

        }else if(this.daysUntil<10){
            this.price = Advanced;

        }

        return this.price;
    }

    //     Here we are calling the super toString method to print the contents of the ticket object
    public String toString(){
        return super.toString() + "\n";    
    }
}
