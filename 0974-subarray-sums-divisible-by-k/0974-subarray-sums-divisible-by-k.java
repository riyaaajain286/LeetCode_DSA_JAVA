class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int sum=0,rem=0;
        int[] freq=new int[k];
        freq[0]=1;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            rem=sum%k;
            // Handle negative remainders
            if(rem<0)
               rem+=k;
            if(freq[rem]>0)
               count+=freq[rem];
            freq[rem]++;
        }
         return count;
    }
}