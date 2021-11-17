class Solution {
    private Map<String, Integer> memo = new HashMap<String, Integer>();
    public int uniquePaths(int m, int n) {
        // Base case       
        if(m == 1 || n == 1) {
            return 1;
        }
        
        String cell = new String(m + "," + n);
        if(memo.containsKey(cell)){
            return memo.get(cell);
        }
        
        int numPathsFromTopCell = uniquePaths(m-1, n);
        int numPathsFromLeftCell = uniquePaths(m, n-1);
        
        memo.put(cell, numPathsFromTopCell + numPathsFromLeftCell);
        
        return numPathsFromTopCell + numPathsFromLeftCell;
    }    
}