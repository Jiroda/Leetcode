class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peak = -1;
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>arr[mid+1]){
                peak = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return peak;
    }
}