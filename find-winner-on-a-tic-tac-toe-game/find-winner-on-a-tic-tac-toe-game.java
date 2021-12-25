//T:O(m) m->number of moves
//S:O(n) n->number of cells
class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int diag = 0;
        int antidiag=0;
        int[] rows = new int[n];
        int[] cols = new int[n];
        boolean playerA = true;
        for(int[] move : moves){
            int row = move[0];
            int col = move[1];
            rows[row] += playerA ? 1:-1;
            cols[col] += playerA ? 1:-1;
            if(row==col){
                diag += playerA ? 1:-1;
            }
            if(row+col==n-1){
                antidiag += playerA ? 1:-1;
            }
            
            if(rows[row]==n || cols[col]==n || diag==n || antidiag==n){
                return "A";
            }else if(rows[row]==-n || cols[col]==-n || diag==-n || antidiag==-n){
                return "B";
            }
            playerA = playerA==false ? true : false;
        }
        
        return moves.length == n*n ? "Draw" : "Pending";
    }
}