//T:O(m*n*4^lengthOfWord)
//S:O(length of word)

class Solution {
    int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean flag = dfs(board, word, i, j, 0, new boolean[m][n]);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int row, int col, int pointer, boolean[][] visited){
        //we have successfully found the word
        if(pointer==word.length()){
            return true;
        }
        
        //out of boundary
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }
        
        //If already visited
        if(visited[row][col]){
            return false;
        }
        
        //character at current position does not match the index of the word
        if(board[row][col]!=word.charAt(pointer)){
            return false;
        }
        
        
        visited[row][col] = true;
        
        for(int[] dir: dirs){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            boolean found = dfs(board, word, newRow, newCol, pointer+1, visited);
            if(found){
                return true;
            }
        }
        
        visited[row][col] = false;//We have to set the visited row to false, as it may be used for another path check
        
        return false;
    }
}