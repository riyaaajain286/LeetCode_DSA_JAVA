class Solution {
    int count=0;
    class Pair{
        int node,check;
        public Pair(int n,int c){
            this.node=n;
            this.check=c;
        }
    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] c:connections){
            adj.get(c[0]).add(new Pair(c[1],1));
             adj.get(c[1]).add(new Pair(c[0],0));
        }
        boolean[] vis=new boolean[n];
        int ans=dfs(adj,vis,0);
        return ans;
    }
    private int dfs(ArrayList<ArrayList<Pair>> adj,boolean[] vis,int u){
        vis[u]=true;
        
        for(Pair v:adj.get(u)){
            int node=v.node;
            int check=v.check;
            if(!vis[node]){
                if(check==1){
                  count++;
                }
               dfs(adj,vis,node);
            }
            
        }
        return count;
    }
}