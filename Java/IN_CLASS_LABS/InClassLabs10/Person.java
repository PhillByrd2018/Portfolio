/**
 * 
 * Person class for Lab 10
 * 
 * This class simply models a person that only 
 * has a name. 
 *
 */
public class Person {

    // instance variable
    private String name = "unknown";

    /**
     * Constructor initialzing name instance variable
     */
    public Person(String initialName) {

        setName( initialName );

    } // end constructor

    /**
     * Sets the name of this Person - can only be called from within this class 
     */
    private void setName(String newName) {

        name = newName;

    } // end setName() method

    /**
     * Returns the name of this Person
     */
    public String getName() {

        return name;

    } // end getName() method

    /**
     * Returns string representation of the name of the Person with a label
     */
    public String toString() {

        return "Name: " + name;

    } // end display() method

    /**
     * Returns true if this Person object has the same name as the paramter
     * 
     */
    public boolean equals(Object otherPerson) {

        if (otherPerson == null || !(otherPerson instanceof Person))
            return false;
        else{
            Person other = (Person) otherPerson;
            return other.getName().equalsIgnoreCase( getName() );
        }
    } // end equals() method


} //