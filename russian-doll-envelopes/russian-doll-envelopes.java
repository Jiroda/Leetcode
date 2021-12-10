//T:O(n^2)
//S:O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        int omax = 0;
        int dp [] = new int [envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            omax = Math.max(dp[i], omax);
        }
        return omax;
    }
}