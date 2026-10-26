class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        int prefixSum=0,suffixSum=0;
        for(int n:nums){
            total+=n;
        }
        for(int i=0;i<nums.length;i++){
            suffixSum=total-prefixSum-nums[i];
            if(prefixSum==suffixSum)
               return i;
            prefixSum+=nums[i];
        }
        return -1;
    }
}