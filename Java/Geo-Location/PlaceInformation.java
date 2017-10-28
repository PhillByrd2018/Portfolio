
/**
 * 
 * Phillip Byrd 
 * 02.15.2017
 * 
 * this will take the information from the objects made here and store that information in its own objects
 * and then use it to find the distances from two different locations, by using a method in GeoLocation.
 */ 
public class PlaceInformation
{

    /*
     * Creating the Variables for the PlaceInfo Objects
     */
    private String name;
    private String address;
    private String tag;
    private double latitude, longitude;
    private GeoLocation location;

    /* 
     * Full Constructor
     */
    public PlaceInformation(String name, String address, String tag, double latitude, double longitude)
    {
        this.name = name;
        this.address = address;
        this.tag = tag;
        this.location = new GeoLocation(latitude, longitude);
    }

    /*
     * Empty Constructor
     */
    public String getName()
    {
        return this.name;
    }

    /*
     * Returns object address
     */
    public String getAddress()
    {
        return this.address;
    }

    /*
     * Returns Object Tags
     */
    public String getTag()
    {
        return this.tag;
    }  

    /*
     * String Methods
     */
    public String toString()
    {
        return "(Name: " + this.name +","+ " Address: " + this.address +"," + " Tags: " + this.tag + "," + " Latitude: " + this.latitude + "," + " Longitude: " + this.longitude+")";

    }   

    /*
     * Returns Objects location
     */
    public GeoLocation getLocation()
    {
        return this.location;
    }

    /*
     * Returns the distance between to Objects
     */
    public double distanceFrom(GeoLocation spot)
    {
        return location.distanceFrom(spot);
    }

}
