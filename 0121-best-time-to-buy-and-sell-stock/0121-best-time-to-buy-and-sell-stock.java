class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int n=prices.length;
        int profit=0;
        int maxProfit=0;
        for(int i=0;i<n;i++){
            buy=Math.min(buy,prices[i]);
            profit=prices[i]-buy;
            maxProfit=Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}