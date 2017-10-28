
/**
 * 
 * 
 * @author Phillip Byrd
 * @version 04.04.2017
 * 
 * This is my test driver. I have made several objects in every type of ticket 
 * that is available 
 */
public class TestTickets
{
    public static void main(String[] args){

        AdvanceTicket demo1 = new AdvanceTicket(117, 21);
        System.out.println(demo1);

        StudentAdvanceTicket demo2 = new StudentAdvanceTicket(213, 5);
        System.out.println(demo2);
        
        StudentAdvanceTicket demo6 = new StudentAdvanceTicket(300, 11);
        System.out.println(demo6);
         
        WalkupTicket demo7 = new WalkupTicket(491);
        System.out.println(demo7);

        AdvanceTicket demo3 = new AdvanceTicket(119, 9);
        System.out.println(demo3);

        WalkupTicket demo4 = new WalkupTicket(756);
        System.out.println(demo4);

    }
}
