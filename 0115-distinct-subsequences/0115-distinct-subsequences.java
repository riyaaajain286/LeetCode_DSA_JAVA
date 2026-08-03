class Solution {
    static int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];

        for(int i=0;i<n;i++){ 
          dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
          for(int j=1;j<=m;j++){
            if(s.charAt(i-1)==t.charAt(j-1)){
              // op1=solve(s,t,i-1,j-1) + solve(s,t,i-1,j);
              dp[i][j]=dp[i-1][j-1] + dp[i-1][j];
            }
            else{
              // op2=solve(s,t,i-1,j);
              dp[i][j]=dp[i-1][j];
            }
          }
        }
            // return dp[i][j]=op1+op2;
            return dp[n][m];
                
        
    }
}