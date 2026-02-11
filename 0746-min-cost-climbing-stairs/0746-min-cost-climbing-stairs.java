class Solution {
    //bottom up
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+2];
        //initialization
        dp[n]=0;
        dp[n+1]=0;
        //iteration
        for(int i=n-1;i>=0;i--){
            dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
           
        }
        //answer can be any between 0 or 1 coz start may be from 0 or 1 as given in ques
         return Math.min(dp[0],dp[1]);
    }
}