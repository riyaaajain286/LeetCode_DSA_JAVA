class Solution {
    //memoization
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==0) return 0;
        if(n==1) return cost[0];
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int option1=helper(cost,0);
        int option2=helper(cost,1);
        return Math.min(option1,option2);
    }
    public int helper(int[] cost,int i){
        if(i>=cost.length) return 0;
        //memo check
        if(dp[i]!=-1) return dp[i];
        int step1=cost[i]+helper(cost,i+1);
        int step2=cost[i]+helper(cost,i+2);
        dp[i]=Math.min(step1,step2);
        return dp[i];
    }
}