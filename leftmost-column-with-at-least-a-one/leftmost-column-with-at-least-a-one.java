/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int ans = cols;
        for(int row=0; row<rows; row++){
            int index = binarySearch(row, 0, cols-1, binaryMatrix);
            if(index!=-1){
                ans = Math.min(ans, index);
            }
        }
        return ans ==cols ? -1: ans;
    }
    
    private int binarySearch(int row, int start, int end, BinaryMatrix binaryMatrix){
        int ans= -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(binaryMatrix.get(row, mid)== 0){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }

}