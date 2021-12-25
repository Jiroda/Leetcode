//T:O(n)
//S:O(1)
class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
		Arrays.sort(freq);
        int maxFreq = freq[25];
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            // remember the array is sorted in reverse order so when we hit zero no use checking any further
            if (freq[i] == 0) break;
            
            if (freq[i] > maxFreq) {
                res += freq[i] - maxFreq;
            } else {
                maxFreq = freq[i];
            }
            
            if (maxFreq > 0) {
                maxFreq--; // Lowest max is zero, cannot be negative
            }
        }
        return res;
    }
}