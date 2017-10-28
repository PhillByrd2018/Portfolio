
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * This is a subclass to Advance ticket. This class just offers student discount prices to Advanced tickets, 
 * and the ID is required
 * 
 */
public class StudentAdvanceTicket extends AdvanceTicket
{

    //Here the constructor is calling Advanced ticket and passing number and days until the event to 
    //calculate the price for the student tickets later
    public StudentAdvanceTicket(int num, int days){
        super(num,days);

    }

    //     Here we are returning the price for a student ticket depending on the days passed
    public double getPrice(){
        if(daysUntil>=10){
            this.price = 15.00;

        }else if(daysUntil<10){
            this.price = 20.00;

        }
        return this.price;
    }

    // Just like in the Advance ticket we are call the Ticket Super Class toString method to print the contents
    // of the object
    public String toString(){
        return super.toString()+"(ID Required)" + "\n";

    }
}
