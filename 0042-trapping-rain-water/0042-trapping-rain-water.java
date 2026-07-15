class Solution {
    //2 pointer approach
    public int trap(int[] height) {
       int lmax=0,rmax=0;
       int l=0,r=height.length-1;
       int totalWater=0;
       while(l<r){
        lmax=Math.max(lmax,height[l]);
        rmax=Math.max(rmax,height[r]);
        if(lmax<rmax){
          totalWater+=lmax-height[l];
          l++;
        }
        else{
          totalWater+=rmax-height[r];
          r--;
        }
       }
        return totalWater;
    }
}