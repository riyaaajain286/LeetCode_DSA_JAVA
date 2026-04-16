class Solution {
    int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> list:connections){
            int u=list.get(0);
            int v=list.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean []vis=new boolean[n];
        int []tin=new int[n];
        int low[]=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0, -1, vis, adjList, tin, low, bridges);
        return bridges;
    }

    void dfs(int node, int parent, boolean []vis, List<List<Integer>> adjList, int []tin, int []low, List<List<Integer>> bridges){
        vis[node]=true;
        low[node]=tin[node]=timer;
        timer++;

        for(int el: adjList.get(node)){
            if(el==parent) continue;

            if(!vis[el]){
                dfs(el, node, vis, adjList, tin, low, bridges);
                low[node]=Math.min(low[node], low[el]);
                // node--low check bridge
                if(low[el]>tin[node]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(el);
                    temp.add(node);
                    bridges.add(temp);
                }
            }else{
                low[node]=Math.min(low[node], low[el]);
            }
        }
    }
}