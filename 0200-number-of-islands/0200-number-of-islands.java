class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]=='1' && !vis[i][j]){
                 dfs(grid,i,j,vis);
                 c++;
                 
               }
            }
        }
       return c;  
    }
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};
    private void dfs(char[][] grid,int i,int j,boolean[][] vis){
      vis[i][j]=true;
      int n=grid.length;
      int m=grid[0].length;
      for(int k=0;k<4;k++){
        int nr=i+row[k];
        int nc=j+col[k];
        if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && !vis[nr][nc]){
            dfs(grid,nr,nc,vis);
            
        }
      }
    }
}