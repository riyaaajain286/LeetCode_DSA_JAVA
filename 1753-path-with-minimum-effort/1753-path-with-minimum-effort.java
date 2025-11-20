class Solution {
    class Pair{
        int row,col, diff;
        public Pair(int row,int col, int diff){
            this.row=row;
            this.col=col;
            this.diff=diff;
        }
     }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
        pq.add(new Pair(0,0,0));
        int[][] dist=new int[m][n];
        for(int[] row:dist){
            Arrays.fill(row,(int)(1e9));
        }
       
        dist[0][0]=0;
        int[] dr={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!pq.isEmpty()){
          Pair p=pq.poll();
            int r=p.row;
            int c=p.col;
            int diff=p.diff;
            if(r==m-1&&c==n-1)  return dist[r][c];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0&&nc>=0&&nr<m&&nc<n){
                int effort=Math.max((Math.abs(heights[r][c]-heights[nr][nc])),diff);
                if(effort<dist[nr][nc]){
                    dist[nr][nc]=effort;
                    pq.add(new Pair(nr,nc,effort));
                }
                }
            }
        }
        return -1;
    }
}