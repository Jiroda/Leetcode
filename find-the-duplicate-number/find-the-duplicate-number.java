class Solution {
    
    public int findDuplicate(int[] nums) {
        // 'low' and 'high' represent the range of values of the target        
        int low = 1, high = nums.length - 1;
        int duplicate = -1;
        
        while (low <= high) {
            int mid = low + (high-low) / 2;

            // Count how many numbers in 'nums' are less than or equal to 'mid'
            int count = 0;
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            
            if (count > mid) {
                duplicate = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return duplicate;
    }
}
