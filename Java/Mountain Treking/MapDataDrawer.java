import java.util.*;
import java.io.*;
import java.awt.*;
// Author Phillip Byrd

public class MapDataDrawer
{
    // store map data in grid array
    private int[][] grid; 

    // Read 2D array into grid. Data in file "filename", grid is rows x cols
    //Here is the constructor that opens a file and feeds it into the 2D array
    public MapDataDrawer(String filename, int rows, int cols) throws Exception{
        grid = new int[rows][cols];
        File info = new File(filename);
        Scanner read = new Scanner(info);
        for(int i=0; i<rows;i++){
            for(int k=0;k<cols; k++){
                grid[i][k]= read.nextInt();
            }
        }

    }

    //This is where I look for the min in 2D array.
    /**
     * @return the min value in the entire grid
     */
    public int findMin(){
        int min = grid[0][0];
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]< min){
                    min = grid[row][col];
                }
            }
        }
        return min;

    }

    //This method is going to return the max int in the 2D array
    /**
     * @return the max value in the entire grid
     */
    public int findMax(){

        int max = grid[0][0];
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(grid[row][col]> max){
                    max = grid[row][col];
                }
            }
        }
        return max;

    }

    //This will find the min value in the 2D array and return the index at that position.
    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public  int indexOfMinRow(int col){
        int index = 0;
        int min = grid[0][col];
        for(int row = 0; row<grid.length;row++){
            if(grid[row][col]<min){
                min = grid[row][col];
                index = row;
            }
        }
        return index;  
    }

    /**
     * DON'T CHANGE THIS CODE, except to uncomment it when you instantiate the grid
     * Draws the grid using the given Graphics object. 
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     */

    // ******ALERT******
    // Note - until you instantiate a grid, through the constructor, this
    // method will generate a null pointer exception, since there is no grid.length
    // ********************
    public void drawMap(Graphics g){

        int minVal = findMin();
        int maxVal = findMax();
        double range = maxVal - minVal;

        for(int row=0; row < grid.length; row++){
            for(int col=0; col<grid[0].length; col++){
                int val = (int)(((grid[row][col]-minVal)/range) * 255);
                //g.setColor(new Color(val,255-val,255-val));
                g.setColor(new Color(val,val,val));
                g.fillRect(col,row,1,1);
            }
        }      
    }

    //This method will return the total change in the drawn paths across the mountains.
    /**
     * Find a path from West-to-East starting at given row.
     * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row){
        int currY = row; // row in grid of step one
        // draw initial step - column 0, current row (sent in as parameter)
        g.fillRect(0,row,1,1);

        // Code to compute next step
        // Variables to keep track of change in elevation
        int change = 0;
        int middle = 0;
        int upper = 0;
        int lower = 0;
        
        // here we start to loop through the grid across by columns 

        for(int i = 1; i< grid[currY].length; i++){

            // at the top
            //This section checks values at the top of the grid using currY as the metric
            if(currY==0){
                middle = Math.abs(grid[currY][i-1] - grid[currY][i]);
                lower = Math.abs(grid[currY][i-1] - grid[currY + 1][i]);
                if(middle < lower){

                    change += middle;
                }else if(middle > lower){

                    change += lower;
                    currY++;
                }
                else{
                    int ran = new Random().nextInt(1);
                    if(ran == 0){
                        change += middle;
                    }
                    else if(ran == 1){
                        change+=lower;
                        currY++;
                    }
                }

                // at the bottom
                // this section checks values across the bottom of the grid
            }else if(currY == grid.length -1){
                upper = Math.abs(grid[currY][i-1] - grid[currY-1][i]);
                middle = Math.abs(grid[currY][i-1] - grid[currY][i]);
                if(middle < upper){

                    change += middle;
                }else if(middle > upper){

                    change += upper;
                    currY--;
                }else{
                    int ran = new Random().nextInt(2);
                    if(ran == 2){
                        change += middle;
                    }
                    else if(ran == 1){
                        change+=upper;
                        currY--;
                    }
                }

                // in the middle.
                // this section is for the middle of the array which should be the most used in our array.
            }else if(currY < grid.length -1 && currY > 0 ){

                upper = Math.abs(grid[currY][i-1] - grid[currY-1][i]);
                middle = Math.abs(grid[currY][i-1] - grid[currY][i]);
                lower = Math.abs(grid[currY][i-1] - grid[currY + 1][i]);
                if(upper == lower && middle < lower){
                    change += middle;

                }
                else if(upper == lower && lower == middle){
                    int ran = new Random().nextInt(2);
                    if(ran == 2){
                        change += middle;
                    }
                    else if(ran == 1){
                        change+=upper;
                        currY--;
                    }
                    else if(ran == 0){
                        change +=lower;
                        currY++;
                    }
                }
                else if(lower < middle && lower < upper){
                    change +=lower;
                    currY++;

                }
                else if(upper < middle && upper < lower){
                    change += upper;
                    currY--;
                }
                else if(middle < upper && middle < lower){
                    change+=middle;

                }
            }
            g.fillRect(i,currY,1,1);

        }
        // here is where I return the total change in my elevation.
        return change; 
    }

    //This is where call the draw method to find the index of the lowest path on the map of the mountains
    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){

        int example = drawLowestElevPath(g, indexOfMinRow(0));
        int indexOfLow = 0;

        for(int y = 0;y<grid.length;y++){
            int x = drawLowestElevPath(g,y);
            if(example > x)
            {
                example = x;
                indexOfLow = y;
            }

        }
        return indexOfLow; 

    }

}