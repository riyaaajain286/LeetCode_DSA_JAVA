class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         //sliding window approach
        int i=0;
        long sum=0;
        long maxsum=0;
        HashSet<Integer> set=new HashSet<>();
        for(int j=0;j<nums.length;j++){
            // If duplicate found, remove until it's gone
            while(set.contains(nums[j])){
                set.remove( nums[i]);
                sum-=nums[i];
                i++;
            }
            
            // Add current element
            set.add(nums[j]);
            sum+=nums[j];
            // If window size exceeds k, shrink
            if(j-i+1>k){
                set.remove(nums[i]);
              sum-=nums[i];
              i++;
            }
             // If window size == k, update answer
            if(j-i+1==k){
                maxsum=Math.max(sum,maxsum);
            }
        }
        return maxsum;
    }
}