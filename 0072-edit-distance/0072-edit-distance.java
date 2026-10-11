class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp)
          Arrays.fill(r,-1);
        return(helper(word1, word2, n-1, m-1));
    }
    private static int helper(String word1, String word2, int i, int j){
        int ans=0;
        if(i<0){
           return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int insert=0,delete=0,replace=0;
        if(word1.charAt(i)==word2.charAt(j)){
            return 0+helper(word1,word2, i-1, j-1);
        }
             insert=1 + helper(word1, word2, i,j-1);
             delete=1 + helper(word1, word2, i-1, j);
             replace=1 + helper(word1,word2, i-1, j-1);
            ans=Math.min(insert,Math.min(delete,replace));
        
        return dp[i][j]= ans;
    }
}