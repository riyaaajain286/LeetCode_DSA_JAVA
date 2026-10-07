class Solution {
    public int maxArea(int[] height) {
        int low=0;
        int n=height.length;
        int high=n-1;
        int maxArea=Integer.MIN_VALUE;
        while(low<=high){
            int area=Math.min(height[low],height[high])*(high-low);
             maxArea=Math.max(maxArea,area);
             if(height[low]<height[high])
                low++;
             else
               high--;
        }
        return maxArea;
    }
}