class Solution {
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0){
                    if(dfs(grid,i,j,-1,-1,vis)==true)  return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] grid,int row,int col,int pr,int pc,int[][] vis){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
        
        if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]==grid[row][col]&&vis[nr][nc]==0){
            if(dfs(grid,nr,nc,row,col,vis)==true) return true;
        } 
        else if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]==grid[row][col]&&vis[nr][nc]==1){
            if(nr!=pr&&nc!=pc) return true;
        }
        }
        return false;
    }
}