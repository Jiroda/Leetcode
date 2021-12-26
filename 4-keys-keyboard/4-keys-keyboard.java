//T:O(n)
//S:O(n)
class Solution {
    Map<Integer, Integer> memo = new HashMap<>(); 
    public int maxA(int N) {
        if(memo.containsKey(N)) return memo.get(N);
        int max = N;
        //We need to start from 3 since we need atleast 3 presses ctrlA, CtrlC, CtrlV for copy pasting
        for(int i=3;i<=N;i++){ 
            max = Math.max(max, maxA(N-i) * (i-1)); // maximum of selecting (N-i)th steps * (total numbers of copy possible) 
        }
        memo.put(N,max);
        return max;
    }
}