/**
 * Process student grades
 * 
 * @Phillip Byrd
 * 03.20.2017
 */
public class Lab9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        // Declare and allocate array of grades for students
        // Each row represents the grades of one student.
        // All student have the same number of grades
        int [][] grade = {{15, 13, 13, 15, 10, 11},
                {15, 15, 15, 15, 13, 11},
                {0,  10, 0,  0,  5, 11},
                {12, 12, 12, 12, 15, 11},
                {15, 13, 13, 15, 10, 11},
                {15, 15, 15, 15, 14, 11},
                {0,  10, 10, 8,  5, 11}, 
                {12, 12, 0, 12, 15, 11},
                {11, 11, 0, 12, 15, 11},
                {15, 15, 15, 15, 14, 11},
                {10, 10, 10, 12, 12, 11}};

        double [] average= new double[grade.length];;
        int [] min = new int[grade.length];
        int [] max = new int[grade.length];

        //#5

        for(int j=0;j<grade.length;j++){
            double tempTot = 0;
            for(int a=0; a<grade[j].length;a++){

                tempTot += grade[j][a];

            }
            tempTot=tempTot/grade[0].length;
            average[j]= tempTot;
        }

        for(int m=0;m < average.length;m++){
            System.out.println(average[m]);
        }

        //#6
        for(int t=0;t<grade[0].length;t++){
            int minTemp = 20;
            for(int h = 0;h< grade.length; h++){
                if(grade[h][t] < minTemp){
                    minTemp = grade[h][t];
                }

            }
            min[t] = minTemp;

        }
        
        for(int t=0;t<grade[0].length;t++){
            int maxTemp = 0;
            for(int h = 0;h< grade.length; h++){
                if(grade[h][t] > maxTemp){
                    maxTemp = grade[h][t];
                }

            }
            max[t] = maxTemp;
            
        }
        
        for(int test = 0; test<min.length;test++){System.out.println(min[test]);}

        displayGrades(grade);
    }
    // Display grades
    // Precondtion: x is non-null
    public static void displayGrades(int [][] x){
        System.out.print("\t\t");
        for(int p =0; p< x[0].length; p++)
            System.out.print("Lab "+(p+1)+"\t");
        System.out.println();
        for (int row = 0; row < x.length; row++){
            System.out.print("Student "+ (row+1));
            for (int col = 0; col < x[row].length; col++)
                System.out.printf("%8d", x[row][col]);
            System.out.println();
        }
    }
}