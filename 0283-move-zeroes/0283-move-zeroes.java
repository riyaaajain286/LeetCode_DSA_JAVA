class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]!=0){
                nums[l]=nums[r];
                l++;
            }
        }
        for(int j=l;j<nums.length;j++){
            nums[j]=0;
        }
    }
}