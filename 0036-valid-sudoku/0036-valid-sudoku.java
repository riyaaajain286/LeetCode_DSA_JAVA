class Solution {
    public boolean isValidSudoku(char[][] board) {
       for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            char c=board[i][j];
            if(board[i][j]!='.'){
                //temporaily empty this cell
             
                if(!validity(board,i,j,c)){
                    return false;
                }
                //restore value
                
            }
        }
       }
       return true;
    }
    private boolean validity(char[][] board,int i,int j,char c){
        for(int k=0;k<9;k++){
            if(k!=j && board[i][k]==c){
                return false;
            }
             if(k!=i && board[k][j]==c){
                return false;
            }
            int sr=3*(i/3)+(k/3);
            int sc=3*(j/3)+(k%3);
            if((sr!=i||sc!=j) && board[sr][sc]==c){
                return false;
            }
        }
        return true;
        
    }
}