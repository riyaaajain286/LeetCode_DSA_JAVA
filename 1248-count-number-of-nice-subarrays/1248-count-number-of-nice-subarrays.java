class Solution {
    // HashMap+PrefixSum
    //here treating oddCount as subarray sum means doing same as subarray sum equals k
    public int numberOfSubarrays(int[] nums, int k) {
        int result=0;
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int OddCount=0;
        map.put(0,1);//0 OddCount appears once in starting
        for(int i:nums){
            // OddCount+=nums[i]%2;
            if(i%2!=0)
               OddCount++;
            if(map.containsKey(OddCount-k))
               result+=map.get(OddCount-k);
            
            map.put(OddCount,map.getOrDefault(OddCount,0)+1);
            
        }
        return result;
    }
}