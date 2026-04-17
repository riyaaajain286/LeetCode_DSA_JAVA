class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) return -1;
        int[] drow={-1,-1,0,1,1,1,0,-1};
        int[] dcol={0,1,1,1,0,-1,-1,-1};
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {0,0,1});
         vis[0][0]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            if(r==n-1 && c==m-1) return d;
            for(int k=0;k<8;k++){
                int nrow=r+drow[k];
                int ncol=c+dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && !vis[nrow][ncol]){
                    q.add(new int[] {nrow,ncol,d+1});
                    vis[nrow][ncol]=true;
                }
            }
        }
        return -1;
    }
}