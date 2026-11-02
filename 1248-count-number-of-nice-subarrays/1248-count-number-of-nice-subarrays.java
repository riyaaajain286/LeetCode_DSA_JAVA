class Solution {
    //sliding window atMostK approach
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
    private int atMostK(int[] nums, int k){
        int l=0;
        int count=0,result=0;
        int n=nums.length;
        for(int r=0;r<n;r++){
           if(nums[r]%2!=0){
            count++;
           }
           while(count>k){
            if(nums[l]%2!=0){
                count--;
            }
            l++;
           }
           result+=r-l+1;
        }
        return result;
        }
}