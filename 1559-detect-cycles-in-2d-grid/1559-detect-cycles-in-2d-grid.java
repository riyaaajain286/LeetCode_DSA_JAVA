class Solution {
    //dfs
    public boolean containsCycle(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(dfs(grid,vis,i,j,-1,-1)) return true;
                }
            }
        }
        return false;
    }
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public boolean dfs(char[][] grid,boolean[][] vis,int r,int c,int pr,int pc){
        vis[r][c]=true;
         int n=grid.length;
        int m=grid[0].length;
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr>=0 && nc>=0 && nr<n && nc<m) {//check boundary first
            if(!vis[nr][nc] && grid[nr][nc]==grid[r][c]){
               if(dfs(grid,vis,nr,nc,r,c)) return true;
            }
            else if(grid[nr][nc]==grid[r][c] && vis[nr][nc]){
                if(nr!=pr || nc!=pc) return true;
                
            }
            }
        }
      return false;
    }
}