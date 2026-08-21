class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            
            if( !vis[i][j] && board[i][j]==word.charAt(0)){
            if(dfs(board,word,vis,i,j,1))
            return true;
            }
        }
        }
        return false;
    }
   
  static int[] dr={-1,0,1,0};
  static int[] dc={0,1,0,-1};

  private static boolean dfs(char[][] board,String word,boolean[][] vis,int i,int j,int ind){
     int n=board.length;
     int m=board[0].length;
     if(ind>=word.length()) return true; 
     vis[i][j]=true;
     for(int k=0;k<4;k++){
      int nr=i+dr[k];
      int nc=j+dc[k];
      if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && board[nr][nc]==word.charAt(ind)){
        if(dfs(board,word,vis,nr,nc,ind+1)){
          return true;
        }
      }
     }
     //backtrack
     vis[i][j]=false;
     return false;
  }
}