class Solution {
    //memoization
    Boolean[][] dp;//wrapper class
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int s:nums){
            sum+=s;
        }
        dp=new Boolean[n+1][sum/2+1];
        // for(boolean[] r:dp){
        //     Arrays.fill(r,false);
        // }
        if(sum%2==0){//even sum then equal subsets possible
           return subset(nums,n,sum/2);
        }
        else
         return false;
    }
    private boolean subset(int[] nums,int n,int sum){
       if(n==0) return false;
       if(sum==0) return true;
       if(dp[n][sum]!=null)
        return dp[n][sum];
       if(nums[n-1]<=sum){
        dp[n][sum]=subset(nums,n-1,sum-nums[n-1]) || subset(nums,n-1,sum); 
       }
       else{
        dp[n][sum]=subset(nums,n-1,sum);
       }
       return dp[n][sum];
    }
}