class Solution {
    //memoization
    int[][] dp;
    public int change(int amount, int[] coins) {
       int n=coins.length; 
       dp=new int[n+1][amount+1];
       for(int[] r:dp){
           Arrays.fill(r,-1);
       }
       return unboundedKnapsack(coins,amount,n);
    }
    private int unboundedKnapsack(int[] coins,int amt,int n){
        if(n==0) return 0;
        if(amt==0) return 1;
        if(dp[n][amt]!=-1) return dp[n][amt];
        if(coins[n-1]<=amt){
            dp[n][amt]= (unboundedKnapsack(coins,amt-coins[n-1],n)+unboundedKnapsack(coins,amt,n-1));
        }
        else{
           dp[n][amt] =unboundedKnapsack(coins,amt,n-1);
        }
        return dp[n][amt];
    }
}