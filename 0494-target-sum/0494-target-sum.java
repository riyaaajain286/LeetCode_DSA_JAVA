class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int n:nums){
        sum+=n;
        }
        if(Math.abs(target)>sum) return 0;
        if((sum+target)%2!=0) return 0;
        int s1=(sum+target)/2;
        int count=count(nums, s1);
        return count;
        }
  private static int  count(int[] nums,int target){
      int n=nums.length;
      int[][] dp=new int[n+1][target+1];
      //initialization
      dp[0][0]=1;
      for(int i=1;i<=n;i++){
        for(int j=0;j<=target;j++){
          if(nums[i-1]<=j){
            dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
        }
        else{
          dp[i][j]=dp[i-1][j];
        }
      }
      }
      return dp[n][target];
  } 
    
}