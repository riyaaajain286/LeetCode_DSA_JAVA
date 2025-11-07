class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        int[] pathvis=new int[n];
        int check[] =new int[n];
        for(int i=0;i<n;i++){ 
        if(vis[i]==0){
            dfs(graph,i,vis,pathvis,check);
        }
        }
        List<Integer> safenode=new ArrayList<>();
        for(int i=0;i<n;i++){ 
        if(check[i]==1){
            safenode.add(i);
        }
        }
        return  safenode;
    }
      public static boolean dfs(int[][] graph,int node,int[] vis,int[] pathvis,int[] check){
    vis[node]=1;
    pathvis[node]=1;
    for(int adjnode:graph[node]){
      if(vis[adjnode]==0){
        if(dfs(graph,adjnode,vis,pathvis,check)){
          check[node]=0;
          return true;
        }
      }
      else if(vis[adjnode]==1){
          if( pathvis[adjnode]==1){
            check[node]=0;
            return true;
          }
      }
      }
      check[node]=1;
      pathvis[node]=0;
      return false;
    }
}