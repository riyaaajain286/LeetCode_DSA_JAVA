class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int s=matrix[0][0];
        int e=matrix[n-1][n-1];
        while(s<e){
            int m=s+(e-s)/2;
            int count=countlessequal(matrix,m);
            if(count<k){
                s=m+1;
            }
            else{
                e=m;
            }
         }
        return s;
    }
    //count how many numbers <=mid
    public int countlessequal(int[][] matrix,int m){
        int n=matrix.length;
        int count=0;
        int row=n-1;
        int col=0;
        while(row>=0&&col<n){
            if(matrix[row][col]<=m){
                count+=(row+1);
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}