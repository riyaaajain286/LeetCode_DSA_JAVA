class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
       
        int maxarea=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1&&visited[r][c]==0){
                   maxarea=Math.max(maxarea, dfs(grid,r,c,visited));
                }
            }
        }
        return maxarea;
    }
    private int dfs(int[][] grid,int r,int c,int[][] visited){
     
        visited[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
       int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
         int area=1;
      for(int k=0;k<4;k++){
        int nr=r+dr[k];
        int nc=c+dc[k];
        if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]==1&&visited[nr][nc]==0){
           
            area+=dfs(grid,nr,nc,visited);
        }
      }
      return area;
    }
}