class Solution {
        static class Pair{
           int row,col,dist;
           public Pair(int row,int col,int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
           } 
        }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1){
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0,1));
        grid[0][0]=1;
        // int[][] dirs={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.row;
            int c=p.col;
            int d=p.dist;
            if(r==n-1&&c==n-1){
                return d;
            }
            // for(int[] dir:dirs){
            //     int nr=r+dir[0];
            //     int nc=c+dir[1];
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nr=r+i;
                    int nc=c+j;
                     if(nr>=0&&nc>=0&&nr<=n-1&&nc<n&&grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.add(new Pair(nr,nc,d+1));
                }
                }
            }
               
            }

        
        return -1;
    }
}