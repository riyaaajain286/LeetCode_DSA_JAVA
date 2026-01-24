class Solution {
     int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[1001][1001];
        int ans=lcs(text1,text2,n,m);
        return ans;
    }
    public int lcs(String text1, String text2,int n,int m){
      //initialization
    //    for(int i=0;i<=n;i++){
    //     dp[i][0]=0;
    //    }
    //    for(int j=0;j<=m;j++){
    //     dp[0][j]=0;
    //    }
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(i==0||j==0){
                dp[i][j]=0;
            }
        }
    }

       //iteration
       for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
         if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]= 1+dp[i-1][j-1];
        }
        else{
            dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
        }
          }
       }
        return dp[n][m];
    }
}