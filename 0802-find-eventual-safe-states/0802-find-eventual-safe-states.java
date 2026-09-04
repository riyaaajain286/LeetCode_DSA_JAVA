class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> revAdj=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(int u=0;u<n;u++){
            for(int v:graph[u]){
                revAdj.get(v).add(u);
                indegree[u]++;
            }
        }
        List<Integer> ans =new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
             q.add(i);
        }
        while(!q.isEmpty()){
           int node=q.poll();
           ans.add(node);
           for(int it:revAdj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
           }
        }
        Collections.sort(ans);
        return ans;
    }
}