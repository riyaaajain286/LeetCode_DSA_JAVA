class Solution {
    //dfs
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int j=0;j<n;j++){
            if(color[j]==-1){
                if(dfs(graph,j,color,0)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int node,int[] color,int colour){
       color[node]=colour;
        for(int adj:graph[node]){
            if(color[adj]==-1){
                if(!dfs(graph,adj,color,1-colour)) return false;
            }
            else if(color[adj]==colour) return false;
        }
        return true;
    }
}