class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 0;
        int[][] cache = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                result = Math.max(result, dfs(matrix, i, j, cache, visited));
            }
        }
        return result;
    }
    
    /* I use both memoization and visited array for backtracking although the new coordinate > previous coordinate  
     * will eliminate the need to have a visited array as we wont go to a smaller value cell again
     */
    private int dfs(int[][] matrix, int row, int col, int[][] cache, boolean[][] visited){
        //check cache
        if(cache[row][col]>0){
            return cache[row][col];
        }
        if(visited[row][col]){
            return 0;
        }
        
        //choose
        visited[row][col] = true;
        int currentMaxLength =0; 
        
        //Check all 4 directions from current coordinate
        for(int[] dir: dirs){
            int newRow = row +dir[0];
            int newCol = col +dir[1];
            if(isValid(matrix, row, col, newRow, newCol)){
                int pathLength = dfs(matrix, newRow, newCol, cache, visited);
                currentMaxLength = Math.max(currentMaxLength, pathLength);
            }
        }
        
        cache[row][col] = 1+ currentMaxLength;
        
        //unchoose
        visited[row][col] = false;
        return cache[row][col];
    }
    
    private boolean isValid(int[][] matrix, int row, int col, int newRow, int newCol){
        if(newRow<0 || newRow >=matrix.length || newCol<0 || newCol >= matrix[0].length || 
           matrix[newRow][newCol] <= matrix[row][col])
        {
            return false;
        }
        return true;
    }
}