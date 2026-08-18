class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        List<Integer> ans=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int num:nums)
         set.add(num);
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
               ans.add(i);
            }
        }
        return ans;
    }
}