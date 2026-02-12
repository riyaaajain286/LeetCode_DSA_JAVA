class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new int[1001][1001];
        for(int row[]:dp)
          Arrays.fill(row,-1);
        return lcs(text1,text2,text1.length(),text2.length());
    }
    public int lcs(String a,String b,int n,int m){
        if(n==0 || m==0) return 0;
         if(dp[n][m]!=-1) return dp[n][m];
        if(a.charAt(n-1)==b.charAt(m-1)){
            dp[n][m]= 1+lcs(a,b,n-1,m-1);
        }
        else{
            dp[n][m]= Math.max(lcs(a,b,n,m-1),lcs(a,b,n-1,m));
        }
        return dp[n][m];
    }
}