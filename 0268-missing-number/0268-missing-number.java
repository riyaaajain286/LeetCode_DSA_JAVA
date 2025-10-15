class Solution {
    public int missingNumber(int[] nums) {
        //range is 0 to n
  int xor1=0;
  int n=nums.length;
  int xor2=0;
  for(int i=0;i<n;i++){
    xor2^=nums[i];//value
   xor1^=i;//index
  }
  xor1^=n;
  return xor1^xor2;
    }
}