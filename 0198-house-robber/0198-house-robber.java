class Solution {
    //memoization
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int ans=helper(nums,0);
        return ans;
    }
    public int helper(int[] nums,int i){
        if(i>=nums.length) return 0;
        //memocheck
        if(dp[i]!=-1) return dp[i];
        int option1=nums[i]+helper(nums,i+2);//rob
        int option2=0+helper(nums,i+1);//skip
        dp[i]= Math.max(option1,option2);
        return dp[i];
    }
}