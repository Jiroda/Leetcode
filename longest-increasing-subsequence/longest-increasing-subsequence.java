class Solution {      
    public int lengthOfLIS(int[] nums) {
		if(nums.length == 0 || nums.length == 1) return nums.length;
		
		int parent[] = new int[nums.length]; // Tracking the predecessors/parents of elements of each subsequence.
		int dp[] = new int[nums.length + 1]; // Tracking ends of each increasing subsequence.
		int maxLength = 0;
        int maxIdx = -1; // Length of longest subsequence.

		//Initialize
		Arrays.fill(dp, 1);
		Arrays.fill(parent, -1);

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;				
				}
			}
			if (dp[i] > maxLength) {
				maxLength = dp[i];
				maxIdx = i;
			}
		}

		// Generate LIS by traversing parent array
		int LIS[] = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			LIS[i] = nums[maxIdx];
			maxIdx = parent[maxIdx];
		}

		for (int i = 0; i < maxLength; i++) {
			System.out.print(LIS[i] + ",");
		}
		return maxLength;
	}
    
}