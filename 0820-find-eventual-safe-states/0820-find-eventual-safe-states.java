class Solution {
    //using toposort by reversing links of graph via bfs
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        ArrayList<ArrayList<Integer>> revadj=new ArrayList<>();
        int[] indegree=new int[v];
        for(int i=0;i<v;i++){
          revadj.add(new ArrayList<>());
        }
        for(int u=0;u<v;u++){
            for(int adjnode:graph[u]){
               revadj.get(adjnode).add(u);
               indegree[u]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safenode=new ArrayList<>();
        
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.remove();
            safenode.add(node);
            for(int adjnode:revadj.get(node)){
            indegree[adjnode]--;
            if(indegree[adjnode]==0)  q.add(adjnode);
            }
        }
    Collections.sort(safenode);
    return safenode;
    }
}