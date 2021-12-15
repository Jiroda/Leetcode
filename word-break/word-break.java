//T:O(n^2)
//S:O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, dict, memo, 0);
    }
    
    private boolean helper(String s, HashSet<String> dict, Boolean[] memo, int pointer){
        if(pointer==s.length()){
            return true;
        }
        //does cache have it already?
        if(memo[pointer]!=null){
            return memo[pointer];
        }
        
        for(int next = pointer+1; next<=s.length(); next++){
            if(dict.contains(s.substring(pointer, next)) && helper(s, dict, memo, next)){
                memo[pointer] = true;
                return true;
            }
        }
        
        memo[pointer] = false;
        return false;
    }
}