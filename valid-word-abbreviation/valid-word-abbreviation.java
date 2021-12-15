//T:O(n)
//S:O(1)
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j=0;
        while(i<word.length() && j<abbr.length()){
            if(word.charAt(i)==abbr.charAt(j)){
                i++;
                j++;
            }else if(Character.isDigit(abbr.charAt(j)) && abbr.charAt(j)!='0'){
                int skipNumber =0;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    skipNumber = skipNumber*10 + abbr.charAt(j++) -'0';
                }
                i+=skipNumber;
            }else{
                return false;
            }
        }
        
        return (i==word.length()) && (j==abbr.length());
    }
} 