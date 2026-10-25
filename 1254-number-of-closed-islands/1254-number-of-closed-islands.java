class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]==0)
                 if(dfs(grid,i,j))
                   count++;
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid,int r,int c){
       int n=grid.length;
       int m=grid[0].length;
       if(r<0 || r>=n || c<0 || c>=m)//out of bound
         return false;
       if(grid[r][c]==1)//water
         return true;
       grid[r][c]=1;//mark as visited
       boolean left=dfs(grid,r,c-1);
       boolean right=dfs(grid,r,c+1);
       boolean up=dfs(grid,r-1,c);
       boolean down=dfs(grid,r+1,c);

       return left && right && up && down;
    }
}