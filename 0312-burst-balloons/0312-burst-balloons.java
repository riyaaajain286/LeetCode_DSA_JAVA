class Solution {
    //memoized
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        
        int[] newNums=new int[n+2];
        dp=new int[n+2][n+2];
        for(int[] r:dp)
         Arrays.fill(r,-1);
        newNums[0]=1;
        newNums[n+1]=1;
        for(int i=0;i<n;i++){
          newNums[i+1]=nums[i];
        }
        return solve(newNums,1,n);
    }
    private int solve(int[] nums,int maxL,int maxR){
        int max=Integer.MIN_VALUE;
        if(maxL>maxR) return 0;
        if(dp[maxL][maxR]!=-1) return dp[maxL][maxR];
        for(int i=maxL;i<=maxR;i++){
            int profit=nums[maxL-1]*nums[i]*nums[maxR+1];
            int leftCoins=solve(nums,maxL,i-1);
            int rightCoins=solve(nums,i+1,maxR);
            max=Math.max(max,(profit+leftCoins+rightCoins));
            dp[maxL][maxR]=max;
        }
        dp[maxL][maxR]=max;
        return  dp[maxL][maxR];
    }
}