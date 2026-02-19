class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){// traverse every   node
          if(vis[i]==false){
            dfs(isConnected,vis,i);
            provinces++;
        }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] vis,int node){
        int n=isConnected.length;
        vis[node]=true;
        for(int j=0;j<n;j++){//check every cell
          if(isConnected[node][j]==1 && vis[j]==false)
             dfs(isConnected,vis,j);
        }
    }
}