class Solution {
    static int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp)
           Arrays.fill(r,-1);
        return helper(s,t,n-1,m-1);
    }
    private static int helper(String s, String t, int i, int j){
      if(j<0) return 1;
      if(i<0) return 0;
      if(dp[i][j]!=-1) return dp[i][j];
      int take=0,not_take=0;
      if(s.charAt(i)==t.charAt(j)){
        take=helper(s,t,i-1,j-1)+helper(s,t,i-1,j);
      }
      else {
        not_take=helper(s,t,i-1,j);
      }
      return dp[i][j]=take+not_take;
    }
}