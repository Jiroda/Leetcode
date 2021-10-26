//T:O(n)
//S:O(1)

class Solution {
    public int removePalindromeSub(String s) {
        if(s==null || s.isEmpty()) return 0;
        if(isPalindrome(s, 0, s.length()-1)){
            return 1;
        }
        return 2; // since the string contains only a and b there are only 3 outcomes 0,1,2
    }
    
    private boolean isPalindrome(String s, int left , int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}