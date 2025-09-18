class Solution {
    public int majorityElement(int[] nums) {
     Arrays.sort(nums);
     int n=nums.length;
     int max=nums[n/2];
     return max;
    }
}