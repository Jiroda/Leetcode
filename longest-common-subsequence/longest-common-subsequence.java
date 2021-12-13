//Space optimized
//T:O(m*n) where m->length pf text1, n-> length of text2
//S:O(min(m,n))
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //find the smallest of the 2 strings if so swap
        if(text1.length()>text2.length()){
            String temp = text2;
            text2 = text1;
            text1 = temp;
        }
        
        int[] previousRow = new int[text1.length()+1];
        for(int row=1; row<=text2.length(); row++){
            int[] currentRow = new int[text1.length()+1];
            for(int col=1; col<=text1.length(); col++){
                if(text2.charAt(row-1)==text1.charAt(col-1)){
                    currentRow[col] = 1+previousRow[col-1];
                }else{
                    currentRow[col] = Math.max(previousRow[col], currentRow[col-1]);
                }
            }
            previousRow = currentRow;
        }
        
        return previousRow[text1.length()];
    }
}
