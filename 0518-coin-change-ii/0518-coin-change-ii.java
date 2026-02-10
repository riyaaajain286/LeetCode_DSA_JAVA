class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        //unbounded knapsack pattern
        int n=coins.length;
        dp=new int[n+1][amount+1];
         return helper(amount,coins);
    }
    public int helper(int amount, int[] coins){
      
        int n=coins.length;
       //initialization
       for(int i=1;i<=n;i++){
        dp[i][0]=1;
       }
       for(int j=0;j<=amount;j++){
        dp[0][j]=0;
       }
//iteration
         for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}