class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int word_i, int i, int j, boolean[][] visited) {
        if (word_i == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || visited[i][j]) {
            return false;
        }
        if (word.charAt(word_i) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean existed = 
            dfs(board, word, word_i + 1, i + 1, j, visited) ||
            dfs(board, word, word_i + 1, i - 1, j, visited) ||
            dfs(board, word, word_i + 1, i, j + 1, visited) ||
            dfs(board, word, word_i + 1, i, j - 1, visited);
        visited[i][j] = false;
        return existed;
    }
}