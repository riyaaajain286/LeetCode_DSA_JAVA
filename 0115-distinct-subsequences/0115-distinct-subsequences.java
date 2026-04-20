class Solution {
    //tabulation
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];
       for(int i=0;i<n;i++){
        dp[i][0]=1;//if pattern string exhauts meaning matched therefore return 1
       }
     
        // if(i<0) return 0;//if original string exhauts meaning not matched with pattern and it is finished so return 0
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int op1=0;
                int op2=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    op1=dp[i-1][j-1]+dp[i-1][j];
                    }
                else{
                   op2=dp[i-1][j];
                }
                dp[i][j]=op1+op2;
            }
        }
       
    
     return dp[n][m];
    }
}