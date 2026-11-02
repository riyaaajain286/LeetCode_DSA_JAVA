class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int i=0;
        int OddCount=0,prevCount=0,result=0;
        int n=nums.length;
        for(int j=0;j<n;j++){
            if(nums[j]%2!=0){
                OddCount++;
                prevCount=0;
            }
            while(OddCount==k){
                prevCount++;
                if(nums[i]%2!=0){
                    OddCount--;
                   
                }
                 i++;
            }
            result+=prevCount;
        }
        return result;
    }
}