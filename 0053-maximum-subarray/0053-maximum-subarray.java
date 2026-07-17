class Solution {
    public int maxSubArray(int[] nums) {
        int totalsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int n:nums){
            totalsum+=n;
            maxsum=Math.max(totalsum,maxsum);
            if(totalsum<0){
                totalsum=0;
            }
        }
        return maxsum;
    }
}