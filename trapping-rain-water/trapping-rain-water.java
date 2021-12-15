//T:O(n)
//S:O(n)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans =0;
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];
        
        //initialize 
        leftMaxHeight[0] = height[0];
        rightMaxHeight[n-1] = height[n-1];
        
        //init variables
        int leftMax = leftMaxHeight[0];
        int rightMax = rightMaxHeight[n-1];
        
        //fill the leftMaxHeight array
        for(int i=1; i<n; i++){
            leftMax = Math.max(leftMax, height[i]);
            leftMaxHeight[i] = leftMax;
        }
        
        //fill the rightMaxHeight array
        for(int i=n-2; i>0; i--){
            rightMax = Math.max(rightMax, height[i]);
            rightMaxHeight[i] = rightMax;
        }
        
        //ignore first and last pillar as they cannot hold any water
        for(int i=1; i<n-1; i++){
            int minHeight = Math.min(rightMaxHeight[i], leftMaxHeight[i]);
            ans += minHeight - height[i];
        }
        
        return ans;
    }
}