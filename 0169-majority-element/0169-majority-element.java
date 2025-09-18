class Solution {
    public int majorityElement(int[] nums) {
    int cand=0;
    int c=0;
    for(int i=0;i<nums.length;i++){
         if(c==0){
            cand=nums[i];
        }
        if(cand==nums[i]){
            c++;
        }
        else{
            c--;
        }
       
    }
    return cand;
    }
}