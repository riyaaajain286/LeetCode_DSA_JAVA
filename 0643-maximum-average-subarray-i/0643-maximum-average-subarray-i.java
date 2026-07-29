class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int l=0;
       int n=nums.length;
       int maxsum=Integer.MIN_VALUE;
       int sum=0; 
       double average=0.00; 
       for(int r=0;r<n;r++){ 
           sum+=nums[r];
           if(r-l+1>=k){
              maxsum=Math.max(maxsum,sum);
              sum-=nums[l];
              l++;
            }
        }
        average=(double)maxsum/k; 
        return average;
    }
}