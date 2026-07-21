class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int maxWater=Integer.MIN_VALUE;
        while(l<=r){
           int area=Math.min(height[l],height[r])*(r-l);
           maxWater=Math.max(maxWater,area);
           if(height[l]<height[r]){
            l++;
           }
           else{
            r--;
           }
        }
        return maxWater;
    }
}