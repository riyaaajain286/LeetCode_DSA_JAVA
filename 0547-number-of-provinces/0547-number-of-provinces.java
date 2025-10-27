class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[]  visited=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){//check for all nodes
        if(visited[i]==false){
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
           while(!q.isEmpty()){
            int city=q.poll();
            for(int j=0;j<n;j++){
                if(isConnected[city][j]==1&&visited[j]==false){
                    visited[j]=true;
                    q.add(j);
                }
            }
           }
           provinces++;
        }
    }
    return provinces;
    }
}