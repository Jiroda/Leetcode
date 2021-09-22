class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int row, int col){
        //move to the next row if we have reached the last column
        if(col==board[0].length){
            row += 1;
            col = 0;
        }
        
        //exit case
        if(row==board.length){
            return true;
        }
        
        //logic starts
        if(board[row][col]!='.'){
            return solve(board, row, col+1);
        }else{
            for(char num ='1'; num<='9'; num++){
                if(isValid(board, row, col, num)){
                    board[row][col] = num;
                    if(solve(board, row, col+1)){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        
        return false;
    }
                   
    private boolean isValid(char[][] board, int i, int j, char num){
        for(int row=0; row<9; row++){
            if(board[row][j]== num){
                return false;
            }
        }
        
        for(int col=0; col<9; col++){
            if(board[i][col]== num){
                return false;
            }
        }      
        
        int gridX = i/3 * 3; //top left corner x coordinate of the grid
        int gridY = j/3 * 3; //top left corner y coordinate of the grid
        
        for(int incX=0; incX<3; incX++){
            for(int incY=0; incY<3; incY++){
                if(board[gridX+incX][gridY+incY] == num){
                    return false;
                } 
            }
        }
        
        return true;
    }             
    
}