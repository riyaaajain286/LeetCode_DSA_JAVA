class Solution {
        class Pair{
            int row,col;
            public Pair(int row,int col){
                this.row=row;
                this.col=col;
            }
        }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        visited[i][j]=1;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        while(!q.isEmpty()){
        //   visited[i][j]=1;
          int row=q.peek().row;
          int col=q.peek().col;
          q.poll();
          for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&grid[nrow][ncol]==1&&visited[nrow][ncol]==0){
                visited[nrow][ncol]=1;
                q.add(new Pair(nrow,ncol));
            }
          }

        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                  count++;
                }
            }
        }
        return count;
    }
}