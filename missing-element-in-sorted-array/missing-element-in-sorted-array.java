class Solution {
    public int missingElement(int[] nums, int k) {
        //binary search
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int missingElements = findMissingNumbersTillCurrentIndex(nums, mid);
            if(missingElements<k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return nums[left-1] + k -findMissingNumbersTillCurrentIndex(nums, left-1);
    }
    
    private int findMissingNumbersTillCurrentIndex(int[] nums, int index){
        return nums[index] - nums[0] - index;
    }
}