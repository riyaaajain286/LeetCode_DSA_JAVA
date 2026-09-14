class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int j:nums)
            set.add(j);

        for(int i=0;i<=n;i++){
            
            if(!set.contains(i)){
                return i;
            }
            
        }
        return -1;
    }
}