class Solution {
    public List<List<String>> solveNQueens(int n) {
    List<List<String>> allboards=new ArrayList<>();
    char board[][]=new char[n][n];
     // initialize board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
    helper(board,allboards,0);
    return allboards;
  }
  public void helper(char[][] board,List<List<String>> allboards,int col){
    if(col==board.length){
      saveBoard(board,allboards);
      return;
    }
    for(int row=0;row<board.length;row++){
      if(isSafe(row,col,board)){
        board[row][col]='Q';
        helper(board,allboards,col+1);
         board[row][col]='.';
      }
    }
  }
  public boolean isSafe(int row,int col,char[][] board){
    //horizontal
    for(int j=0;j<board.length;j++){
      if(board[row][j]=='Q'){
        return false;
      }
    }
    //vertical
    // for(int i=0;i<board[0].length;i++){
    //   if(board[i][col]=='Q'){
    //     return false;
    //   }
    // }
    //upper left
    for(int r=row,c=col;r>=0&&c>=0;r--,c--){
      if(board[r][c]=='Q')
      return false;
    }
    //upper right
    //  for(int r=row,c=col;r>=0&&c<board.length;r--,c++){
    //    if(board[r][c]=='Q')
    //   return false;
    // }
     //lower left
    for(int r=row,c=col;r<board.length&&c>=0;r++,c--){
       if(board[r][c]=='Q')
      return false;
    }
     //lower right
    // for(int r=row,c=col;r<board.length&&c<board.length;r++,c++){
    //  if(board[r][c]=='Q')
    //   return false;
    // }
    return true;
  }
  public void saveBoard(char[][] board,List<List<String>> allboards){
    String row="";
    List<String> newboard=new ArrayList<>();
    for(int i=0;i<board.length;i++){
      row="";
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]=='Q'){
          row+='Q';
        }
        else{
          row+='.';
        }
      }
      newboard.add(row);
    }
    allboards.add(newboard);
  }
  }