//T:O(n+q)n->length of array q->number of updates
//https://www.youtube.com/watch?v=-SDHYqxI-Hc
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        
        //1.go through the update queries add and remove impact for the prefix sum
        for(int[] update : updates){
            int startIndex = update[0];
            int endIndex = update[1];
            int increment = update[2];
            
            result[startIndex]+=increment;
            if(endIndex+1<length){
                result[endIndex+1]-=increment;
            }
        }
        
        //2.find prefix sum
        for(int i=1; i<length; i++){
            result[i]+=result[i-1];
        }
        
        return result;
    }
}