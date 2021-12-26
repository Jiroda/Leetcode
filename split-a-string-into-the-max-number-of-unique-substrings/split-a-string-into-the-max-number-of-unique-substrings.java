//T:O(2^n)
//S:O(n)
class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, 0, new HashSet<String>());
        return max;
    }
    
    private void backtrack(String s, List<List<String>> result, int curr, HashSet<String> temp){
        if(curr==s.length()){
            max = Math.max(max, temp.size());
            return;
        }
        
        if(curr>s.length()){
            return;
        }
        
        for(int i=curr; i<s.length(); i++){
            String segment = s.substring(curr, i+1);
            if(temp.contains(segment)){
                continue;
            }
            temp.add(segment);
            backtrack(s, result, i+1, temp);
            temp.remove(segment);
        }
    }
}