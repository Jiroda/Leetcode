//T:O(nlogn)
//S:O(1)
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 0;
        int high = position[n-1];
        int optimalGap = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            //use mid as a high threshold for maximum gap
            if(canPlace(position, m, mid)){
                optimalGap = mid;
                //search for a better gap 
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return optimalGap;
    }
    
    public static boolean canPlace(int[] position, int m, int maxGap){
        int count =1;
        int prevPosition = position[0];
        for(int i=1; i<position.length; i++){
            int currentGap = position[i] - prevPosition; 
            if(currentGap >= maxGap){
                prevPosition = position[i];
                count++;
            }
        }
        return count >=m;
    } 
}