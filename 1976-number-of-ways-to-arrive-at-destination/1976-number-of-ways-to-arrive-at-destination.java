class Solution {
    class Pair{
        int dist,node;
        public Pair(int dist,int node){
            this.dist=dist;
            this.node=node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r:roads){
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }
        int mod=(int)1e9+7;
        long[] dist=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.dist-b.dist));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.node;
            int d=p.dist;
            if(d>dist[u])  continue;
            for(int[] edge:adj.get(u)){
                int v=edge[0];
                int w=edge[1];
            
            if(dist[u]+w<dist[v]){
                dist[v]=dist[u]+w;
                ways[v]=ways[u];
                pq.add(new Pair((int)dist[v],v));
            }
            else if(dist[u]+w==dist[v]){
                ways[v]=(ways[v]+ways[u])%mod;
            }
        }
        }
        return (int)ways[n-1]%mod;
    }
}