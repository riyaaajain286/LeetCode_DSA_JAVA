class Solution {
    //here the approach is that initially we are checking teh boundary that is first and last col and row then then using a visited array marking all O to 1 which are at boundary initially and then through other we check if vis is not 1 means 0 and board is O means inner matrix then mark it as X
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        //first row boundar check if O then mark visited as 1
        for(int j=0;j<m;j++){
            if(visited[0][j]==0 && board[0][j]=='O'){
                dfs(board,0,j,visited);
              
            }
               
        }

        for(int j=0;j<m;j++){
            if(visited[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(board,n-1,j,visited);
               
            }
              
        }

        for(int i=0;i<n;i++){
            if(visited[i][0]==0 && board[i][0]=='O'){
                dfs(board,i,0,visited);
                
            }    
        }

        for(int i=0;i<n;i++){
            if(visited[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(board,i,m-1,visited);
                
            }
        }
       //this works at last to finally convert inner O to X
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && visited[i][j]==0){
                    board[i][j]='X';
                    
                }
            }
        }
    }
    static int[] drow={-1,0,1,0};
    static int[] dcol={0,1,0,-1};
    public static void dfs(char[][] board, int i, int j,int[][] visited){
      int n=board.length;
      int m=board[0].length;
      visited[i][j]=1;
      for(int k=0;k<4;k++){
        int nrow=i+drow[k];
        int ncol=j+dcol[k];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O' ){
            
            dfs(board,nrow,ncol,visited);
        }
      }
    }
}