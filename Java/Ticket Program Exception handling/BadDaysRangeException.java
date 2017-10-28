
/**
 * BadDaysRangeException is used to check that the days in advanced are in a good range when created .
 * 
 * @author Phillip Byrd
 * @version 04.08.2017
 */
public class BadDaysRangeException extends Exception
{

    /**
     * Constructor for objects of class BadDaysRangeException
     */
    public BadDaysRangeException(String warning)
    {
        super(warning);
    }

}
