class Solution {
    public int minDistance(String word1, String word2) {
       int n=word1.length();
       int m=word2.length();
       int lcs=lcsB(word1,word2,n,m);
       int del=n-lcs;
       int ins=m-lcs;
       int ans=del+ins;
       return ans;
    }
  
    public static int lcsB(String text1, String text2,int n,int m){
      //initialization
    //    for(int i=0;i<=n;i++){
    //     dp[i][0]=0;
    //    }
    //    for(int j=0;j<=m;j++){
    //     dp[0][j]=0;
    //    }
    int dp[][]=new int[n+1][m+1];
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