class Solution {
    //two pointer
    public int[] twoSum(int[] nums, int target) {
         Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
           int num=nums[i];
           int idx1=i;
           int complement=target-num;
           if(map.containsKey(complement)){
            int idx2=map.get(complement);
            if(idx1!=idx2)
             return new int[] {idx1,idx2};
           }
        }
        return new int[] {-1,-1};
    }
}