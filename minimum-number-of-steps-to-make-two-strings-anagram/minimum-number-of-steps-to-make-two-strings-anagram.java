//T:O(n)
//S:O(1) or O(26)


/*
 * The main constraint in the question that says s and t are of the same length.
 * So arr[i] positive means t is deficient of those characters and they need to be added to make it same
 * arr[i] is negative means t is in surplus of those characters and they need to be replaced.
 * Lets says we consider the negative values alone,   
 * if(arr[i] < 0 ) ans+=arr[i] and then we can return -1*ans as well and it would have resulted in same answer
 * Consider an example abcde and aaabd
 * array will look like [-2,0,1,0,1]
 * the sum of negative and postive is always the same
 */


class Solution {
    public int minSteps(String s, String t) {
        if(s.equals(t))return 0;
        int n = s.length(), ans = 0;
        int[] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        for(int i = 0; i < n; i++) {
            arr[sArr[i] - 'a']++;
            arr[tArr[i] - 'a']--;
        }
        
        for(int i : arr){
            if(i > 0){
                ans += i;
            }
        }
        return ans;
    }
}