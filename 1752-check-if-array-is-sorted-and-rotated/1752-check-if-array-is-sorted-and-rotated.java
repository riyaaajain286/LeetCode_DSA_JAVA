class Solution {
    //in a sorted and rotated array there can be atmost one place where nums[i]>(nums[i+1]%n)
    public boolean check(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                c++;
            }
        }
        return c<=1;
    }
}