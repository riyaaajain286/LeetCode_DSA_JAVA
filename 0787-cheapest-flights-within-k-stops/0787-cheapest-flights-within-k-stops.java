class Solution {
    class Pair{
        int node,weight,stop;
        public Pair(int node,int weight,int stop){
            this.node=node;
            this.weight=weight;
            this.stop=stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
     ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
     for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
     }
     for(int[] e:flights){
        adj.get(e[0]).add(new Pair(e[1],e[2],0));
     }
     int[] dist=new int[n];
     Arrays.fill(dist,(int)1e9);
     dist[src]=0;
     Queue<Pair> pq=new LinkedList<>();
     pq.add(new Pair(src,0,0));
     while(!pq.isEmpty()){
        Pair p=pq.poll();
        int u=p.node;
        int ud=p.weight;
        int s=p.stop;
        if(s>k) continue;
        for(Pair v:adj.get(u) ){
            int vn=v.node;
            int vd=v.weight;
            if(ud+vd<dist[vn] &&s<=k ){
                dist[vn]=ud+vd;
                pq.add(new Pair(vn,dist[vn],s+1));
            }
        }
     }
     return dist[dst]==(int)1e9?-1:dist[dst];
    }
}