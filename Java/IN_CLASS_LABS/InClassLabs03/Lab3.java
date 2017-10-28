import java.util.Scanner;
/**
 * In class lab 3: Compute the cost of a coffee order.
 * 
 * PHILLIP BYRD
 * @version (January 25, 2017)
 */
public class Lab3
{
    public static void main(String [] args){
        
        Scanner keyboard = new Scanner(System.in);
        
        // Get coffee order
        System.out.print("How many bags of coffee are you ordering? ");
        int bags = keyboard.nextInt();
        
        // Compute cost of coffee
        double coffeeCost = bags * 5.5;
        
        System.out.printf("\nNumber of bags ordered: %d - $%.2f\n",bags, coffeeCost);
        
        // Compute discount
        double discountAmount = 0;
        
        if (bags >= 50 && bags < 150){
            discountAmount =  10;
        }
        else if (bags >= 150 && bags < 300){
            discountAmount = 20;
        }
        else if (bags >= 300){
            discountAmount = 30;
        }
        
        
        double discount = 0;
        
        discount = (coffeeCost * (discountAmount/100));
        
        
        System.out.printf("Discount: %d%% - $%.2f\n", (int)discountAmount, discount);
        
        // Compute the boxes needed
        int largeBoxes = bags/20;
        int regularBoxes = 0;
        
        
       if ((bags%20) < 4)
            regularBoxes = 1;
        else
            regularBoxes = (bags%20)/5;
        
       
        // Compute the cost of boxes - ADD CODE to compute box costs
        double costLargeBoxes = 0;
        double costRegularBoxes = 0;
            
        costLargeBoxes = largeBoxes * 1.50;
        costRegularBoxes = regularBoxes * .50;
        
        // Computer cost of total order - ADD CODE to compute totalcost
        double costOfOrder = (coffeeCost - discount) + costLargeBoxes + costRegularBoxes;
        System.out.println("Boxes Used:");
        System.out.printf("\t"+ largeBoxes +" Large = $%.2f\n", costLargeBoxes);
        System.out.printf("\t"+ regularBoxes +" Regular = $%.2f\n", costRegularBoxes);
        System.out.printf("\nTotal Cost: $%.2f\n",costOfOrder);
     
       
      
    }
    
}
