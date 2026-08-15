class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int provinces=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){//for every component
                dfs(isConnected,i,vis);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected,int i,boolean[] vis){
        int n=isConnected.length;
        vis[i]=true;
        for(int k=0;k<n;k++){
            if(isConnected[i][k]==1 && !vis[k]){
                dfs(isConnected,k,vis);
            }
        }
    }
}