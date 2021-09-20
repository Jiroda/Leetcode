//T:O(n*n)
//S:O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int box = (i / 3) * 3 + j / 3;
                    if (rows[i][num - 1] || cols[j][num - 1] || boxes[box][num - 1]) {
                        return false;
                    }
                    rows[i][num - 1] = true;
                    cols[j][num - 1] = true;
                    boxes[box][num - 1] = true;
                }
            }
        }
        return true;
    }
}