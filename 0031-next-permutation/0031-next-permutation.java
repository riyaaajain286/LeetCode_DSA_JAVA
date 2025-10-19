class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;
    int n=nums.length;
    for(int i=n-2;i>=0;i--){
      if(nums[i]<nums[i+1]){
        ind=i;
        break;
      }
    }
     if(ind==-1){
      reverse(0,n-1,nums);
      return;
    }
    for(int i=n-1;i>ind;i--){
      if(nums[i]>nums[ind]){
        swap(i,ind,nums);
        break;
      }
    }
    reverse(ind+1,n-1,nums);
   
    return ;
  }
  private static void swap(int a,int b,int[] nums){
    int temp=nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
  }
  private static void reverse(int a,int b,int[] nums){
    while(a<b){
      swap(a,b,nums);
      a++;
      b--;
    }
  }
}
