//T:O(m*n)
//S:O(m*n)
class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int currDir = 0;
    int m, n =0;
    public int numberOfCleanRooms(int[][] room) {
        m =room.length;
        n = room[0].length;
        int currRow = 0;
        int currCol = 0;
        int count =0;
        Set<List<Integer>> visited = new HashSet<>();
        Set<List<Integer>> cleaned = new HashSet<>();
        
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col){
                if (room[row][col]==0){
                    count++;
                }
            }
        }
        
        while(cleaned.size() < count && visited.add(List.of(currRow, currCol, currDir))){
            cleaned.add(List.of(currRow, currCol));
            if(shouldTurnRight(currRow, currCol, currDir, room)){
                currDir = (currDir+1)%dirs.length;
            }else{
                currRow += dirs[currDir][0];
                currCol += dirs[currDir][1];
            }
        }
        
        return cleaned.size();
    }
    
    private boolean shouldTurnRight(int row, int col, int currDir, int[][] room) {
        int nextRow = row + dirs[currDir][0];
        int nextCol = col + dirs[currDir][1];
        if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || room[nextRow][nextCol]==1){
            return true;
        }
        return false;
    }
}