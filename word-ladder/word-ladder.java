class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<String>(wordList);
        if(!wordDict.contains(endWord)) return 0;   
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int numTransformations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i<size; i++){
                String currentWord = queue.poll();
                //exit condition
                if(currentWord.equalsIgnoreCase(endWord)) return numTransformations+1;
                applyTransformation(currentWord, endWord, wordDict, queue);
            }
            numTransformations++;
        }
        return 0; //Even after all the processing we havent quite found the end word
    }
    
    private void applyTransformation(String currentWord, String endWord, Set<String> wordDict, Queue<String> queue){
        for(int i=0; i<currentWord.length(); i++){
            char[] currentWordArr = currentWord.toCharArray();
            for(char c='a'; c<='z'; c++){
                if(currentWordArr[i]== c){
                    continue;
                }
                currentWordArr[i] = c;
                String newWord = String.valueOf(currentWordArr);
                if(wordDict.contains(newWord)){
                    wordDict.remove(newWord);
                    queue.offer(newWord);
                }
            }
        }
    }
    
}