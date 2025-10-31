class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int ans=((int)n/3)+1;
        List<Integer> anslist=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==ans){
                anslist.add(nums[i]);
            }
            if(anslist.size()==2){
                return anslist;
            }
        }
        return anslist;
    }
}