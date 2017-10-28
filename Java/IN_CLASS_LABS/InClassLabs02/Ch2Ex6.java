
/**
 * Phillip Byrd
 * In Class Lab 2
 * Problem Ch02Ex06 
 * Due Friday January 20, 10pm
 */
 import java.util.Scanner;
public class Ch2Ex6
{
    public static void main(String[] args) {
   
        Scanner keyboard = new Scanner(System.in);
        
        keyboard.useDelimiter("\n");
        
        int age;
        String name; 
        
        System.out.println("Enter your age.");
        age = keyboard.nextInt();
        
        System.out.println("Enter your full name."); 
        name = keyboard.next();
        
        name = name.toUpperCase();   
        System.out.println("Your name in uppercase is " + name + " and you are " + age + " years old."); 
  
        /*name was using keyboard.nextLine() to capture the entire nextLine.
         * 
         * This means that it will assign name to an empty string.
         * 
         * So we change .nextLine() to just .next(). And use (\n) as a delimiter to seperate the full name.
         * Then we use .toUpperCase to print the name.
         */
    }
}
