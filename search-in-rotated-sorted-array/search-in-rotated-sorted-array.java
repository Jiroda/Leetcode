class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid]>=nums[left]){
                //left half is the only half thats sorted
                if(target>=nums[left] && target<nums[mid]){
                    right = mid-1;
                }else{
                    left =  mid+1;
                }
            }else{
                //right half is the only half thats sorted
                if(target> nums[mid] && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        
        return -1;
    }
}