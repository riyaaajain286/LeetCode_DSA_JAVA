class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return solve(word1,word2,n-1,m-1);
    }
    private int solve(String word1, String word2,int i,int j){
        int n=word1.length();
        int m=word2.length();
        if(i<0) return j+1;
        if(j<0) return i+1;
         if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j]= 0+solve(word1,word2,i-1,j-1);
        }else{
          int insert= 1+solve(word1,word2,i,j-1);
          int delete= 1+solve(word1,word2,i-1,j);
          int replace= 1+solve(word1,word2,i-1,j-1);
            dp[i][j]=Math.min(insert,(Math.min(delete,replace)));
        }
          return dp[i][j];
        
    }
}