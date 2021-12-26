//T:O(n)
//S:O(1)
class Solution {
    //two pointers greedy approach
    //if the characters are the same remove the character with the lowest cost
    public int minCost(String colors, int[] neededTime) {
        int prev =0;
        int minCost = 0;
        for(int curr=1; curr<colors.length(); curr++){
            if(colors.charAt(curr)==colors.charAt(prev)){
                int costOfPrev = neededTime[prev];
                int costOfCurr = neededTime[curr];
                if(costOfPrev < costOfCurr){
                    minCost+= costOfPrev;
                    prev=curr;;
                }else{
                    minCost+= costOfCurr;
                }
            }else{
                prev=curr;
            }
        }
        return minCost;
    }
}