class Solution {
    static class Pair{
    int i,j;
    public Pair(int i,int j){
      this.i=i;
      this.j=j;
    }
  }
   static int[] drow={-1,0,1,0};
   static int[] dcol={0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        // Put ALL rotten oranges into queue
        for(int i=0;i<n;i++){ 
         for(int j=0;j<m;j++){
            if(grid[i][j]==2){
            q.offer(new Pair(i,j));
            }
            else if(grid[i][j]==1){
            fresh++;
            }
         }
        }
        int minutes=0;
        //BFS
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            // Process one complete level
            for(int l=0;l<size;l++){
                int r=q.peek().i;
                int c=q.peek().j;
                q.poll();
                for(int k=0;k<4;k++){
                int nr=r+drow[k];
                int nc=c+dcol[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m &&grid[nr][nc]==1){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]=2;
                    fresh--;
                }
                }
            }
            minutes++;// one level = one minute
        }
        // If fresh oranges are still left, they can never rot
        return fresh==0?minutes:-1;
    }
}