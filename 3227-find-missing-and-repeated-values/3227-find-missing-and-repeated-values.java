class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
  int n=grid.length;
  int size=n*n;
  int sum=0;
  HashSet<Integer> set=new HashSet<>();
  int ans[]=new int[2];
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
        if(set.contains(grid[i][j])){
            ans[0]=grid[i][j];
        }
        else{
            set.add(grid[i][j]);
            sum=sum+grid[i][j];
        }
    }
  }
  int ts=(size*(size+1))/2;
  ans[1]=ts-sum;
  return ans;
    }
}