class Solution {
    public int findKthPositive(int[] nums, int k) {
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int missingElements = findMissingNumbersTillCurrentIndex(nums, mid);
            if(missingElements < k){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(right<0 && k>0){
             return 0+k;          
        }
        return nums[right] + (k - findMissingNumbersTillCurrentIndex(nums, right));
    }
    
    private int findMissingNumbersTillCurrentIndex(int[] nums, int index){
        return nums[index] - 1 - index;
    }
}