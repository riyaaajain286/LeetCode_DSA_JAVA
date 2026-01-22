class Solution {
    //memoization
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n =coins.length;
        //build dp table
         dp=new int[n+1][amount+1];
        //initialization
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return solve(amount,coins,n);
    }
    public int solve(int amount, int[] coins,int n){
        //base case
        if(amount==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        // memo check
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        //recursion
        if (coins[n - 1] <= amount) {
            dp[n][amount] =
                solve( amount - coins[n - 1],coins, n) +
                solve( amount,coins, n - 1);
        } else {
            dp[n][amount] = solve( amount,coins, n - 1);
        }
        return dp[n][amount];
    }
}