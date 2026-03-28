class Solution {
    int[] r={-1,0,1,0};
    int[] c={0,1,0,-1};
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        //Put all rotten oranges in queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                   q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int minutes=0;
        //bfs
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int k=0;k<4;k++){
                int nr=x+r[k];
                int nc=y+c[k];
                  if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.add(new int[]{nr,nc});
                    fresh--;
                  }
                }
            }
            minutes++;// one level = one minute
        }
        
        return fresh==0?minutes:-1;
    }
}