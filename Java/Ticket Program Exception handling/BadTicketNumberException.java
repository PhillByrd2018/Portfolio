
/**
 * BadTicketNumber is used to check the ticket number when the object is created
 * 
 * @author Phillip Byrd
 * @version (a version number or a date)
 */
public class BadTicketNumberException extends Exception
{

    public BadTicketNumberException(String warning)
    {
        super(warning);
    }

}
