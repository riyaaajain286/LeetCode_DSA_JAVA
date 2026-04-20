class Solution {
   //Tabulation
   int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        dp=new int[n][m];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            //if obstacle
            if(i>=0 && j>=0 && obstacleGrid[i][j]==1) dp[i][j]=0;
            //starting cell
            else if(i==0 && j==0 && obstacleGrid[i][j]!=1 ) dp[i][j]= 1;
            else{
                int up=0,left=0;
                if(i>0)  up= dp[i-1][j];
                if(j>0)  left=dp[i][j-1];
                dp[i][j]=up+left;
            }
         }
       }
        return dp[n-1][m-1];
    }
}