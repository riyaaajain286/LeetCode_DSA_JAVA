class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int ans=-1;
        for(int i:nums){
            if(i>0 && set.contains(-i)){
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}