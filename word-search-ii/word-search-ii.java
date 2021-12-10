class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode trie = buildTrie(words);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                backtrack(board, words, result, trie, i, j);
            }
        }
        return result;
    }
    
    private TrieNode buildTrie(String[] words){
        TrieNode trie = new TrieNode();
        for(String word: words){
            TrieNode root = trie;
            for(char ch: word.toCharArray()){
                int index = ch-'a';
                if(root.children[index]==null){
                    root.children[index] = new TrieNode();
                }
                root = root.children[index];
            }
            root.word = word;
        }
        return trie;
    }
    
    private boolean backtrack(char[][] board, String[] words, List<String> result, TrieNode trie, int row, int col){
        char ch = board[row][col];
        
        //base case
        if(ch=='#' || trie.children[ch-'a']==null){
            return false;
        }
        
        trie = trie.children[ch-'a'];
        if(trie.word!=null){
            result.add(trie.word);
            trie.word = null;
        }
        
        board[row][col]='#';
        
        for(int[] dir: directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            
            if(!isValidCoordinate(newRow, newCol, board.length, board[0].length)){
                continue;
            }
            
            if(backtrack(board, words, result, trie, newRow, newCol)){
                return true;
            }
        }
        
        board[row][col]= ch;
        
        return false;
    }
    
    private boolean isValidCoordinate(int newRow, int newCol, int m, int n){
        if(newRow<0 || newRow>=m || newCol<0 || newCol>=n){
            return false;
        }
        return true;
    }
    
    
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}