class Solution {
    public int majorityElement(int[] nums) {
        int len=nums.length;
        int range=len/2;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        for(int i=0;i<len;i++){
            int value=freq.get(nums[i]);
            if(value>range)
               return nums[i];
        }
        return -1;
    }
}