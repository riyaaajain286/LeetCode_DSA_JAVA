class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int p=0;
        for(int i=0;i<prices.length;i++){
            int sell=prices[i]-mini;
            p=Math.max(sell,p);
            mini=Math.min(mini,prices[i]);
        }
        return p;
    }
}