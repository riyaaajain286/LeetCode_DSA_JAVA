class Solution {
    public int minInsertions(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        String rev=sb.toString();
        int n=s.length();
        int lcs=lcs(s,rev);
        return n-lcs;
    }
    private int lcs(String s,String rev){
        int n=s.length();
        int m=rev.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
          for(int j=0;j<=m;j++){
            if(i==0||j==0){
            dp[i][j]=0;
            }
          }
        }
        for(int i=1;i<=n;i++){
          for( int j=1;j<=m;j++){
            if(s.charAt(i-1)==rev.charAt(j-1)){
            dp[i][j]=1+dp[i-1][j-1];
            }
            else {
            dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
         }
        }
        return dp[n][m];
    }
}