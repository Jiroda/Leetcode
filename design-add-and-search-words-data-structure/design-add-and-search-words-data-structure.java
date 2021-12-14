//T:O(N*26^m) n->number of keys and m-> key length
//S:O(m)
class WordDictionary {
    TrieNode node;
    public WordDictionary() {
        node = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode root = node;
        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(root.children[index]==null){
                root.children[index] = new TrieNode();
            }
            root = root.children[index];
        }
        root.isWord = true;
    }
    
    public boolean search(String word) {
        return backtracking(word.toCharArray(), node, 0);
    }
    
    private boolean backtracking(char[] wordArr, TrieNode node, int pointer){
        if(pointer==wordArr.length){
            return node.isWord;
        }
        
        if(wordArr[pointer]=='.'){
            //go through all children
            for(int i=0;i<26; i++){
                if(node.children[i]!=null){
                    if(node.children[i]!=null && backtracking(wordArr, node.children[i], pointer+1)){
                        return true;
                    }
                }
            }
        }else{
            int index = wordArr[pointer]-'a';
            if(node.children[index]==null){
                return false;
            }
            return backtracking(wordArr, node.children[index], pointer+1);
        }
        
        return false;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord = false;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */