
/**
 * Write a method to merge two ordered integer arrays into one
 *   ordered array.
 * Note arrays may be of any length.
 * 
 * @Phillip Byrd (started by McCauley) 
 * 
 */
public class Lab8
{
    public static void main(String [] args){
        // Create arrays for testing -what are good test cases?
        // Add more as necessary
        int [] one = {1,5,7,8,9};
        int [] two = {10,20,50,100,250};
        int [] three ={-3,80,90,350,1000};
        int [] four = {10,15,50,75,80};
        int [] five = {-10,5,20,50,100};

        
        mergeAndPrint(one, two);
        mergeAndPrint(two, one);
        mergeAndPrint(two, three);
        mergeAndPrint(three, two);
        mergeAndPrint(three, four);
        mergeAndPrint(four, three);
        mergeAndPrint(four, five);
        mergeAndPrint(five, four);
        mergeAndPrint(one, one);
        

    }

    /*
     * Print arrays being merged before and after call to merge
     * Precondition: a & b non-null
     */
    public static void mergeAndPrint(int [] a, int [] b){
        System.out.println("Arrays to merge: "+ toPrint(a,a.length) + " and " + toPrint(b, b.length));
        System.out.println("  Result: " + toPrint(merge(a,b), a.length + b.length));
        System.out.println();
    }

    /*
     * Preconditions: a and b non-null, but either could be of length 0. 
     *   a and b are ordered arrays.
     */
    public static int [] merge(int [] a, int [] b){
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length)
        {
            if (a[i] < b[j])
            {
                answer[k] = a[i];
                i++;
            }
            else
            {
                answer[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length)
        {
            answer[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length)
        {
            answer[k] = b[j];
            j++;
            k++;
        }

        return answer;
    }

    // Utility method to generate a String representation
    // of any array of ints - send in a reference to the array
    // and the array size
    // Precondition: y is not null
    public static String toPrint(int [] y, int length){

        String toPrint = "";
        toPrint += "[";
        for (int i = 0; i < length; i++){
            toPrint +=y[i];
            if (i < length-1)
                toPrint +=", ";
        }
        toPrint +="]";
        return toPrint;
    }
}
