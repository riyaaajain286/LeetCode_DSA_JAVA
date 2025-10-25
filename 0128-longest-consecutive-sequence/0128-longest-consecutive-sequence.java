class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int lastsmallest=Integer.MIN_VALUE;
        int longest=1;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==lastsmallest){
                c++;
                lastsmallest=nums[i];
            }
            else if(nums[i]!=lastsmallest){
                c=1;
                lastsmallest=nums[i];
            }
            else{
                continue;
            }
            longest=Math.max(longest,c);
        }
       return longest;
    }
}