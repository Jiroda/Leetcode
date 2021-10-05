class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        String binary = Integer.toBinaryString(n);
        int secondOneIndex = binary.indexOf('1', 1);
        if(secondOneIndex==-1){
            return (1<<binary.length()) - 1;
        }
        
        return ((1<<binary.length()) - 1) - minimumOneBitOperations(Integer.valueOf(binary.substring(1), 2));
    }
}