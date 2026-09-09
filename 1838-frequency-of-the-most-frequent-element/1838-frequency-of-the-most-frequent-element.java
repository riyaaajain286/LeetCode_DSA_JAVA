class Solution {
    // sorting + sliding window
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0;
        long sum=0;
        int count=1;
        for(int right=0;right<n;right++){
            sum+=nums[right];
             // Cost to make every element in [left...right]
            // equal to nums[right]
            long cost=(long)nums[right]*(right-left+1)-sum;
             // If we don't have enough k, shrink the window
            while(cost>k){
                sum-=nums[left];
                left++;
                cost=(long)nums[right]*(right-left+1)-sum;
            }
            count=Math.max(count,(right-left+1));
        }
        return count;
    }
}