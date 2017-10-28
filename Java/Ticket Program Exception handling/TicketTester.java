import java.io.*; // for use of files
import java.util.*; // for use of Scanner class
/**
 * TicketTester exercises the Ticket hierarchy 
 * and the exception classes in creating an ordered 
 * list of Tickets.
 * 
 * Phillip Byrd 
 * 04.08.2017
 */
public class TicketTester
{

    public static void main(String [] args) {

        try{

            // the following line will throw a FileNotFoundException if 
            // the file specified cannot be found. 
            // DO NOT CHANGE FILE NAME when you submit
            File inputFile = new File("inputFile.txt");

            // add the code that reads from the input file and throws
            Scanner input = new Scanner(inputFile);

            // valid tickets will be stored, in order, in list
            ArrayList<Ticket> list = new ArrayList<Ticket>();
            // The following code reads from the file and 
            // stores Ticket data into an ordered list
            int counter =0;
            while(input.hasNextLine()){
                try{
                    counter++;
                    //System.out.println(input.nextLine());
                    String[] bits = input.nextLine().split(" ");

                    //System.out.println(bits[0]);

                    if (bits[0].equals("1")){
                        WalkupTicket run1 = new WalkupTicket(Integer.parseInt(bits[1]));
                        list.add(0,run1);

                    }
                    //System.out.print(bits[1] + " ");
                    //System.out.println();

                    else if (bits[0].equals("2")){
                        AdvanceTicket run2 = new AdvanceTicket(Integer.parseInt(bits[1]), Integer.parseInt(bits[2]));

                        list.add(0,run2);

                        //System.out.print(bits[1] + " ");
                        //System.out.println(bits[2]);
                    }
                    else if (bits[0].equals("3")){
                        StudentAdvanceTicket run3 = new StudentAdvanceTicket(Integer.parseInt(bits[1]), Integer.parseInt(bits[2]));

                        list.add(0,run3);

                    }
                    else{

                        throw new BadInputCodeException("Bad code # encountered on line "+ counter +" of "+inputFile+". Line ignored.");

                    }

                    if(list.size()>=2){
                        for(int x = 0; x<list.size()-1;x++){
                            if(list.get(x).compareTo(list.get(x+1))>0){
                                Ticket first = list.get(x);
                                Ticket second = list.get(x+1);
                                list.remove(x);
                                list.add(x, second);
                                list.remove(x+1);
                                list.add(x+1,first);
                            }

                        }
                    }
                }catch(BadInputCodeException f){
                    System.out.println(f.getMessage());
                }
                catch(BadTicketNumberException g){
                    System.out.println(g.getMessage());

                }
                catch(BadDaysRangeException h){
                    System.out.println(h.getMessage());

                }

            }
            System.out.print("Contents: "+ list);
            // The loop to read the data encloses a 
            // try-catch block to process input from input file
            // and continue reading until every line from the file
            // is read and processed.

            // You may add other methods, as necessary, to solve
            // this problem.
        }catch (FileNotFoundException e) {
            System.out.println("No file found!");
            // Program terminates, as there is not input to process      
        }
    }
}		
