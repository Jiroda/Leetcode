//T:O(n*2^n)
//S:O(n)
class Solution {
    int maxLength =0;
    
    public int maxLength(List<String> arr) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, arr, new StringBuilder(), result); 
        return maxLength;
    }
    
    public void backtrack(int curr, List<String> arr, StringBuilder sb, List<List<String>> result) {
        if(curr == arr.size()) {
            if(uniqueCharCount(sb.toString()) > maxLength){
                maxLength = sb.length();
            }
            return;
        }
        
        int length = sb.length();
        sb.append(arr.get(curr));
        backtrack(curr + 1, arr, sb, result);
        sb.setLength(length);
        
        backtrack(curr + 1, arr, sb, result);
    }
    
    public int uniqueCharCount(String str) {
        int[] count = new int[26];
        for(char c : str.toCharArray()){
            if(count[ c - 'a'] > 0) {
                return -1;
            }
            count[ c - 'a']++;
        }
        return str.length();
    }
}