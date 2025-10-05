class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                //check for empty cell
                if(board[row][col]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,row,col,c)){
                            board[row][col]=c;
                           // recurse to next cell
                            if(solve(board)){
                              return true;
                            }
                            //backtrack and check for other solution
                            else{
                               board[row][col]='.'; 
                            }
                        }
                    }
                    //no valid number found
                    return false;

                }
            }
        }
       // sudoku completely filled
        return true;
    }
    private boolean isValid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==c) //row
              return false;
            if(i!=row && board[i][col]==c) //col
              return false;
              //check for3*3 grid
            int subrow=(3*(row/3)+(i/3));
            int subcol=(3*(col/3)+(i%3));
            if((i!=subrow||i!=subcol) && board[subrow][subcol]==c)
               return false;
    
        }
        return true;
    }
}