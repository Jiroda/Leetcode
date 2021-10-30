/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr);
        int leftHalfResult = binarySearch(target, mountainArr, 0, peakIndex-1, true);
        int rightHalfResult = binarySearch(target, mountainArr, peakIndex, n-1, false);
        if(leftHalfResult==-1 && rightHalfResult==-1){
            return -1;
        }
        if(leftHalfResult !=-1 && rightHalfResult !=-1){
            return Math.min(leftHalfResult, rightHalfResult);
        }
        if(leftHalfResult==-1){
            return rightHalfResult;
        }
        if(rightHalfResult==-1){
            return leftHalfResult;
        }
        return -1;
    }
    
    private int findPeakIndex(MountainArray mountainArr){
        int left =0;
        int right = mountainArr.length()-1;
        int res = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return res;
    }
    
    private int binarySearch(int target, MountainArray mountainArr, int left, int right, boolean ascendingOrder){
        if(ascendingOrder){
            while(left<=right){
                int mid = left+(right-left)/2;
                if(mountainArr.get(mid)==target){
                    return mid;
                }else if(mountainArr.get(mid)<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }else{
            while(left<=right){
                int mid = left+(right-left)/2;
                if(mountainArr.get(mid)==target){
                    return mid;
                }else if(mountainArr.get(mid)<target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}