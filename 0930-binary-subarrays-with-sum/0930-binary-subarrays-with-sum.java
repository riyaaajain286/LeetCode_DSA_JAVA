class Solution {
    //hashmap+prefix sum
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        //prefix sum 0 occurs once
        map.put(0,1);
        int sum=0,c=0;
        for(int n:nums){
            sum+=n;
            //for each occurence of prefix sum diff subarray r formed therefore take all
            if(map.containsKey(sum-goal)){
                c+=map.get(sum-goal);
            }
            //alw increase freq to keep count of all subarrays
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}