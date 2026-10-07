class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=nums[i];
            int complement=target-num;
            if(map.containsKey(complement)){
                return new int[]{i,map.get(complement)};
            }
            map.put(num,i);
        }
        return new int[]{};
    }
}