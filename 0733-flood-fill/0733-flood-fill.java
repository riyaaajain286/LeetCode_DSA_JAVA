class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int prevcolor=image[sr][sc];
        if(prevcolor==color) return image;
        dfs(image,sr,sc,color,prevcolor);
        return image;
    }
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};
    private void dfs(int[][] image,int i,int j, int color,int prevcolor){
      image[i][j]=color;
      int n=image.length;
      int m=image[0].length;
      for(int k=0;k<4;k++){
        int nr=i+row[k];
        int nc=j+col[k];
        if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==prevcolor){
            dfs(image,nr,nc,color,prevcolor);
        }
      }
    }
}