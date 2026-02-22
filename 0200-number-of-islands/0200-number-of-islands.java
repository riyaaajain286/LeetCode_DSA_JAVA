class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                   if(!vis[i][j]){
                   
                    dfs(grid,vis,i,j);
                     island++;
                   }
                }
            }
        }
        return island;
    }
    int[] delrow={-1,0,1,0};
    int delcol[]={0,1,0,-1};
    public void dfs(char[][] grid,boolean vis[][],int r,int c){
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=true;
        for(int i=0;i<delrow.length;i++){
             int nrow=r+delrow[i];
             int ncol=c+delcol[i];
             if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&grid[nrow][ncol]=='1' && !vis[nrow][ncol]){
                dfs(grid,vis,nrow,ncol);
             }
        }
    }
}