class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int n:set){
            //this is the start of sequence
            if(!set.contains(n-1)){
              int current=n;
              int length=1;
              while(set.contains(current+1)){
                current++;
                length++;
              }
              max=Math.max(max,length);
            }
        }
        return max;
    }
}