
/**
 * BadInputCodeException is used to make sure the input from the file falls within the excepetable ranges.
 * 
 * @author Phillip Byrd
 * @version 04.12.2017
 * 
 */
public class BadInputCodeException extends Exception
{
    
    public BadInputCodeException(String Warning)
    {   
        super(Warning);
    }

    
}
