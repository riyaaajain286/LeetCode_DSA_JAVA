class Solution {

    static int[] row={-1,0,1,0};
    static int[] col={0,1,0,-1};

    static class Pair{
      int row,col;
      public Pair(int r,int c){
        this.row=r;
        this.col=c;
      }
    } 

    public int numIslands(char[][] grid) {
       int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(grid[i][j]=='1' && !vis[i][j]){
                 bfs(grid,i,j,vis);
                 c++;
                }
            }
        }
       return c;  
    }

    private static void bfs(char[][] grid,int i,int j,boolean[][] vis){
      int n=grid.length;
      int m=grid[0].length;
      vis[i][j]=true;
      Queue<Pair> q=new LinkedList<>();
      q.add(new Pair(i,j));
      while(!q.isEmpty()){
        int r=q.peek().row;
        int c=q.peek().col;
        q.poll();
        for(int k=0;k<4;k++){
          int nr=r+row[k];
          int nc=c+col[k];
          if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && !vis[nr][nc]){
            vis[nr][nc]=true;
            q.add(new Pair(nr,nc));
          }
        }
      }
    }

}