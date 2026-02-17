class Solution {
    //memoization
    public int rob(int[] nums) {
        int n=nums.length;
        //edge case
        if(n==1) return nums[0];
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        // Case 1: Exclude last house coz cirular
        int option1=helper(nums,0,n-2,dp1);
         // Case 2: Exclude first house
        int[] dp2=new int[n+1];
        Arrays.fill(dp2,-1);
        int option2=helper(nums,1,n-1,dp2);
        int ans=Math.max(option1,option2);
        return ans;
    }
    public int helper(int[] nums,int ind,int end,int[] dp){
        //base case
        if(ind>end) return 0;
        //memo check
        if(dp[ind]!=-1) return dp[ind];
        // Rob current house
        int take=nums[ind]+helper(nums,ind+2,end,dp);
        // skip current house
        int skip=helper(nums,ind+1,end,dp);
        dp[ind]=Math.max(take,skip);
        return dp[ind];
    }

}