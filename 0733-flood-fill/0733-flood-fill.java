class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int prevcolor=image[sr][sc];
        if(prevcolor==color) return image;
        
        dfs(image,sr,sc,color,prevcolor);
        return image;
    }
    
    private void dfs(int[][] image,int i,int j,int color,int prevcolor){
         image[i][j]=color;
        int n=image.length;
        int m=image[0].length;
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        for(int k=0;k<4;k++){
            int nrow=i+row[k];
            int ncol=j+col[k];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&image[nrow][ncol]==prevcolor){
             
              dfs(image,nrow,ncol,color,prevcolor);
            }
        }
    }
}
