//T:O(n)
//S:O(n)
class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodings(dp, s, 0); 
    }
    
    int numDecodings(int[] dp, String s, int pos) {
        if(pos >= s.length())
            return 1;
        if(s.charAt(pos) == '0')
            return 0;
        
        if(dp[pos] != -1)
            return dp[pos];
        
        int result = 0;
        // one position movement
        result += numDecodings(dp, s, pos + 1);
        // 2 position movement
        if(pos + 2 <= s.length() && isValid(s.substring(pos, pos + 2)))
            result += numDecodings(dp, s, pos + 2);
        
        return (dp[pos] = result);
    }
    
    boolean isValid(String num) {
        int n = Integer.parseInt(num);
        return n > 0 && n < 27;
    }
}