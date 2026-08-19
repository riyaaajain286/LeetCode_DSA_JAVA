class Solution {
    //bfs
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){ 
        if(color[i]==-1){
            if(!bfs(graph,i,color))//BFS says true  → continue checking other components
            return false;
        }
        }
        return true;//All components are valid → return true
   }
   private static boolean bfs(int[][] graph,int start,int[] color){
    Queue<Integer> q=new LinkedList<>();

     q.add(start);
     color[start]=0;

     while(!q.isEmpty()){
       int node=q.poll();
       for(int it:graph[node]){
        if(color[it]==-1){
          color[it]=1-color[node];
          q.add(it);
        }
        else if(color[it]==color[node])
           return false;
       }
     }
     return true;
  }
}