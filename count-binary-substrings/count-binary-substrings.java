//T:O(n)
//S:O(1)

class Solution {
    public int countBinarySubstrings(String s) {
        int numSubstrings=0;
        // This is the number of similar consecutive chars either '1' or '0' of previous group
        int prevCount=0;
        int index=0;
        int n = s.length();
        while(index<n){
            /* This is the number of similar consecutive chars either '1'/'0' of current group
             * We set it to one because we have already started the current group by parsing
             * the current char*/
            int currCount =1;
            while(index<n-1 && s.charAt(index)==s.charAt(index+1)){
                currCount+=1;
                index++;
            }
            //Now we are at a point where the current char is not the same as previous
            if(prevCount>0){
                /* The number of substrings with equal 1,0s contiguously is the min of the prev
                 * and current group of simialr consecutive chars*/
                numSubstrings+=Math.min(prevCount, currCount);
            }
            prevCount = currCount;
            index++;
        }
        return numSubstrings;
    }
}
