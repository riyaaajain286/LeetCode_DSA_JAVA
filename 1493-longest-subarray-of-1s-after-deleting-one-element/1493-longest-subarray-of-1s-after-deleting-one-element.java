class Solution {
    public int longestSubarray(int[] nums) {
       int l=0;
       int c=0,maxlen=0;
       for(int r=0;r<nums.length;r++){
        if(nums[r]==0){
            c++;
        }
        if(c>1){
            if(nums[l]==0)
             c--;
            l++;
        }
        maxlen=Math.max(r-l+1,maxlen);
       } 
       return maxlen-1;
    }
}