//T:O(M * N )
//S:O(1) in place

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix==null || matrix.length ==0 || matrix[0].length==0){
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int capacity = m*n;
        int top = 0;
        int right = matrix[0].length-1;
        int left = 0;
        int bottom = matrix.length-1;
        
        while(result.size() < capacity){
            for(int i=top, j=left; j<=right && result.size()<capacity; j++){
                result.add(matrix[i][j]);
            }
            top++;
            for(int i=top, j=right; i<=bottom && result.size()<capacity; i++){
                result.add(matrix[i][j]);
            }
            right--;
            for(int i=bottom, j=right; j>=left && result.size()<capacity; j--){
                result.add(matrix[i][j]);
            }
            bottom--;
            for(int i=bottom, j=left; i>=top && result.size()<capacity; i--){
                result.add(matrix[i][j]);
            }
            left++;
        }
        return result;
    }
}