class Solution {
    //sliding window +2 pointer
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxlen=0;
        int zeroCount=0;
        while(r<nums.length){
        // for(int r=0;r<nums.length;r++){
            if(nums[r]==0)
                zeroCount++;
            while(zeroCount>k){
                if(nums[l]==0){
                    zeroCount--;
                }
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
    }
}