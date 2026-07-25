class Solution {
    //BOTTOM UP
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        
        return lcs(text1,text2,n,m);
    }
    private int lcs(String text1, String text2,int n,int m){
         
        if(text1.equals(text2)) return n;
        // if(n==0 || m==0) return 0;//array is initialized by 0 so no need 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}