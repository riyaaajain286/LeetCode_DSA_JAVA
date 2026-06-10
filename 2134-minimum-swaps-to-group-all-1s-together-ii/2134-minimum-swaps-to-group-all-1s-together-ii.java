class Solution {
    public int minSwaps(int[] nums) {
        int oneCount=0;
        for(int n:nums){
            if(n==1){
                oneCount++;
            }
        }
          if (oneCount == 0 || oneCount == nums.length) {
            return 0;
        }
        int minswaps=0;
        int currzero=0;
        //find zero in first window=this is done for comaparison theerfore 1st window calc before
        for(int i=0;i<oneCount;i++){
            if(nums[i]==0){
                currzero++;
            }
        }
        //solve for rem. window
        minswaps=currzero;
       int s=0,e=oneCount-1;
       int n=nums.length;
       while(s<n){
         if(nums[s]==0)
          currzero--;
         s++;
         e++;
         if(nums[e%n]==0)
          currzero++;
          //jitne min zero uthe min swaps to make 1
         minswaps=Math.min(minswaps,currzero);
       }
       return minswaps;
    }
}