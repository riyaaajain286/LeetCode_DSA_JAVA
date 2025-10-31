class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
       
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
              adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
             boolean visited[]=new boolean[n+1];
            //if u and v alrdy connected adding edge can create a cycle
            if(dfs(visited,adj,u,v)){
                return edge;
            }
           // otherwise add edge to adj list
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    private boolean dfs(boolean visited[],ArrayList<ArrayList<Integer>> adj,int source,int target){
        visited[source]=true;
        if(source==target) return true;
        for(int neighbour:adj.get(source)){
            if(visited[neighbour]==false){
                if(dfs(visited,adj,neighbour,target))  return true;
            }
        }
    
    return false;
    }
}