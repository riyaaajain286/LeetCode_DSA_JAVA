class Solution {
    public int removeDuplicates(int[] nums) {
        //LinkedHashSet preserves order of elements
        //not optimal siznce it uses extra memory as set is used
        Set<Integer> set=new LinkedHashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int i=0;
        for(int j:set){
            nums[i++]=j;
        }
        return i;//return size of array that can be calc. by last index
    }
}