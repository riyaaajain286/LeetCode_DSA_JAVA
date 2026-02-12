class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0;i<prices.length;i++){
            //update minimum price
            if(prices[i]<min){
                min=prices[i];
            }
            //calc profit if sold today
            int profit=prices[i]-min;
            //update maxprofit
            maxprofit=Math.max(profit,maxprofit);
        }
        return maxprofit;
    }
}