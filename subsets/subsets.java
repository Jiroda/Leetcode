class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp , int curr){
        if(curr==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        //choose
        temp.add(nums[curr]);
        //recurse
        backtrack(nums,result, temp, curr+1);
        //unchoose
        temp.remove(temp.size()-1);
        
        //recurse without including the number
        backtrack(nums,result, temp, curr+1);
        
    } 
}