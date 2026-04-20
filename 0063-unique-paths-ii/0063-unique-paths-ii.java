class Solution {
   //memoization
   int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        dp=new int[n][m];
        for(int[] r:dp) Arrays.fill(r,-1);
        return helper(obstacleGrid,n-1,m-1);
    }
    public int helper(int[][] obstacleGrid,int i,int j){
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0 && obstacleGrid[i][j]!=1 ) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up= helper(obstacleGrid,i-1,j);
        int left=helper(obstacleGrid,i,j-1);
        return dp[i][j]=up+left;
    }
}