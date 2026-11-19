class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        //changing min and max no i.e. first and last in sorted array then +1 and -1 index are same so take them
        int case1=nums[n-2]-nums[1];
        //changing two min no i.e. first two in sorted array equal to 2 index then 2 index is same so take that. to make high
        int case2=nums[n-1]-nums[2];
         //changing two max no i.e. two last in sorted array equal to n-3 index then n-3 index is same so take that. to make high
        int case3=nums[n-3]-nums[0];
        //only taking high as final score cpz low is always 0
        return Math.min(case1,(Math.min(case2,case3)));
    }
}