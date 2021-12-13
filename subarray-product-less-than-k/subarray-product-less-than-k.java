//T:O(n)
//S:O(1)
class Solution {
    //sliding window since 1 <= nums[i] <= 1000 and they are non negative
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int product =1;
        int left = 0;
        int ans = 0;
        for(int right = 0; right<nums.length; right++){
            product *= nums[right];
            while(product>=k){
                //move left
                product/=nums[left];
                left++;
            }
            
            ans+= right-left+1;
        }
        return ans;
    }
}