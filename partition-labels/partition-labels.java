//T:O(n)
//S:O(1) or O(26) 26 alphabets
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //map to store the unique character and its last occurrence index
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        int end =0;
        int size = 0;
        int curr =0;
        while(curr<s.length()){
            char c = s.charAt(curr);
            int lastIndex = map.get(c);
            if(lastIndex>end){
                end = lastIndex;
            }
            size++;
            if(curr==end){
                result.add(size);
                size =0;
            }
            curr++;
        }
        
        return result;
    }
}