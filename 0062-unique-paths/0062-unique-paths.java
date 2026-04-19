class Solution {
    //memoization
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int[] r:dp)
           Arrays.fill(r,-1);
        return helper(m,n,m-1,n-1);
    }
    public int helper(int m, int n,int i,int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=helper(m,n,i-1,j);
        int left=helper(m,n,i,j-1);
        return dp[i][j]=up+left;
    }
}