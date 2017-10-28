
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

    int daysUntil;
    double price;
    public AdvanceTicket(int num, int days){
        super(num);

        this.daysUntil = days;

    }
    //     Here we are setting the price to 30 if the event is 10 days away or more, otherwise it's 40
    public double getPrice(){

        if(this.daysUntil>=10){
            this.price = 30.00;

        }else if(this.daysUntil<10){
            this.price = 40.00;

        }

        return this.price;
    }

    //     Here we are calling the super toString method to print the contents of the ticket object
    public String toString(){
        return super.toString() + "\n";    
    }
}
