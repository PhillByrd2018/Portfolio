
/**
 * In class lab 6
 * A Company class models information that might be stored for a company
 * Phillip Byrd 02.20.2017
 */
public class Company {

    // ---------------------------
    // Private instance variables
    // ---------------------------
    private String name = "";   
    private int year;
    private int employees = 0;
    private Company parent = null;

    /**
     * Overloaded Constructor 3-parameters
     */
    public Company( String name, int year, int employees) {
        // call 5-parameter constructor 
        this( name, year, employees, null );    
    } // end 4-parameter overloaded constructor

    /**
     * Overloaded Constructor 4-parameters
     */
    public Company( String name, int year, int employees, Company parent ) {

        this.name = name;
        this.year = year;
        this.employees = employees;
        this.parent = parent;
    } // end 4-parameter overloaded constructor

    /**
     * Retrieves name of the company
     */
    public String getName() {
        return this.name;

    } // end getName() method

    /**
     * Retrieves the parent company
     */
    public Company getParent() {
        return parent;      
    } // end getParent() method

    /**
     * Returns a String representation for the current company
     */
    public String toString() {
        String description;
        description = "Company " +  getName() + ". Founded " + year +". Has "+ employees +"  employees";
        // Optional, include parent if it exists
        if (getParent() != null)
            description += ". Parent: " + getParent().getName(); 
        return description;
    } // end toString() method

    /**
     * Returns true if the objects being compared contain identical data
     */
    public boolean equals ( Company c ){
        return name.equals(c.name) &&
        year == c.year &&
        employees == c.employees && 
        parent == c.parent;
    }

    /**
     * Determines if this company has more employees than another company
     * Pre-Conditions: none, so ensure that c not null
     */
    public boolean isBigger( Company c ) {
        if(this != null && c != null)
        {
            if(this.employees > c.employees)
            {
                return true;
            }
        }
        return false;

    } // end isBigger() method

    /**
     * Static method to compare any two companies based on numbers of employees,
     *   returns true if c1 has more employ ees than c2. 
     * Preconditions: none, so veriy that c1 and c2 are not null
     */
    public static boolean isBigger( Company c1, Company c2 ) {
        if(c1 != null && c2 != null)
        {
            if(c1.employees > c2.employees)
            {
                return true;
            }
        }
        return false;
        // end isBigger() method
    }

    /**
     * copy method - returns a Company object that is a copy of the current object, but not an alias
     */
    public Company copy(){

        return new Company(this.name, this.year, this.employees, this.parent);

    }
    // test driver
    public static void main(String[] args) {

        // ------------ create objects ---------------
        Company c1 = new Company("Apple", 1974, 10000);
        Company c2 = new Company("Dell", 1980, 13500, c1);
        Company c3 = new Company("Swell", 1987, 2500, c2);
        Company c4 = new Company("Queue", 1999, 13500, c1);

        System.out.println( "---------Print objects-----------" );
        System.out.println( "c1:" + c1);
        System.out.println( "c2:" + c2);
        System.out.println( "c3:" + c3);
        System.out.println( "c4:" + c4);
        System.out.println();

        // Test isBigger(Company) method
        if (c1.isBigger(c4))
            System.out.println(c1.getName() + " has more employees than " + c4.getName());
        else
            System.out.println(c4.getName() + " has at least as many employees as " + c1.getName());

        if (c4.isBigger(c1))
            System.out.println(c4.getName() + " has more employees than " + c1.getName());
        else
            System.out.println(c1.getName() + " has at least as many employees as " + c4.getName());

        // Test isBigger(Company, Company) method
        if (Company.isBigger(c4, c2))
            System.out.println(c4.getName() + " has more employees than " + c2.getName());
        else
            System.out.println(c2.getName() + " has at least as many employees as " + c4.getName());

        // Test isBigger with nulls
        Company c8 = null;
        if (Company.isBigger(c8, c2))
            System.out.println(c8.getName() + " has more employees than " + c2.getName());
        else
            System.out.println("May have encountered a null");

        // Test isBigger(Company) method
        if (c1.isBigger(c8))
            System.out.println(c1.getName() + " has more employees than " + c8.getName());
        else
            System.out.println("May have encountered a null");

        // Test copy method
        Company c5 = c2.copy();

        System.out.println( "\n---------Verify we made copies, not aliases -------" );
        // Verify that copies are copies by verifying that 
        // references don't have same addresses
        // Are c2 and c5 different objects?
        System.out.println("c2 & c5 are different (should be true): " + (c2 != c5));
        // Do c2 and c5 contain the same data?
        System.out.println("c2 & c5 store same data (should be true): " + (c2.equals(c5)));

    } // end main() method

} // end Company class definition