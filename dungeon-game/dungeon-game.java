//T:O(m*n)
//S:O(m*n)

//https://www.youtube.com/watch?v=LbC0ejgACkE
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[][] dp = new int[r][c];
        //Important dont start from top left but start from bottom right 
        dp[r-1][c-1] = dungeon[r-1][c-1]>0 ? 1: Math.abs(dungeon[r-1][c-1])+1;
        //last column
        for(int i=r-2; i>=0; i--){
            dp[i][c-1] = Math.max(dp[i+1][c-1]-dungeon[i][c-1], 1);
        }
        //last row
        for(int j=c-2; j>=0; j--){
            dp[r-1][j] = Math.max(dp[r-1][j+1]-dungeon[r-1][j], 1);
        }
        
        for(int i=r-2; i>=0; i--){
            for(int j=c-2; j>=0; j--){
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) -(dungeon[i][j]), 1);
            }
        }
        
        return dp[0][0];
    }
}