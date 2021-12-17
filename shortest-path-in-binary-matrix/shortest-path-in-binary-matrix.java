//T:O(m*n)
//S:O(m*n)
class Solution {
    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return -1;
        }
        int m= grid.length;
        int n = grid[0].length;
        if(grid[0][0]!=0){
            return -1;
        }
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] currPos = queue.poll();
                int currRow = currPos[0];
                int currCol = currPos[1];
                //exit case
                if(currRow == m-1 && currCol ==n-1){
                    return level;
                }
                for(int[] dir: dirs){
                    int newRow = currRow+dir[0];
                    int newCol = currCol+dir[1];
                    if(isValidCoordinate(newRow, newCol, grid, visited)){
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private boolean isValidCoordinate(int r, int c, int[][] grid, boolean[][] visited){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=0 || visited[r][c]){
            return false;
        }
        return true;
    }
}