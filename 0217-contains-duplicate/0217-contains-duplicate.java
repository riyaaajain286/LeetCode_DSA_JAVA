class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            if(!set.add(n)){// add returns false if already present
              return true;
            }
        }
        return false;
    }
}