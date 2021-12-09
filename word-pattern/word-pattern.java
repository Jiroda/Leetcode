//T:O(n) n->number of words in the string s or number of characters in the pattern whichever is greater
//S:O(m) m->number of unique words in s
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String, Boolean> usedMap = new HashMap<>();
        int patternIndex = 0;
        String[] tokens = s.split("\\s");
        if(pattern.length() != tokens.length){
            return false;
        }
        for(String token : tokens){
            char patternChar = pattern.charAt(patternIndex);
            if(!map.containsKey(patternChar)){
                if(!usedMap.containsKey(token)){
                    usedMap.put(token, true);
                }else{
                    return false;
                }
                map.put(patternChar, token);
            }else{
                if(usedMap.containsKey(token) && !token.equals(map.get(patternChar))){
                    return false;
                }
                if(!usedMap.containsKey(token) && !token.equals(map.get(patternChar))){
                    return false;
                }
            }
            patternIndex++;
        }
        return true;
    }
}