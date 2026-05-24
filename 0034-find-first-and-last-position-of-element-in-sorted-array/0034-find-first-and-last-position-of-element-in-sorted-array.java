class Solution {
    public int[] searchRange(int[] nums, int target) {
         int f=findFirst(nums,target);
       int l=findLast(nums,target);
       return new int[]{f,l};
    }
    private int findFirst(int[] nums, int target){
        int s=0;
        int n=nums.length;
        int e=n-1;
        int ans=-1;
        while(s<=e){
          int m=s+(e-s)/2;
          if(nums[m]==target){
            ans=m;
            e=m-1;
          }
          else if(nums[m]<target) s=m+1;
          else e=m-1;
        }
        return ans;
    }
    private int findLast(int[] nums, int target){
        int s=0;
        int n=nums.length;
        int e=n-1;
        int ans=-1;
        while(s<=e){
          int m=s+(e-s)/2;
          if(nums[m]==target){
            ans=m;
            s=m+1;
          }
          else if(nums[m]<target) s=m+1;
          else e=m-1;
        }
        return ans;
    }
}