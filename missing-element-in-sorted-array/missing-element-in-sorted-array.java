class Solution {
    public int missingElement(int[] nums, int k) {
        int diff = 0;
        for(int i=0 ;i<nums.length-1; i++){
            int j = i+1;
            diff = nums[j]-nums[i]-1;
            if(diff==0){
                continue;
            }
            if(k <= diff){
                return nums[i]+k;
            }else{
                k = k-diff;
            }
        }
        return k>0 ? nums[nums.length-1]+k : -1;
    }
}