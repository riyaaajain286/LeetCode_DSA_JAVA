class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        List<Set<Integer>> anc=new ArrayList<>();
         for(int i=0;i<n;i++){
            anc.add(new TreeSet<>());
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
            q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(int adjnode:adj.get(node)){
                anc.get(adjnode).add(node);
                anc.get(adjnode).addAll(anc.get(node));
                indegree[adjnode]--;
                if( indegree[adjnode]==0){
                    q.add(adjnode);
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(Set<Integer> eachset:anc){
            res.add(new ArrayList<>(eachset));
        }
            return res;
        }
    
}