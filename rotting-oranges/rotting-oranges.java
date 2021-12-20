//T:O(m*n)
//S:O(m*n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int minMinutes = 0;
        int numFreshOranges = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    numFreshOranges++;
                }
            }
        }
        
        if(numFreshOranges==0){
            return 0;
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                for(int[] dir: dirs){
                    int newRow = curr[0]+dir[0];
                    int newCol = curr[1]+dir[1];
                    if(!isValidCoordinate(newRow, newCol, grid)){
                        continue;
                    }
                    grid[newRow][newCol] = 2;//make the orange at the new grid rotten
                    queue.offer(new int[]{newRow, newCol});
                    numFreshOranges-=1;
                }
            }
            minMinutes++;
        }
        
        return numFreshOranges==0 ? minMinutes-1:-1;
    }
    
    private boolean isValidCoordinate(int row, int col, int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0 || grid[row][col]==2){
            return false;
        }
        return true;
    }
}