class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    int mr,mc,maxr,maxc;
    public int[][] findFarmland(int[][] land) {
       List<int[]> list=new ArrayList<>();
        int n=land.length;
        int m=land[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(land[i][j]==1 && !vis[i][j]){
                    // initialize boundaries
                    mr=i;
                    mc=j;
                    maxr=i;
                    maxc=j;
                    dfs(land,vis,i,j);
                    list.add(new int[]{mr,mc,maxr,maxc});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    
    
    public void dfs(int[][] land,boolean[][] vis,int sr,int sc){
         vis[sr][sc]=true;
         int n=land.length;
        int m=land[0].length;
         // update rectangle boundaries
         mr=Math.min(mr,sr);
         mc=Math.min(mc,sc);
         maxr=Math.max(maxr,sr);
         maxc=Math.max(maxc,sc);
         for(int k=0;k<4;k++){
            int nr=sr+dr[k];
            int nc=sc+dc[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && land[nr][nc]==1){
                dfs(land,vis,nr,nc);
            }
         }

    }
}