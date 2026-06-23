class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,max=nums[0];
        int n=nums.length;
        // if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(max<sum) max=sum;
            if(sum<0) sum=0;
         }
        return max;
    }
}