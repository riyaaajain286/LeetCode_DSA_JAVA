class Solution {
    int[] dr={-1,0,1,0};
    int[] dc={0,1,0,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int prevc=image[sr][sc];
        if(prevc==color) return image;
         dfs(image,sr,sc,color,prevc);
           return image;
        
    }
    public void dfs(int[][] image,int r,int c,int color,int prevc){
        image[r][c]=color;
        int n=image.length;
        int m=image[0].length;
        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];
            if(nr>=0 && nc>=0 && nr<n && nc<m && image[nr][nc]==prevc){
                dfs(image,nr,nc,color,prevc);
            }
        }
    }
}
