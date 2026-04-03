class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int c=0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                // store nodes in this component
              List<Integer> comp=new ArrayList<>();
              dfs(adj,i,vis,comp);
              int nodes=comp.size();
              int edgeCount=0;
              for(int node:comp){
                 edgeCount+=adj.get(node).size();
              }
              edgeCount/=2;
              if(edgeCount==(nodes*(nodes-1))/2)
                c++;
            }
        }
        return c;
    }
    public void dfs( ArrayList<ArrayList<Integer>> adj,int node,int[] vis,List<Integer> comp){
      vis[node]=1;
      comp.add(node);
      for(int v:adj.get(node)){
        if(vis[v]==0){
            dfs(adj,v,vis,comp);
        }
      }
    }
}