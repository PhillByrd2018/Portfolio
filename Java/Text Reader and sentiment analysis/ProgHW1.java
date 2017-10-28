import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/*
 * CSCI 221, Spring 2017, Programming HW 1
 * <PHILLIP BYRD- 1.30 Section 02.01.2017>
 *
 * This program analyzes movie review data to determine if words have a 
 * negative or positive meaning. If a word is used more often in positive 
 * reviews, it is assumed that the word is positive, and vice versa.
 * Currently, it reads review data line by line - each line is a single review in the form:
 * <integer rating of movie> <Verbal review - text supporting the rating> <newline>
 * 
 */
public class ProgHW1 
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // Create file instance for input
        File reviewFile = new File("movieReviews.txt");
        // This scanner instance will read from the aforementioned file, which
        // must be in your BlueJ project directory for it to find it.
        Scanner reviewScanner = new Scanner(reviewFile);
        // This scanner instance reads from the keyboard
        Scanner keyboard = new Scanner(System.in);

        int userChoice;

        do
        {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println();
            System.out.println("1: Get Score of a word.");
            System.out.println("2: Get the average score of words in a file(one word per line)");
            System.out.println("3: Find the highest/lowest scoring words in a file.");
            System.out.println("4: Sort words from a file  into positive.txt and negative.txt");
            System.out.println("5: Exit");
            System.out.println("Enter a number: 1-5");
            System.out.println();

            userChoice = keyboard.nextInt();

            String reviewText;
            String word;

            //This is the start of the program where we offer the choies to the user.
            switch(userChoice)
            {
                case 1:
                // Ask the user to enter a word
                System.out.println("Enter a word.");
                word = keyboard.next();
                System.out.println();

                int reviewScore = 0;
                double word_count = 0.0;
                double score_total = 0.0;
                double average_score = 0.0;
                reviewScanner = new Scanner(reviewFile); 

                // This loop iterates as long as there is text in the file      
                while(reviewScanner.hasNext())
                {
                    // Read the numeric movie rating
                    reviewScore = reviewScanner.nextInt();
                    // Read the text of the verbal review
                    reviewText = reviewScanner.nextLine();

                    // If the review contains the word the user entered, print the 
                    // rating and the review and continue; if it does not, process the
                    // next review
                    if(reviewText.toLowerCase().contains(word.toLowerCase()))
                    {
                        word_count ++;
                        score_total = score_total + reviewScore;
                        //System.out.println("Score: "+reviewScore);
                        //System.out.println("Text: "+reviewText);
                    }
                }
                if(word_count > 0){
                    average_score = score_total/ word_count;
                }
                System.out.println(word +" appears " +word_count+" Times.");
                System.out.println("The average for the choosen word is: " + average_score);
                System.out.println();

                reviewScanner.reset();
                reviewScanner.close();

                break;
                case 2:
                //This is where is set up all variables needed to run the program to score all the words from a file given by the user.
                String userFileName;
                userFileName = "";
                System.out.println("Give me the name of the file you want to evaluate");
                userFileName = keyboard.next();
                System.out.println("WORDS IN FILE: ");

                //open the user given file here
                File userReviewFile = new File(userFileName);
                Scanner userReviewScanner = new Scanner(userReviewFile);

                //set up counter and file average score for after and run while loops just like CASE 1.
                double fileAvgScore = 0.0;
                int counter = 0;

                while(userReviewScanner.hasNext())
                {

                    int userReviewScore = 0;
                    double userWord_count = 0.0;
                    double userScore_total = 0.0;
                    double userAverage_score = 0.0;

                    reviewScanner = new Scanner(reviewFile); 
                    String UserReviewText;
                    String userWord;
                    counter++;

                    userWord= userReviewScanner.next();
                    System.out.println(userWord);

                    while(reviewScanner.hasNext())
                    {

                        userReviewScore = reviewScanner.nextInt();

                        UserReviewText = reviewScanner.nextLine();

                        if(UserReviewText.toLowerCase().contains(userWord.toLowerCase()))
                        {
                            userWord_count ++;
                            userScore_total = userScore_total + userReviewScore;

                        }
                    }
                    if(userWord_count > 0)
                    {
                        userAverage_score = userScore_total/userWord_count;
                    }
                    fileAvgScore = userAverage_score + fileAvgScore;

                    reviewScanner.reset();
                    reviewScanner.close();
                }
                System.out.println();

                //close the file and calculate the average score for the file and determine if positive or negative overall. 
                double endCount = fileAvgScore/counter;
                System.out.println("The average Score of words in "+userFileName+" is: "+ endCount);

                System.out.println();
                if(endCount>2.01)
                {
                    System.out.println("This means that the file: "+userFileName+" is overall a positive file."); 
                }
                else{
                    System.out.println("This means that the file: "+userFileName+" is overall a negative file."); 
                }
                break;

                case 3:
                // set up all variables need to find high and low score in list of words from a file given by user.
                String userFileName3;
                System.out.println("Give me the name of the file you want to evaluate");
                userFileName3 = keyboard.next();
                System.out.println("WORDS IN FILE AND SCORE: ");

                //take user file and open it for reading
                File userReviewFile3 = new File(userFileName3);
                Scanner userReviewScanner3 = new Scanner(userReviewFile3);

                //make max and min variables to sort after we run the while loops just like in CASE 1
                double max = 0.0;
                String maxWord="";
                String minWord="";
                double min = 100.0;
                double userAverage_score3 = 0.0;

                while(userReviewScanner3.hasNext())
                {

                    int userReviewScore3 = 0;
                    double userWord_count3 = 0.0;
                    double userScore_total3 = 0.0;

                    String UserReviewText3;
                    String userWord3;

                    reviewScanner = new Scanner(reviewFile); 
                    userWord3= userReviewScanner3.next();

                    while(reviewScanner.hasNext())
                    {

                        userReviewScore3 = reviewScanner.nextInt();
                        UserReviewText3 = reviewScanner.nextLine();
                        if(UserReviewText3.toLowerCase().contains(userWord3.toLowerCase()))
                        {
                            userWord_count3 ++;
                            userScore_total3 = userScore_total3 + userReviewScore3;

                        }
                    }
                    if(userWord_count3 > 0)
                    {
                        userAverage_score3 = userScore_total3/userWord_count3;
                    }
                    if(userAverage_score3 > max)
                    {
                        maxWord=userWord3;
                        max = userAverage_score3;

                    }
                    if(userAverage_score3 < min && userAverage_score3 > 0.0)
                    {
                        minWord=userWord3;
                        min = userAverage_score3;

                    }
                    System.out.println(userWord3);
                    System.out.println(userAverage_score3);
                    reviewScanner.reset();
                    reviewScanner.close();
                }

                // we use the if statements to sort the max and min score for the words in the file and print them here. 

                System.out.println();
                System.out.println("The most positive word in the file "+userFileName3+" is: "+maxWord);
                System.out.println("Score: "+max);
                System.out.println();
                System.out.println("The most negative word in the file "+userFileName3+" is: "+minWord);
                System.out.println("Score: "+min);
                break;

                case 4:
                //BONUS

                //Here we are going to sort just like in CASE 3 but we are going to output to two files. (POSITIVE AND NEGATIVE)
                String userFileName4;
                System.out.println("Give me the name of the file you want to evaluate.");
                userFileName4 = keyboard.next();
                System.out.println("WORDS IN FILE AND SCORE: ");

                //Take file name from user and open it for reading
                File userReviewFile4 = new File(userFileName4);
                Scanner userReviewScanner4 = new Scanner(userReviewFile4);

                File pos = new File("Positive.txt");
                File neg = new File("Negative.txt");

                pos.delete();
                neg.delete();

                pos.createNewFile();
                neg.createNewFile();

                FileWriter writerneg = new FileWriter(neg,true);
                FileWriter writerpos = new FileWriter(pos,true);

                while(userReviewScanner4.hasNext())
                {

                    int userReviewScore4 = 0;
                    double userWord_count4 = 0.0;
                    double userScore_total4 = 0.0;
                    double userAverage_score4 = 0.0;

                    String UserReviewText4;
                    String userWord4;

                    reviewScanner = new Scanner(reviewFile); 
                    userWord4= userReviewScanner4.next();

                    while(reviewScanner.hasNext())
                    {

                        userReviewScore4 = reviewScanner.nextInt();
                        UserReviewText4 = reviewScanner.nextLine();
                        if(UserReviewText4.toLowerCase().contains(userWord4.toLowerCase()))
                        {
                            userWord_count4 ++;
                            userScore_total4 = userScore_total4 + userReviewScore4;

                        }
                    }
                    if(userWord_count4 > 0)
                    {
                        userAverage_score4 = userScore_total4/userWord_count4;
                    }
                    if(userAverage_score4 >= 2.01)
                    {

                        writerpos.write(userWord4);                            
                        writerpos.write("\r\n");

                    }
                    if(userAverage_score4 < 1.99 && userAverage_score4 > 0.0)
                    {
                        writerneg.write(userWord4);
                        writerneg.write("\r\n");

                    }
                    reviewScanner.reset();
                    reviewScanner.close();

                }
                writerpos.close();
                writerneg.close();
                break;

            }
        }while(userChoice == 1 || userChoice== 2 || userChoice==3 || userChoice==4);
    }
}