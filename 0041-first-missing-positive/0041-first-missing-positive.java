class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        // Check if 1 is present
       boolean containsOne=false;
       for(int n:nums){
        if(n==1){
            containsOne=true;
            break;
        }
       } 
       if(!containsOne) return 1;
       //Replace invalid values with 1
       for(int i = 0; i < len; i++){
         if(nums[i] <= 0 || nums[i] > len){
           nums[i] = 1;
         }  
       }
       //Mark indices
       for(int j=0;j<len;j++){
        int num=Math.abs(nums[j]);
        int index=num-1;
        if(nums[index]>0){
            nums[index]=-nums[index];
        }
       }
    //    Find first positive
       for(int k=0;k<len;k++){
        if(nums[k]>0){
            return k+1;
        }
       }
       return len+1;
    }
}