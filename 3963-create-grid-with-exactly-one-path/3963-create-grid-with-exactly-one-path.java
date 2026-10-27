class Solution {
    public String[] createGrid(int m, int n) {
        char[][] grid=new char[m][n];

         // Initially, make every cell an obstacle
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='#';
            }
        }
        // Make the entire top row free
        for(int j=0;j<n;j++){
            grid[0][j]='.';
        }
        // Make the entire last column free
        for(int i=1;i<m;i++){
            grid[i][n-1]='.';
        }
         // Convert each row into a String
        String[] ans=new String[m];
        for(int i=0;i<m;i++){
            ans[i]=new String(grid[i]);
        }
        return ans;
    }
}