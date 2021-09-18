class Solution {
    public int lengthOfLIS(int[] nums) {
/*
        Could you improve it to O(n log(n)) time complexity?

        Yes, using binary search. This method will not tell us actual LIS but its length only.
        Binary Search is used as we get sorted array and we can find ceil.
*/
        if(nums.length == 1)
        {
            return 1;
        }
        
        int [] dp = new int [nums.length];
        
        dp[0] = nums[0]; // as 1 length LIS is atleast possible
        int ans = 1; // storing the length of current LIS
        
        for(int i=1;i<nums.length;i++)
        {
            // if current val > stored, LIS can be formed and new value added
            if(nums[i]>dp[ans-1])
            {
                dp[ans]=nums[i];
                ans++;
            }
            
            else if (nums[i]==dp[ans-1]){
                continue;
            }
            
        else{
            
            // now if current val < stored means improvement possible
            // we search the ceil and replace with it 
            // ceil using binary search
        
            int lo = 0;
            int hi = ans -1;
            int temp =0;
            
            while(lo<hi)
            {
                int mid = lo + (hi - lo)/2;
                
                if(dp[mid]<nums[i])
                {
                    // ceil will be found on right side
                        lo = mid+1;
                } 
               
                else{
                    // ceil will be found on left
                    hi = mid;
                }
                
            }
        
            dp[lo] = nums[i];    
  
        }
            
        }
        
        // it might print right answer
        for(int i=0;i<ans;i++)
        {
            System.out.print(dp[i] + ",");
        }
        
        return ans;
    }
}