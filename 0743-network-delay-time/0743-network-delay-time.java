class Solution {
    class Pair{
        int node,dis;
        public Pair(int n,int d){
            this.node=n;
            this.dis=d;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t:times){
            adj.get(t[0]).add(new Pair(t[1],t[2]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dis-b.dis);
        dist[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int pn=p.node;
            int pd=p.dis;
            if(pd>dist[pn]) continue;
            for(Pair it:adj.get(pn)){
                int an=it.node;
                int ad=it.dis;
                
                if(pd+ad<dist[an]){
                    dist[an]=pd+ad;
                    pq.add(new Pair(an,dist[an]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
          if(dist[i]==(int)1e9)
            return -1;
          ans=Math.max(ans,dist[i]);
          
        }
          
        return ans;
    }
}