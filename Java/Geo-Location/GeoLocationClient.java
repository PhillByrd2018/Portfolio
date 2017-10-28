
/**
 * Phillip Byrd
 * 02.15.2017
 * 
 */
public class GeoLocationClient
{
    /*
     * Initialize the Variables for our test Class
     */
    private String name;
    private double Latitude;
    private double Longitude;

    public GeoLocationClient(String userName, double userLat, double userLong)
    {
        name = userName;
        Latitude = userLat;
        Longitude = userLong;
    }
    
    /*
     * Empty Constructor
     */
    public GeoLocationClient()
    {
        name = "";
        Latitude = 0.0;
        Longitude = 0.0;
    }
    
    /*
     * This will return all the info in the object
     */
    public void writeOutput()
    {
        GeoLocation obj1 = new GeoLocation(this.Latitude, this.Longitude);
        System.out.println(this.name + " is at " + obj1.toString());
        
    }
    
    /*
     * This will return the distance between two objects
     */
    public void writeOutputDist(GeoLocationClient other)
    {
        GeoLocation objDist1 = new GeoLocation(this.Latitude, this.Longitude);
        GeoLocation objDist2 = new GeoLocation(other.Latitude, other.Longitude);
        System.out.println(this.name+"/"+other.name + " = "+ objDist1.distanceFrom(objDist2));
    }

    
    /*
     * This is the code to make three objects and test the output of this class using the Breaking bad info. 
     */
    public static void main(String[] args)
    {

        GeoLocationClient stash = new GeoLocationClient("the stash", 34.988889, -106.614444);
        stash.writeOutput();

        GeoLocationClient ABQ = new GeoLocationClient("ABQ studio", 34.989978, -106.614357);
        ABQ.writeOutput();

        GeoLocationClient FBI = new GeoLocationClient("FBI building", 35.131281, -106.61263);
        FBI.writeOutput();
        
        stash.writeOutputDist(ABQ);
        stash.writeOutputDist(FBI);

    }

}
