class Solution {
    public int largestAltitude(int[] gain) {
        int currsum=0;
        int highest=0;
        for(int g:gain){
            currsum=currsum+g;
            highest=Math.max(highest,currsum);
        }
        return highest;
    }
}