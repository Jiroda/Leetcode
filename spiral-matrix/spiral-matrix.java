class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        
        int capacity = m*n;
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;
        
        while(res.size()< capacity){
            for(int i=top, j=left; res.size()<capacity && j<=right; j++){
                res.add(matrix[i][j]);
            }
            top++;
            for(int i=top, j=right; res.size()<capacity && i<=bottom; i++){
                res.add(matrix[i][j]);
            }
            right--;
            for(int i=bottom, j=right; res.size()<capacity && j>=left; j--){
                res.add(matrix[i][j]);
            }
            bottom--;
            for(int i=bottom, j=left; res.size()<capacity && i>=top; i--){
                res.add(matrix[i][j]);
            }
            left++;
        }
        
        return res;
    }
}