//T:O(n)
//S:O(n)
class Solution {
    public int minFlipsMonoIncr(String s) {
        //prefix[i] as the minimum number of flips (1 to 0) for prefix s[0, i], where 0 <= i <= n - 1.
        //suffix[i] as the minimum number of flips (0 to 1) for suffix s[i, n-1], where 0 <= i <= n - 1.
        int n = s.length();
        int[] prefix = new int[n];//to count the number of ones to the left of the curr index
        int[] suffix = new int[n];//to count the number of zeroes to the right of the curr index
        prefix[0]= s.charAt(0) == '1' ? 1 : 0;
        suffix[n-1]= s.charAt(n-1) =='0' ? 1 : 0;
        for(int i=1, j=n-2; i<n; i++,j--){
            prefix[i] = prefix[i-1]+(s.charAt(i) =='1' ? 1 : 0);
            suffix[j] = suffix[j+1]+(s.charAt(j) =='0' ? 1 : 0);
        }
        int minFlips = n; //max num of flips possible is the length of the string
        for(int k=-1; k<=n-1; k++){
            int left = (k == -1) ? 0 : prefix[k];
            int right = (k+1 == n) ? 0 : suffix[k+1];
            minFlips = Math.min(minFlips, left+right);
        }
        
        return minFlips;
    }
}