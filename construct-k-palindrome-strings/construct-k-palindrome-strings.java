//T:O(n)
//S:O(26)
class Solution {
    public boolean canConstruct(String s, int k) {
        int oddOccurenceChars = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        for(char c: freqMap.keySet()){
            if(freqMap.get(c)%2==1){
                oddOccurenceChars++;
            }
        }
        
        return oddOccurenceChars <=k && k<=s.length();
    }
}