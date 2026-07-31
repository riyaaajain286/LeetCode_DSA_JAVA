class Solution {
    static int[][] dp;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp){
          Arrays.fill(r,-1);
        }
       return solve(word1,word2,n-1,m-1);
    }
    private static int solve(String s, String p,int i,int j){
      if(i<0) return j+1;
      if(j<0) return i+1;
      if(dp[i][j]!=-1) return dp[i][j];
      if(s.charAt(i)==p.charAt(j)){
        dp[i][j]=0+solve(s,p,i-1,j-1);
      }
      else{
        //insert
        int insert=1+solve(s,p,i,j-1);
        int delete=1+solve(s,p,i-1,j);
        int replace=1+solve(s,p,i-1,j-1);
        dp[i][j]=Math.min(insert,Math.min(delete,replace));
      }
      return dp[i][j];
    }
}