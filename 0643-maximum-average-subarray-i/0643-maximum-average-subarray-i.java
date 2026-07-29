class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int l = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);

                // Slide the window
                sum -= nums[l];
                l++;
            }
        }

        return (double) maxSum / k;
    }
}