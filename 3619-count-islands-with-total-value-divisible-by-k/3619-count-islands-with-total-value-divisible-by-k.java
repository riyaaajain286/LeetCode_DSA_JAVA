class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    long sum=dfs(grid,vis,i,j);
                        if(sum%k==0)
                           count++;
                    
                }
            }
        }
        return count;
    }
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    private long dfs(int[][] grid,boolean[][] vis,int r,int c){
        vis[r][c]=true;
        int n=grid.length;
        int m=grid[0].length;
        long sum=grid[r][c];
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]>0 &&!vis[nr][nc]){
                sum+=dfs(grid,vis,nr,nc);
            }
        }
        return sum;
    }
}