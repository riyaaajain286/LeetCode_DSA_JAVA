class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
           sum+=nums[i];
        }
        int maxSum=sum;
        // int l=0;
        for(int j=k;j<nums.length;j++){
            sum=sum-nums[j-k]+nums[j];
            // sum-=nums[l];
            // sum+=nums[j];
            maxSum=Math.max(maxSum,sum);
            // l++;
        }
        double average=(double)maxSum/k;
        return average;   
    }
}