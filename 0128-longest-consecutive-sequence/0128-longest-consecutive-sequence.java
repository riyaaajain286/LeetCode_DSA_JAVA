class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int longest=0;
        Set<Integer> set=new HashSet<>(n*2);
        for(int i:nums){
            set.add(i);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int c=1;
                int currNum=num;
                 while(set.contains(currNum+1)){
                    c++;
                    currNum=currNum+1;
                 }
            longest=Math.max(longest,c);
            }
        }
        return longest;
    }
}