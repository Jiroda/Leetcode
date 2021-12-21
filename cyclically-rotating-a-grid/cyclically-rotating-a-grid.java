//T:O(m*n*k)
//S:O(1)
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rowLow = 0;
        int rowHigh = grid.length - 1;
        int colLow = 0;
        int colHigh = grid[0].length - 1;
        while(rowLow < rowHigh && colLow < colHigh){
            //if k >perimeter of the layer then mod perimeter
            int localK = k % ((rowHigh - rowLow) * 2 + (colHigh - colLow) * 2);
            // rotate localK times
            for(int i  = 0;i<localK;i++){
                //top row
                int temp = grid[rowLow][colLow];
                for(int j = colLow;j<colHigh;j++){
                    grid[rowLow][j] = grid[rowLow][j+1];
                }
                //right col
                for(int j = rowLow;j<rowHigh;j++){
                    grid[j][colHigh] = grid[j+1][colHigh];
                }
                //bottom row
                for(int j = colHigh;j>colLow;j--){
                    grid[rowHigh][j] = grid[rowHigh][j-1];
                }
                //left col
                for(int j = rowHigh;j>rowLow;j--){
                    grid[j][colLow] = grid[j-1][colLow];
                }
                grid[rowLow + 1][colLow] = temp;
            }
           //move to inner inner layer.
            rowLow++;
            rowHigh--;
            colLow++;
            colHigh--;
        }
        return grid;
    }
}