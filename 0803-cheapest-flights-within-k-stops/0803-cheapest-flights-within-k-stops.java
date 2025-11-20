class Solution {
    //dijskta approch but not on distance basis its on stop basis
    class Pair{
        int stop,node,dist;
        public Pair(int stop,int node,int dist){
            this.stop=stop;
            this.node=node;
            this.dist=dist;
        }
    }
    class Edge{
        int v, cost;
        public Edge(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f:flights){
            adj.get(f[0]).add(new Edge(f[1],f[2]));
        }
        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,src,0));
       
        while(!q.isEmpty()){
          Pair p=q.poll();
          int s=p.stop;
          int node=p.node;
          int dis=p.dist;
          if(s>k)  continue;
          for(Edge e:adj.get(node)){
             int adjnode=e.v;
             int cost=e.cost;
            if(dis+cost<dist[adjnode]){
                dist[adjnode]=dis+cost;
                q.add(new Pair(s+1,adjnode,dist[adjnode]));
            }
          }
        }
        return dist[dst]==(int)1e9?-1:dist[dst];
    }
}