//T:O(n)
//S:O(n)
class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int numOfOddOccurrenceChars =0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2==1){
                numOfOddOccurrenceChars++;
            }
        }
        
        if(numOfOddOccurrenceChars >1){
            return false;
        }
        
        return true;
    }
}