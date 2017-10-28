
/**
 * Write a description of class CopyTester here.
 * 
 * @author Phillip Byrd
 * @version 04.25.2017
 */
import java.lang.*;
public class TestDriver
{
    /*
     * here is my reverse method that uses the stack data type to solve the problem of reversing an Int Number passed to the method. 
     */
    public static int reverse(int input){
        //I create the stack
        Stack revStack = new Stack();

        //I use this function to find the number of bits in the passed string
        int addItem;
        int finder = ((int)(Math.log10(input)));

        //System.out.println("Digits "+(finder+1));
        int counter = finder+1;

        double baseLong = Math.floor( Math.pow(10,finder) );

        //System.out.println("Start "+(int)baseLong);

        int bottom = ((int)baseLong);
        
        //after seting the base numbers the right data type I begin to make the conversions needed to reverse the sequence
        //I use a model of integer divison and modulo to get the right answer

        while(counter!=0){
            addItem = input/bottom;
            //System.out.println(addItem);

            revStack.push(addItem);

            input = input%bottom;

            bottom = bottom/10;

            counter--;
        }

        // here I reset my my base value to prepare to reverse the Int 
        
        //System.out.println("Middle "+bottom);
        bottom =((int)baseLong);
        int endPro =0;
        int done = 0;
        
        //I use this method to reverse the number out of the stack and put in the right order
        while(!revStack.isEmpty()){
            addItem = revStack.top();
            revStack.pop();

            endPro = bottom * addItem;
            bottom = bottom/ 10;

            //System.out.println(endPro);
            done += endPro;

        }

        //System.out.println(done);
        return done;
    }

    /*
     * This is a close copy of Lab 11 and uses a few more parts to solve the copy problem
     * I provide the contents of the Stack before and after the copy to 
     */
    public static void main (String [] args)
    {
        int item1 = 5, item2 = 2, item3=9;  

        Stack copyStack = new Stack();    
        copyStack.push(item2); 
        copyStack.push(item1); 
        copyStack.push(item1 + item3);
        item2 = copyStack.top();
        copyStack.push(item3*item3); 
        copyStack.push(item2); 
        copyStack.push(3);
        item1 = copyStack.top(); 
        copyStack.pop();

        System.out.println("Before Copy");
        System.out.println(item1 + " " + item2 + " " + item3);
        System.out.println();
        ////////////////////////////////////

        while (!copyStack.isEmpty()){
            item1 =copyStack.top();
            copyStack.pop();
            System.out.println(item1);
        }
        /////////////////////////////////////
        System.out.println();
        System.out.println("After Copy");

        item1 = 5;
        item2 = 2;
        item3=9;  

        copyStack.push(item2); 
        copyStack.push(item1); 
        copyStack.push(item1 + item3);
        item2 = copyStack.top();
        copyStack.push(item3*item3); 
        copyStack.push(item2); 
        copyStack.push(3);
        item1 = copyStack.top(); 
        copyStack.pop();
        System.out.println(item1 + " " + item2 + " " + item3);

        Stack testCopy = new Stack();
        
        // Here i assign the values returned from the copy method to a new Stack
        testCopy = copyStack.copy();
        System.out.println();

        System.out.println("CONTENTS OF ORIGINAL ARRAY");
        while (!copyStack.isEmpty()){
            item1 =copyStack.top();
            copyStack.pop();
            System.out.println(item1);
        }

        System.out.println("CONTENTS OF COPIED ARRAY");
        while (!testCopy.isEmpty()){
            item1 =testCopy.top();
            testCopy.pop();
            System.out.println(item1);
        }

        System.out.println("/////////////////////////////////////////////");
        System.out.println("Test revervse Method with values: 654321");
        System.out.println(reverse(654321));

    }
}
