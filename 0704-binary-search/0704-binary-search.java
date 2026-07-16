class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int e=nums.length-1;
        while(l<=e){
         int mid=l+(e-l)/2;
         if(nums[mid]==target){
            return mid;
         }
         else if(nums[mid]<target){
            l=mid+1;
         }
         else{
            e=mid-1;
         }
        }
        return -1;
    }
}