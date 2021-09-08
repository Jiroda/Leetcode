//T:O(length of s + length of t)
//S:O(length of s + 1)

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        for(char c: t.toCharArray()){
            if(!map.containsKey(c) || map.get(c)==0){
                return c;
            }
            int curr = map.get(c)-1;
            map.put(c, curr);
                
        }
        return ' ';
    }
}