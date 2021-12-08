//T:O(log(n-k)+k)
//S:O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int pos = 0;
        
        while(left <= right) {
            int m = left + (right - left) / 2;
            if(arr[m] <= x) {
                pos = m;
                left = m + 1;
            }else {
                right = m - 1;
            }
        }
        
        left = (pos - k < 0) ? 0 : pos - k;
        right = (pos + k >= n) ? n - 1 : pos + k;

        
        while(right - left + 1 != k) {
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            }else {
                right--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}