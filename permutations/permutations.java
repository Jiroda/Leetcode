class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        backtrack(nums, res, new ArrayList<>(), map);
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tempList, HashMap<Integer, Integer> map){
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int key: map.keySet()){
            if(map.get(key)>0){
                map.put(key, map.get(key)-1);
                tempList.add(key);
                backtrack(nums, res, tempList, map);
                tempList.remove(tempList.size()-1);
                map.put(key, map.get(key)+1);
            }
        }
    }

}
