//T:O(n)
//S:O(1)
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return;
        }
        int left = 0;
        int right = n - 1;
        int current = 0;
        while(current <= right) {
            if(nums[current] == 0){
                swap(nums, left, current);
                left++;
                current++;
            } else if(nums[current] == 1) {
                current++;
            } else if(nums[current] == 2){
                swap(nums, right, current);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}