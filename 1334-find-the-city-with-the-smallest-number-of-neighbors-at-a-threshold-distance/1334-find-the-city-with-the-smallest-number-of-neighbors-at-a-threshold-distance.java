class Solution {
    //floyd warshall
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] e:edges){
         int u=e[0];
         int v=e[1];
         int wt=e[2];
         dist[u][v]=wt;
         dist[v][u]=wt;
        }
        for(int i=0;i<n;i++)  dist[i][i]=0;
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                  if(dist[i][via]==Integer.MAX_VALUE||dist[via][j]==Integer.MAX_VALUE){
                    continue;
                  }
                //  if(dist[i][via]!=Integer.MAX_VALUE||dist[via][j]!=Integer.MAX_VALUE){
                  dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                //  }
                }
            }
        }
        int cntcity=n;
        int cityno=-1;
        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adjcity=0;adjcity<n;adjcity++){
               if( dist[city][adjcity]<=distanceThreshold ) cnt++;
            }
            if(cnt<=cntcity){
                cntcity=cnt;
                cityno=city;
            }
        }
        return cityno;

    }
}