class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minimumBuyingPrice = -1;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<minimumBuyingPrice || minimumBuyingPrice==-1){
                minimumBuyingPrice = prices[i];
            }else{
                int currentProfit = prices[i]-minimumBuyingPrice;
                if(currentProfit> maxProfit){
                    maxProfit = currentProfit;
                }
            }
        }
        
        
        return maxProfit;
    }
}