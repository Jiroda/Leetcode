//T:O(n)
//S:O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        int inflectionPt = -1;
        //find the inflection point
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                inflectionPt = i;
                break;
            }
        }
        if(inflectionPt==-1){
            reverse(nums, 0);
            return;
        }
        
        
        //find the next greater number than the number at the inflection pt
        int largerThanInflectionPt = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>nums[inflectionPt]){
                largerThanInflectionPt = i;
                break;
            }
        }
        
        swap(nums, inflectionPt, largerThanInflectionPt);
        
        //reverse the suffix
        reverse(nums, inflectionPt+1);
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverse(int[] nums, int start){
        int left = start;
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}