class Solution {
    int dp[][]=new int[101][10001];
    public int superEggDrop(int k, int n) {
        //  initialize dp with -1
       for(int[] row:dp){
        Arrays.fill(row,-1);
       }
        return solve(k,n);
    }
    public int solve(int k, int n){
        //base case
        if(n==0||n==1)  return n;
        if(k==1) return n;
        if(dp[k][n]!=-1) return dp[k][n];
        
        //i=1;we will move k on all floors of the building
        //j=f
        int ans=Integer.MAX_VALUE;
        int low=1,high=n;
        while(low<=high){
            int mid=(low+high)/2;

            int breakEgg=solve(k-1, mid-1);
            int notBreak=solve(k, n-mid);

            int temp=1+Math.max(breakEgg, notBreak);
            ans=Math.min(ans, temp);

            if(breakEgg<notBreak){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return dp[k][n]=ans;
    }
}