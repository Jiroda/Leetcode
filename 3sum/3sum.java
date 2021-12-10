//T:O(n^2)
//S:O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0 || nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            //check dupes
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]>0){
                break;
            }
            int required = 0-nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int currSum = nums[left]+nums[right];
                if(currSum==required){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(currSum<required){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }
}