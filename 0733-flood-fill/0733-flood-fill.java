class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int prevcolor=image[sr][sc];
        if(prevcolor==color) return image;
        dfs(image,sr,sc,color,prevcolor);
        return image;
    }
    int[] delrow={-1,0,1,0};
    int delcol[]={0,1,0,-1};
    public void dfs(int[][] grid,int r,int c,int color,int prevcolor){
        int n=grid.length;
        int m=grid[0].length;
        grid[r][c]=color;
        for(int i=0;i<4;i++){
             int nrow=r+delrow[i];
             int ncol=c+delcol[i];
             if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&grid[nrow][ncol]==prevcolor){
                dfs(grid,nrow,ncol,color,prevcolor);
             }
        }
    }
}