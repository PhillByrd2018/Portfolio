
/**
 * Phillip Byrd
 * In Class Lab 2
 * Problem Ch02Ex06 
 * Due Friday January 20, 10pm
 */
 import java.util.Scanner;
public class Ch2PP3
{
    public static void main(String[] args){
       
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Enter a full sentence");
        System.out.println("I will switch the First word to the last.");
        String sentence = keyboard.nextLine();
        
        //get index of first space--the end of the first word
        int index = sentence.indexOf(" ");
        
        //use the index to get the first word in sentence, then rest of sentence and remove extra space
        String firstWord = sentence.substring(0, index);
        String restOfSentence = sentence.substring(index);
        restOfSentence = restOfSentence.trim();
        
        //builds new sentence, gets first letter and capitalizes, and prints outcome
        String output = restOfSentence + " " + firstWord;
        String firstLetter = output.substring(0,1);
        
        output = firstLetter.toUpperCase() + output.substring(1);
        
        System.out.println(output);
        
        //System.out.println(firstWord);
        //System.out.println(restOfSentence);
        //System.out.println(lineText);
        //System.out.println(index);
    
    
    }
}
