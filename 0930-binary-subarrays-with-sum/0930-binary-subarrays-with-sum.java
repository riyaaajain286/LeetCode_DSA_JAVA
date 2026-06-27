class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      return AtMost(nums,goal)-AtMost(nums,goal-1);
    }
    private int AtMost(int[] nums, int goal){
        if(goal<0) return 0;
         int n=nums.length;
        int l=0;
        int sum=0,c=0;
        // while(r<n){
        for(int r=0;r<n;r++){
           sum+=nums[r];
           while(sum>goal){
            sum-=nums[l];
            l++;
            
            }
           c+=(r-l+1);
        //    r++;
        }
        return c;
    }
}