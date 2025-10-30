class Solution {
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[n][m];
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
                else{
                     visited[i][j]=0;
                }
            }
        }
        if(fresh==0) return 0;
         
         int[] delrow={-1,0,1,0};
         int[] delcol={0,1,0,-1};
         int timemax=0;
         //BFS
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int t=p.time;
            timemax=Math.max(timemax,t);
             for(int k=0;k<4;k++){
                int nr=row+delrow[k];
                int nc=col+delcol[k];
            
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1&&visited[nr][nc]==0){
                    visited[nr][nc]=2;
                    // grid[nr][nc]=2;
                    q.add(new Pair(nr,nc,t+1));
                    fresh--;
                }
             }
          }
          return fresh==0?timemax:-1;
    }

}