//T:O(sqrt(n))
//S:O(1)
class Solution {
    public int kthFactor(int n, int k) {
        //if i is a factor of n then n/i is also a factor of n
        //We traverse from 1 till sqrt of n and find all factors
        for(int i=1; i*i<n; i++){
            if(n%i==0){
                if(--k==0){
                    return i;
                }
            }
        }
        //we traverse in reverse order from sqrt n till 1 and find all factors 
        for(int i=(int)Math.sqrt(n); i>=1; i--){
            if(n%i==0){
                if(--k==0){
                    return n/i;
                }
            }
        }
        
        return -1;
    }
}