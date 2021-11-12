class Solution {
    public int reverse(int x) {
        int res =0;
        boolean isNeg = false; 
        if(x<0){
            x = Math.abs(x);
            isNeg = true;
        }
        while(x>0){
            int digit = x%10;
            int newRes = res*10+digit;
            if((newRes-digit)/10 != res){
                return 0;
            }
            res = newRes;
            x/=10;
        }
        return isNeg ? -1*res: res;
    }
}