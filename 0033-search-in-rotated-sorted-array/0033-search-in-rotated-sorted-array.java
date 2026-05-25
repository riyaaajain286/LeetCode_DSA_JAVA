class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target) return mid;
            
            //left half sorted
            if(nums[s]<=nums[mid]){
              //target in left
              if(target>=nums[s] && target<nums[mid])
                e=mid-1;
             //else in right
              else s=mid+1; 
            }

            //right half sorted
        //    else if(nums[mid]<nums[e]){
        else{
              //target in right
              if(target>nums[mid] && target<=nums[e])
               s=mid+1;
            //else in left
             else e=mid-1; 
            }
        }
         return -1; 
    }
   
}