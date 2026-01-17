class Solution {
    //variation of knapsack problem
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)  
           return false;
        else if(sum%2==0){
            return isSubsetSum(nums,sum/2);
        }
        return false;
    }
      static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        //base case
        //sum 0 always possible then return empty set
        for(int i=0;i<=n;i++){
             dp[i][0]=true;
             }
            for(int j=0;j<=sum;j++){
              dp[0][j]=false;///empty set(no elements) then no summ possible
            }
        
        //iteration
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
  }

}