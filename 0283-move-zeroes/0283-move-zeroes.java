class Solution {
    public void moveZeroes(int[] nums) {
        int low=0;
        int l=nums.length;
      
        for(int r=0;r<l;r++){
            if(nums[r]!=0){
                int temp=nums[r];
                nums[r]=nums[low];
                nums[low]=temp;
                low++;
            }
        }
    
    }
}