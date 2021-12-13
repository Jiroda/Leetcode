//T:O(n)
//S:O(n)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cummalativeSum = 0;
        int res = 0;
        for(int i=0; i<nums.length; i++){
            cummalativeSum += nums[i];
            int remainder = cummalativeSum%k;
            if(remainder <0){
                remainder+=k;
            }
            if(map.containsKey(remainder)){
                res+= map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) +1);
        }
        return res;
    }
}