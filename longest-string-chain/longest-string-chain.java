class Solution {
    public int longestStrChain(String[] words) {
        int ans = 1;
        int[] dp = new int[words.length];
        Arrays.sort(words, (w1, w2)-> w1.length() - w2.length());
        dp[0]=1;
        for(int i=0; i<dp.length; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0 && words[j].length() >= words[i].length()-1; j--){
                if(words[j].length() == words[i].length()-1 && isPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
    
    private boolean isPredecessor(String s1, String s2){
        if((s2.length() - s1.length()) != 1) {
            return false;
        }
        int length1 = s1.length();
        int index = 0;
        while(index < length1 && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        if(index == length1) {
            return true;
        }
        while(index < length1 && s1.charAt(index) == s2.charAt(index + 1)) {
            index++;
        }
        return (index == length1);
    }
}