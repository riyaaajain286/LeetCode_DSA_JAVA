class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean [][]vis=new boolean[n][m];
                    if(dfs(board, word, i, j, 1, vis)) return true;
                }
            }
        }

        return false;
    }
    
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    boolean dfs(char [][]board, String word, int row, int col, int k, boolean [][]vis){
        if(k>=word.length()) return true;
        vis[row][col]=true;

        for(int i=0;i<4;i++){
            int nrow=row+dx[i];
            int ncol=col+dy[i];

            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol<board[0].length && !vis[nrow][ncol] && board[nrow][ncol]==word.charAt(k)){
                if(dfs(board, word, nrow, ncol, k+1, vis)) return true;
            }
        }

        // BACKTRACK
        vis[row][col] = false;
        return false;
    }
}