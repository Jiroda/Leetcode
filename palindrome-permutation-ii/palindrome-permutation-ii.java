class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> freqMap = determineFreqOfCharacters(s);
        int numOfOddOccurenceChars =0;
        Character oddChar = null;
        int length = 0;
        for(char c: freqMap.keySet()){
            int freq = freqMap.get(c);
            if(freq%2==1){
                oddChar = c;
                numOfOddOccurenceChars++;
            }
            freqMap.put(c, freq/2);
            length+=freq/2;
        }
        //Base case
        if(numOfOddOccurenceChars>1){
            return new ArrayList<String>();
        }
        
        helper(res, s, 0, length, freqMap, oddChar, new StringBuilder());
        return res;
    }
    
    private void helper(List<String> res, String s, int currLength, int totalLength, HashMap<Character, Integer> freqMap, Character oddChar, StringBuilder sb ){
        
        if(currLength>=totalLength){
            // form the palindromic string
            String mid = (oddChar!=null)? oddChar.toString() : "";
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for(char c: freqMap.keySet()){
            int freq = freqMap.get(c);
            if(freq>0){
                freqMap.put(c, freq-1);
                sb.append(c);
                helper(res, s, currLength+1, totalLength, freqMap, oddChar, sb);
                sb.deleteCharAt(sb.length()-1);
                freqMap.put(c, freq);
            }
        }
        
    }
        
    private HashMap<Character, Integer> determineFreqOfCharacters(String s){
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }
        
        return freqMap;
    }
}