class Solution {
    int[] wSum;
    public Solution(int[] w) {
        wSum = new int[w.length];
        int sum =0;
        for(int i=0; i<w.length; i++){
            sum+= w[i];
            wSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int randomNumber = (int)(wSum[wSum.length-1]*Math.random());
        for(int i=0; i<wSum.length; i++){
            if(randomNumber<wSum[i]){
                return i;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */