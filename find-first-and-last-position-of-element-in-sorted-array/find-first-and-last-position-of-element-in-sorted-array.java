class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int startIndex = binarySearch(nums, target, true);
        int endIndex = binarySearch(nums, target, false);
        ans[0] = startIndex;
        ans[1] = endIndex;
        return ans;
    }
    
    private int binarySearch(int[] nums, int target, boolean findStartingIndex){
        int ans =-1;
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid =left+(right-left)/2;
            if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }else{
                if(findStartingIndex){
                    //We found the number check if there are duplicates before this 
                    ans = mid;
                    right = mid-1;
                }else{
                    ans = mid;
                    left = mid+1;
                }
            }
        }
        return ans;
    }
}