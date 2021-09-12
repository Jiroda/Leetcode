//T:O(2^n*k) k is the maximum length of the words
//S:O(2^n*k)

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freqArr = new int[score.length];
		for (char ch : letters) {
			freqArr[ch - 'a']++;
		}
        return backtrack(words, freqArr, score, 0);
    }
    
    private int backtrack(String[] words, int[] freqArr, int[] score, int index){
        if(index==words.length){
            return 0;
        }
        
        //backtrack without including the current word
        int scoreWithoutIncludingCurrentWord = 0 + backtrack(words, freqArr, score, index+1);
        
        //backtrack including the current word
        
        String currentWord=words[index];
	    
        int scoreWord=0;
	    boolean flag=true;
	    
        for(int i=0; i<currentWord.length(); i++){
	        char ch= currentWord.charAt(i);
	        
	        if(freqArr[ch-'a']==0){
	            flag=false;
	            
	        }
            
	        freqArr[ch-'a']--;
	        scoreWord+=score[ch-'a'];
	    }
        
        int scoreWithCurrentWordIncluded = 0;
        
        if(flag){
            scoreWithCurrentWordIncluded = scoreWord + backtrack(words, freqArr, score, index+1);
        }
        
        for(int i=0; i<currentWord.length(); i++){
	        char ch= currentWord.charAt(i);
	        freqArr[ch-'a']++;
	    }
	    
		return Math.max(scoreWithoutIncludingCurrentWord, scoreWithCurrentWordIncluded);
    }
}