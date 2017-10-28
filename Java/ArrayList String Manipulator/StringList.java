
/**
 * This Class is used to store strings in a array and manipulate the data stored in it. 
 * It contains the Methods:(Add, insert, delete, find, contains, size, and enlarge )
 * 
 * @author Phillip Byrd
 * @version 03.13.2017
 */
public class StringList
{
    /*
     * These are varaibles need to do all the operations for the arrays. length of elements stored. LengthHelper is to show total 
     * storage allocated for the array.
     */
    public int length;
    public String[] list; 
    public int lengthHelper;

    /**
     * Constructor for objects of class StringList
     */
    public StringList()
    {
        this.list = new String[10];
        this.length = 0;
        this.lengthHelper = 10;
    }

    /*
     * This method returns the number of elements stored.
     */
    public int size()
    {
        return this.length;
    }

    /*
     * This method stores the string passed in the selected array.
     */
    public void add(String a)
    {
        if(this.length == 0){

            this.list[0] = a;
        }
        else if(this.length > 0 && this.length < this.lengthHelper)
        {
            this.list[this.length] = a;

        }
        else{
            this.enlarge();
            this.list[this.length] = a;
        }
        this.length++;
    }

    /*
     * This method will add a string by the user at a specific location in the array
     */
    public void insert (String a, int location)
    {
        if(this.lengthHelper <= this.length){this.enlarge();}
        for(int w=this.length+1; w >= location;w--)
        {
            this.list[w]=this.list[w-1];

        }
        this.list[location-1] = a;
        this.length++;

    }

    /*
     * This method will check an array to see if the given string is in it.
     */
    public boolean contains(String a)
    {
        for(int i = 0; i<=this.length-1;i++)
        {
            if (this.list[i].equals(a)==true)
            {
                return true;
            }
        }
        return false;
    }

    /*
     * This method with return the location in an array if the array has the given element in it.
     */
    public int find(String a)
    {
        for(int j=0;j<this.length;j++)
        {
            if(this.list[j].equals(a))
            {
                return (j+1);
            }

        }
        return -1;

    }

    /*
     * this method will display the contents of the array in a user friendly fashion.
     */
    public void displayList()
    {   
        System.out.println("StringList: "+this.lengthHelper + " " + this.length);
        for(int k=0;k<this.lengthHelper;k++) 
        {
            System.out.println("["+ (k+1) +"]" + " " + this.list[k]);
        }

    }

    /*
     * This method will add more storage space to the array if the user tries to add an element and they run out of 
     * space
     */
    private void enlarge()
    {
        String[] upGrade = new String[2*this.lengthHelper];
        for(int g=0;g<length;g++)
        {
            upGrade[g]=this.list[g];

        }
        this.list = upGrade;
        this.lengthHelper = 2*this.lengthHelper;
    }

    /*
     * This method will remove any string passed by the user if it is in the array.
     */
    public void delete(String a)
    {
        if(this.contains(a)== true)
        {
            for(int q=this.find(a)-1;q<this.length;q++){
                if(this.list[q+1] != null){
                    this.list[q]=this.list[(q+1)];
                }
                else
                {
                    this.list[q]= null;
                }
            }
            this.length--;
        }
        else
        {
            System.out.println("String not in Array. Try again.");
        }

    }
}