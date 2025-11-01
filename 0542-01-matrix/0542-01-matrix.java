class Solution {
  class Pair{
    int row,col,steps;
    public Pair(int row,int col,int steps){
      this.row=row;
      this.col=col;
      this.steps=steps;
    }
   }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] distance=new int[n][m];
        int[][] visited=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        //push all cells with 1 into queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                q.offer(new Pair(i,j,0));
                visited[i][j]=1;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int steps=q.peek().steps;
            q.poll();
            distance[row][col]=steps;
            for(int k=0;k<4;k++){
                int nrow=row+delrow[k];
                int ncol=col+delcol[k];
                if(nrow>=0&&ncol>=0&&nrow<n&&ncol<m&&visited[nrow][ncol]==0){
                visited[nrow][ncol]=1;
                q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return distance;
        }
}