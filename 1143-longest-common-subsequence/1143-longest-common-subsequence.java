class Solution {
    //MEMOIZATION
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp) 
          Arrays.fill(r,-1);
        return lcs(text1,text2,n,m);
    }
    private int lcs(String text1, String text2,int n,int m){
         
        if(text1.equals(text2)) return n;
        if(n==0 || m==0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            dp[n][m]= 1+lcs(text1,text2,n-1,m-1);
        }
        else{
            dp[n][m]= Math.max(lcs(text1,text2,n-1,m),lcs(text1,text2,n,m-1));
        }
        return dp[n][m];
    }
}