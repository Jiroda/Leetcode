//T:O(n)
//S:O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int n: nums){
            uniqueNums.add(n);
        }
        int longestConsecutive = 0;
        for(int i=0; i<nums.length; i++){
            int currentLength =1;
            int number = nums[i];
            
            //check if the set has all the numbers < this number 
            while (uniqueNums.contains(--number)) {
              currentLength++;
              uniqueNums.remove(number);
            }
            
            number = nums[i];
            //check if the set has all the numbers > this number 
            while (uniqueNums.contains(++number)) {
              currentLength++;
              uniqueNums.remove(number);
            }
            
            longestConsecutive = Math.max(longestConsecutive, currentLength);
        }
        
        return longestConsecutive;
    }
}