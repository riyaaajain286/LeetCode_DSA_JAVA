class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int sum=0;
    int zerocount=0;
    for(int n:nums){
      sum+=n;
      if(n==0) zerocount++;
    }
    // ❗ absolute target cannot exceed sum
    if(Math.abs(target)>sum) return 0;
    //sum +differnece must be even
    if((sum+target)%2!=0) return 0;
    int s1=(target+sum)/2;
    // ❗ s1 must be non-negative
    if(s1<0) return 0;
    int ways= subsetCount(nums,s1);
    //for handling zero elements
    return ways*(int)(Math.pow(2,zerocount));
  } 
  public static int subsetCount(int[] arr,int sum){
    int n=arr.length;
    int[][] dp=new int[n+1][sum+1];
    for(int i=0;i<=n;i++){
      dp[i][0]=1;
    }
    for(int j=1;j<=sum;j++){
      dp[0][j]=0;
    }
    for(int i=1;i<=n;i++){
      for(int j=1;j<=sum;j++){
         if(arr[i-1]==0){
              dp[i][j]=dp[i-1][j];//zero handled later
          }
        else if(arr[i-1]<=j){
        dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
      }
      else{
        dp[i][j]=dp[i-1][j];
      }
       
    }
  }
  return dp[n][sum];
    }
}