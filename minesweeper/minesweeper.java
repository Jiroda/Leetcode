class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board==null || board.length==0 || board[0].length ==0){
            return new char[board.length][board[0].length];
        }
        int m = board.length;
        int n = board[0].length;
        int r = click[0];
        int c = click[1];
        if(board[r][c]=='M'){
            board[r][c]='X';
            return board;
        }else{
            dfs(board, r, c, dirs);
        }
        return board;
    }
    
    private void dfs(char[][] board, int r, int c, int[][] dirs){
        if(!isValidCoordinate(board, r, c)){
            return;
        }
        
        if(board[r][c] != 'E'){
            return;
        }
        
        int numMines = findAdjMines(board, r, c, dirs);
        
        if(numMines>0){
            board[r][c] = (char)(numMines+'0');
            return;
        }else{
            board[r][c] = 'B';
            for(int[] dir: dirs){
                dfs(board, r+dir[0], c+dir[1], dirs);
            }
        }
    }
    
    private int findAdjMines(char[][] board, int r , int c, int[][] dirs){
        int count =0;
        for(int[] dir: dirs){
            int newRow = r+dir[0];
            int newCol = c+dir[1];
            if(isValidCoordinate(board, newRow, newCol) && board[newRow][newCol]=='M'){
                count++;
            }
        }
        return count;
    }
    
    private boolean isValidCoordinate(char[][] board, int r, int c){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length){
            return false;
        }
        return true;
    }
}