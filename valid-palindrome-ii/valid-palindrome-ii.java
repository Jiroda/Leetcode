class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        int numOfDeletionsPossible = 1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                if(numOfDeletionsPossible==0){
                    return false;
                }
                return isValidPalindrome(s, left+1, right, numOfDeletionsPossible-1) 
                    || isValidPalindrome(s, left, right-1, numOfDeletionsPossible-1);
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean isValidPalindrome(String s, int left, int right, int numOfDeletionsPossible){
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