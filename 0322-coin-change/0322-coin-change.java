class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n+1][amount+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        int ans= unbounded(coins,amount,n);
        
        if(ans==Integer.MAX_VALUE-1) return -1;
        else return ans;
    }
    private int unbounded(int[] coins,int amount,int n){
       if(amount==0 ){
        return 0;
       }
       if(n==0) return Integer.MAX_VALUE-1;

       if(dp[n][amount]!=-1) return dp[n][amount];
       if(coins[n-1]<=amount){
        dp[n][amount]= Math.min(1+unbounded(coins,amount-coins[n-1],n),
        unbounded(coins,amount,n-1));
       }
       else{
        dp[n][amount]= unbounded(coins,amount,n-1);
       }
       return dp[n][amount];
    }  

    
}