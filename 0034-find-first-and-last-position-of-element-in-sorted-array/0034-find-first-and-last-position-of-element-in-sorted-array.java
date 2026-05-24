class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};
       int f=find(nums,target,true);
       int l=find(nums,target,false);
       ans[0]=f;
       ans[1]=l;
       return ans;
    }
    private int find(int[] nums, int target,boolean index){
        int s=0;
        int n=nums.length;
        int e=n-1;
        int ans=-1;
        while(s<=e){
          int m=s+(e-s)/2;
          if(nums[m]<target) s=m+1;
          else if(nums[m]>target) e=m-1;
          else{
            ans=m;
            if (index)
             e=m-1;
           else{
            s=m+1;
          }
        }
      }
        return ans;
    }
    
}