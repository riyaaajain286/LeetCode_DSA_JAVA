class Solution {
    class Pair{
        int node;
        long dist;
        public Pair(int n,long d){
            this.node=n;
            this.dist=d;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod=(int)1e9+7;
      ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
      int V=n;
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] e:roads){
           adj.get(e[0]).add(new Pair(e[1],e[2]));
           adj.get(e[1]).add(new Pair(e[0],e[2]));

       }
       long[] dist=new long[V];
       //dp array
       long[] ways=new long[V];
       Arrays.fill(dist,Long.MAX_VALUE);
       dist[0]=0;
       ways[0]=1;//to reasch start node there is only 1 way
       PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));//min heap
       pq.add(new Pair(0,0));
       while(!pq.isEmpty()){
           Pair p=pq.poll();
           int u=p.node;
           long d=p.dist;
           // Skip outdated entries
               if(d>dist[u]) continue;
           for(Pair adjnode:adj.get(u)){
               int v=adjnode.node;
               long w=adjnode.dist;
               
               if(d+w<dist[v]){
                   dist[v]=d+w;
                   ways[v]=ways[u];
                   pq.add(new Pair(v,dist[v]));
               }
               else if(d+w==dist[v]){
                ways[v]=(ways[v]+ways[u])%mod;
               }
           }
       }
       return (int)ways[n-1]%mod;
    }
}