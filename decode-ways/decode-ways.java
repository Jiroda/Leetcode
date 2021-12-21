//T:O(n)
//S:O(n)

class Solution {
    public int numDecodings(String s) {
        Integer memo[] = new Integer[s.length()];
        return numDecodings(memo, s, 0); 
    }
    
    int numDecodings(Integer[] memo, String s, int pos) {
        //if we reached the end of the string or overshot it
        if(pos >= s.length()){
            return 1;
        }
        
        //if the char at curr position is 0 we return 0 ways
        if(s.charAt(pos) == '0')
            return 0;
        
        //does the cache already have it
        if(memo[pos] != null)
            return memo[pos];
        
        int result = 0;
        
        // one position movement
        int oneWay = numDecodings(memo, s, pos + 1);
        result+=oneWay;
        
        // 2 position movement
        if(pos + 2 <= s.length() && isValid(s.substring(pos, pos + 2))){
            int twoWay = numDecodings(memo, s, pos + 2);
            result+=twoWay;
        }
        
        //store result for the current position in the memo
        memo[pos] = result;
        
        return memo[pos];
    }
    
    boolean isValid(String num) {
        int n = Integer.parseInt(num);
        return n > 0 && n < 27;
    }
}