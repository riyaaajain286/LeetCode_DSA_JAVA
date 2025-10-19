class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int negind=1;
        int posind=0;
        int [] res=new int[n];
        for(int i=0;i<n;i++){
           if(nums[i]>0){
            res[posind]=nums[i];
            posind+=2;
           }
           else{
            res[negind]=nums[i];
            negind+=2;
           }
        }
        return res;
    }
}