class Solution {
    public int[][] findFarmland(int[][] land) {
        //Every farmland group is a perfect rectangle.
    int n=land.length;
    int m=land[0].length;
    List<int[]> list=new ArrayList<>();
    //check topmost
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if((land[i][j]==1) && (i==0 ||land[i-1][j]==0) && (j==0||land[i][j-1]==0)){
          int r=i;
          int c=j;
          //move down
         while(r<n && land[r][j]==1 ){
           r++;
         }
         //move right
          while(c<m && land[i][c]==1 ){
            c++;
          }
          //taking n-1 coz we stop at n when its =0 so take n-1 for land
          list.add(new int[]{i,j,r-1,c-1});
        }
      }
    }
    return list.toArray(new int[list.size()][]);
    }
}