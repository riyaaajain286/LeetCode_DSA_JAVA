class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum=0;
        for(int n:nums){
            totalsum+=n;
        }
        int leftsum=0,rightsum=0;
        for(int j=0;j<nums.length;j++){
            rightsum=totalsum-leftsum- nums[j];
            if(rightsum==leftsum){
                return j;
            }
            else{
                leftsum+=nums[j];
            }
        }
        return -1;
    }
}