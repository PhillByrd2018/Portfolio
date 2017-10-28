/* 
 * Used, but not written by, Phillip Byrd
 *
 * This program constructs several PlaceInformation objects and prints
 * information about them and the distances between them and two locations
 * (London and Harbor Walk).  It is intended to be used to test whether the
 * PlaceInformation class is implemented correctly.
 */

public class PlaceInformationClient {
    
    public static void main(String[] args) {
        PlaceInformation[] data =
            {new PlaceInformation("South Carolina Aquarium", "Aquarium Wharf, Chareston",
                                  "aquarium, point_of_interest", 32.791041, -79.925586),
             new PlaceInformation("Randolph Hall", "College of Charleston",
                                  "university", 32.784160, -79.937345),
             new PlaceInformation("Charleston International Airport", "North Charleston",
                                  "airport", 32.898650, -80.037730)};

        GeoLocation london = new GeoLocation(51.5112139, -0.1198244);
        GeoLocation harborWalk = new GeoLocation(37.791704, -79.926084);

        for (PlaceInformation info : data) {
            System.out.println("name    : " + info.getName());
            System.out.println("address : " + info.getAddress());
            System.out.println("tags    : " + info.getTag());
            System.out.println("toString: " + info);
            System.out.println("Distance from London  : " + info.distanceFrom(london) + " miles.");
            System.out.println("Distance from Harbor Walk    : " + info.distanceFrom(harborWalk) + "miles.");
            System.out.println();
        }
    }
}