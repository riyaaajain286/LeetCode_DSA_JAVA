class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[]  visited=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){//check for all nodes
          if(visited[i]==false){
            dfs(isConnected,visited,i);
            provinces++;
          }
        }
        return provinces;
    }
    public void dfs(int[][] isConnected,boolean[] visited,int i){
        visited[i]=true;
         int n=isConnected.length;
        for(int j=0;j<n;j++){///check for every neighbour if coonected
           if(isConnected[i][j]==1&&visited[j]==false){
            dfs(isConnected,visited,j);
           }
        }
    }
}