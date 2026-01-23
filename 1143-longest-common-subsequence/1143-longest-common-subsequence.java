class Solution {
     int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        int ans=lcs(text1,text2,n,m);
        return ans;
    }
    public int lcs(String text1, String text2,int n,int m){
      //memo check
      if(dp[n][m]!=-1){
        return dp[n][m];
      }
      //base condition
      if(n==0||m==0) return 0;
       //choice diagram
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            dp[n][m]= 1+lcs(text1,text2,n-1,m-1);
        }
        else{
            dp[n][m]= Math.max(lcs(text1,text2,n,m-1),lcs(text1,text2,n-1,m));
        }
        return dp[n][m];
    }
}