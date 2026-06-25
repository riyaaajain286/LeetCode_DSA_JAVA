class Solution {
    // if u sell stock on ith day then buy on i-1 day only
    public int maxProfit(int[] prices) {
        //assuming the minimum sp
        int minSp=prices[0];
        int maxProfit=0,profit=0;
        for(int i=1;i<prices.length;i++){
            profit=prices[i]-minSp;
            maxProfit=Math.max(maxProfit,profit);
            //updating the minimum sp
            minSp=Math.min(prices[i],minSp);

        }
        return maxProfit;
    }
}