
//T:O(logn)
//S:O(1)
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend == Integer.MIN_VALUE && divisor ==-1)){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if((dividend<0 && divisor>0) || (dividend >0 && divisor<0)){
            sign = -1;
        }
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int quotient = 0;
        while(absDividend>=absDivisor){
            int numShifts = 0;
            while(absDividend >= absDivisor<<numShifts){
                numShifts++;
            }
            
            quotient+= 1<<(numShifts-1);
            absDividend-=absDivisor<<(numShifts-1);
        }
        return sign==-1? -quotient : quotient;
    }
}