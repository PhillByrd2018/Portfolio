
/**
 * This program will act as a modeling system for record keeping for 
 *          a hotel in room space and conference space.
 * 
 * @author (Phillip Byrd) 
 * @version (02.19.2017)
 */

/*
 * This where we intialize all the variables we will need for this class to model hotel conference rooms and set the values with the constructor
 */
public class Room
{
    private String number;
    private String name;
    private int capacity;
    private char setUp;
    private boolean isReconfigurable;
    private String configureOptions;
    private Room canBeCombinedwith;
    private static int numberOfRooms = 0;
    private static int totalCapacity = 0;

    public Room(String number, String name, int capacity, char setUp, boolean isReconfigurable, String configureOptions)
    {
        this.number = number;
        this.name = name;
        this.capacity = capacity;
        this.setUp = setUp;
        this.isReconfigurable = isReconfigurable;
        this.configureOptions = configureOptions;
        numberOfRooms++;
        totalCapacity += capacity;

    }
    /*
     *  here we update the variable canBeCombinedWith to reflect rooms that are compatible 
     */
    public void updateCanBeCombinedWith(Room r)
    {
        this.canBeCombinedwith = r;
    }

    /*
     * This will return the value of the room's capacity
     */
    public int getRoomCapacity()
    {
        return this.capacity;
    }
    
    /*
     * This will change the store value of the setup of the room
     */
    public void reconfigure(char option)
    {
        String TempOption = "" + option;

        if(this.isReconfigurable == true && this.configureOptions.contains(TempOption))
        {
            this.setUp = option;
        }
    }
    
    /*
     * this method will return true if one room is compatiable with another room 
     */
    public boolean isCompatibleWith(Room other)
    {
        if (this.capacity == other.capacity && this.isReconfigurable == true 
        && this.configureOptions == other.configureOptions)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /*
     * this method will print all the data stored on the object
     */
    public String toString()
    {
        String returnOutput = "";
        String tempName = "";
        String tempCombined= "";
        String tempOptions = "";

        if(this.name != null)
        {
            tempName = "Name: " + this.name+"\n\t";

        }
        else
        {
            tempName = "";

        }
        if(this.canBeCombinedwith != null)
        {
            tempCombined = "Can be Combined with: " + "# " + this.canBeCombinedwith.number;
        }
        if(this.configureOptions != null)
        {
            tempOptions = "Configure Options: " + helperConfigure(this.configureOptions) +"\n\t";
        }
        else
        {
            tempOptions = "";
        }

        returnOutput = "Room Number: " + this.number + "\n\t" + tempName + "Capacity: "+ this.capacity + "\n\t" + "SetUp: " + helper(this.setUp) +"\n\t"+ tempOptions  + tempCombined +"\n";
        return returnOutput;
    }

    /*
     * this method returns the full name of the setup value stored in the object
     */
    public static String helper(char options)
    {
        String TempOptionHelper = "" + options;
        String helperReturn = "";

        if(TempOptionHelper.equals("T"))
        {
            return "Theater";

        }
        else if(TempOptionHelper.equals("C"))
        {
            return "Classroom";

        }
        else if(TempOptionHelper.equals("U"))
        {
            return "U-Shape";
        }
        else if(TempOptionHelper.equals("B"))
        {
            return "Banquet";
        }
        else
        {
            return "Boardroom";
        }
    }
    
    /*
     * This method returns the value of all the configure options stored in the object
     */
    public static String helperConfigure(String options)
    {
        String TempOptionHelper = "" + options;
        String helperReturn = "";
        int i;

        for(i=0;i<TempOptionHelper.length();i++){
            if(TempOptionHelper.charAt(i) == 'T')
            {
                helperReturn += "Theater" + ", ";

            }
            else if(TempOptionHelper.charAt(i) == 'C')
            {
                helperReturn += "Classroom"+ ", ";

            }
            else if(TempOptionHelper.charAt(i) == 'U')
            {
                helperReturn += "U-Shape"+ ", ";
            }
            else if(TempOptionHelper.charAt(i) == 'B')
            {
                helperReturn += "Banquet"+ ", ";
            }
            else
            {
                helperReturn += "Boardroom"+ ", ";
            }

        }
        return helperReturn;
    }
    
    /*
     * this method returns the total number of rooms used
     */
    public static int getNumberOfRooms()
    {
        return numberOfRooms;

    }
    
    /*
     * this method returns the total number of guests at the hotel
     */
    public static int getTotalCapacity()
    {
        return totalCapacity;

    }

}
