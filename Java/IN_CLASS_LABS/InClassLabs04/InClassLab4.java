import java.util.Scanner;

/**
 * Draw the figure shown on the Lab4 sheet with base width provided by user.
 * 
 * PHILLIP BYRD LAB04
 * (February 3, 2017)
 */
public class InClassLab4
{
   public static void main(String [] args)
   {
       Scanner keyboard = new Scanner(System.in);
       int input = 0;
      
       do{
           System.out.print("Please enter an odd number: ");
           input = keyboard.nextInt();
        }while (input%2==0);
        
       for(int i = 0; i <= input; i+=2){
           
           for(int k = 0; k <= i; k+=2){
               System.out.print(" ");
        }
        
           for(int j = 0; j < input - i; j++){
               System.out.print("*");
            }
            System.out.println( );
        }
      
        
        
        
      }
}
