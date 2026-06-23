class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,c=0;
        //map with sum and freq
        Map<Integer,Integer> map=new HashMap<>();
        //alwz 0 sum is present by default with freq 1
        map.put(0,1);
        int sum=0;
        for(int num:nums){
           sum+=num;
           if(map.containsKey(sum-k)){
            c+=map.get(sum-k);
           }
           // freq increases coz more subarrays can be generated
           map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
            }
}