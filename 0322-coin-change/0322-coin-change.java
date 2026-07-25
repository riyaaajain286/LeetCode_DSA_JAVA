class Solution {
    // BOTTOM UP
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n+1][amount+1];
        
        int ans= unbounded(coins,amount,n);
        return ans;
        // if(ans==Integer.MAX_VALUE-1) return -1;
        // else return ans;
    }
    private int unbounded(int[] coins,int amount,int n){
      for(int  j=1;j<=amount;j++) 
        dp[0][j]=Integer.MAX_VALUE-1;
      for(int i=0;i<=n;i++) 
         dp[i][0]=0;
        
     for(int i=1;i<=n;i++){
        for(int j=1;j<=amount;j++){
            if(coins[i-1]<=j){
                dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
     }
       
       return dp[n][amount]==Integer.MAX_VALUE-1?-1:dp[n][amount];
    }  

    
}