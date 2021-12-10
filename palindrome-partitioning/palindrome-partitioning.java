class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void helper(String s, List<List<String>> result, List<String> temp, int start){
        if(start>=s.length()){
            result.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int i=start; i<s.length(); i++){
            String prefix = s.substring(start, i+1);
            if(isPalindrome(prefix)){
                temp.add(prefix);
                helper(s, result, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}