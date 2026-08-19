class Solution {
    //dfs
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[]  color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){ 
            if(color[i]==-1){
                if(!dfs(i,graph,color,0))
                return false;
            }
        }
        return true;
  }
  private static boolean dfs(int node,int[][] graph,int[] color,int nodeColor){
    color[node]=nodeColor;
    for(int it:graph[node]){
      if(color[it]==-1 && color[it]!=nodeColor){
        if(!dfs(it,graph,color,1-nodeColor))
           return false;
      }
      else if(color[it]==nodeColor){
        return false;
      }
    }
    return true;
  }
}