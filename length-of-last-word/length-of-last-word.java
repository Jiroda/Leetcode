//T:O(n)
//S:O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.isEmpty()) return 0;
        int lengthOfLastWord = 0;
        int length = s.length();
        int lastIndex = length-1;
        while(lastIndex>=0){
            if(s.charAt(lastIndex) != ' '){
                lengthOfLastWord++;
                lastIndex--;
            }else{
                if(lengthOfLastWord>0){
                    return lengthOfLastWord;
                }else{
                    lastIndex--;
                }
            }
        }
        return lengthOfLastWord;
    }
}