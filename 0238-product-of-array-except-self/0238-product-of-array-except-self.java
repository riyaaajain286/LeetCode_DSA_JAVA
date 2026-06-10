class Solution {
    public int[] productExceptSelf(int[] nums) {
      //prefix suffix approach
       int[] ans=new int[nums.length];
       ans[0]=1;
       for(int i=1;i<nums.length;i++){
        ans[i]=ans[i-1]*nums[i-1];
       } 
       int suffix=1;
       for(int j=nums.length-1;j>=0;j--){
        ans[j]=ans[j]*suffix;
        suffix=nums[j]*suffix;
       }
       return ans;
    }
}