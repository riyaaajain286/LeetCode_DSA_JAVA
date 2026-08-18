class Solution {

     static class Pair{
      int row,col,dist;
      public Pair(int r,int c,int d){
        this.row=r;
        this.col=c;
        this.dist=d;
      }
    }

    public int[][] updateMatrix(int[][] mat) {
      int n=mat.length;
      int m=mat[0].length;
      int[][] dis=new int[n][m];
      boolean [][] vis=new boolean[n][m];
      Queue<Pair> q=new LinkedList<>();
      //push all cells with 0 into the q
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
          if(mat[i][j]==0){
            q.offer(new Pair(i,j,0));
            vis[i][j]=true;
            }
        }
      }
      int[] drow={-1,0,1,0};
      int[] dcol={0,1,0,-1};
      while(!q.isEmpty()){
        int r=q.peek().row;
        int c=q.peek().col;
        int dist=q.peek().dist;
        dis[r][c]=dist;
        q.poll();
        for(int k=0;k<4;k++){
           int nr=r+drow[k];
           int nc=c+dcol[k];
           if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc]){
            vis[nr][nc]=true;
            q.add(new Pair(nr,nc,dist+1));
           }
        }
      }
      return dis;
    }
}