class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum=0;
        for(int n:nums){
            totalsum+=n;
        }
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            if(leftsum==totalsum-leftsum-nums[i]){
                return i;
            }
            leftsum+=nums[i];
        }
        return -1;
    }
}