//T:O(nlogn)
//S:O(1)
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int minMoves = 0;
        for(int i=0; i<nums.length; i++){
            minMoves+= Math.abs(nums[0]- nums[i]);
        }
        return minMoves;
    }
}