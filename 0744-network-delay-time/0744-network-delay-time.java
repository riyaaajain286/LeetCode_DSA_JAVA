class Solution {
     static class Pair{
     int node, dist;
     public Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
     }
  }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        //times:[u,v,w]
        for(int[] edge:times){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.node;
            int w=p.dist;
            if(w>dist[u])  continue;
            //update adjnode
            for(Pair it:adj.get(u)){
                int v=it.node;
                int d=it.dist;
                if(w+d<dist[v]){
                    dist[v]=w+d;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)  return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}