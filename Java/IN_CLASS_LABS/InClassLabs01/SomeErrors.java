
/**
 * Phillip Byrd
 * Compute the Volume of a rectangular prisms.
 * 
 */
import java.util.Scanner;
public class SomeErrors
{
    public static void main(String[] args)
   {
       int length = 0, width = 0, height = 1;
       System.out.println("Enter length, width, and height of ");
       Scanner keyboard = new Scanner(System.in);
       // Enter the data for the prism
       length = keyboard.nextInt();
       width = keyboard.nextInt();
       height = keyboard.nextInt();
       //compute the volume 
       int volume = (length * width * height);
       System.out.println("The volume is " + volume);
    }
       
}
