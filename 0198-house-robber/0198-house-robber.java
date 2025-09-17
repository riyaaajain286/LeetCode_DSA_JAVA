class Solution {
    public int rob(int[] nums) {
   int n=nums.length;
   if(n==1){
    return nums[0];
   }
      //bottom-up approach
   int [] arr=new int[n+1];
  //arr[i] means max stolen money till ith house
   //if no house means i=0
   arr[0]=0;
   //1 house
   arr[1]=nums[0];
   for(int i=2;i<=n;i++){
    int steal=nums[i-1]+arr[i-2];
    int skip=arr[i-1];
    arr[i]=Math.max(steal,skip);
   }
   return arr[n];
}
}