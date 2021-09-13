class Solution {
    public int firstUniqChar(String s) {
        int[] freqCount = new int[26];
        char[] sArr = s.toCharArray();
        for(char c: sArr){
            freqCount[c-'a']++;
        }
        for(int i=0; i<sArr.length; i++){
            if(freqCount[sArr[i]-'a']==1){
                return i;
            }
        }
        
        return-1;
    }
}