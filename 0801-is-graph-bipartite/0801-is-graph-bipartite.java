class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
            Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
             if(dfs(graph,color,i,0)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph,int[] color,int currentnode,int newcolor){
        color[currentnode]=newcolor;
        for(int adjnode:graph[currentnode]){
            if(color[adjnode]==-1){ 
                //color with oppo color
            if(dfs(graph,color,adjnode,1-newcolor)==false) return false;
            }
            else if(color[adjnode]==newcolor){
                 return false;
            }
    }
    return true;
}
}
